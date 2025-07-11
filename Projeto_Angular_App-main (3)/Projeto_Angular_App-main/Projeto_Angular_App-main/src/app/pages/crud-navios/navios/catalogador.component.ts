import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { CatalogadorService } from '../../../services/catalogador.service';
import { CoreService } from '../../../core/core.service';
import { CatalogadorAddEditComponent } from '../navio-add-edit/catalogador-add-edit.component';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatSelectModule } from '@angular/material/select';
import { MatRadioModule } from '@angular/material/radio';
import { MatIconModule } from '@angular/material/icon';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatTableModule } from '@angular/material/table';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatPaginatorModule } from '@angular/material/paginator';

@Component({
  selector: 'app-catalogador',
  standalone: true,
  imports: [
    MatPaginatorModule,
    MatToolbarModule,
    MatTableModule,
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    MatButtonModule,
    MatInputModule,
    MatFormFieldModule,
    MatDatepickerModule,
    MatSelectModule,
    MatRadioModule,
    MatIconModule,
    MatSnackBarModule,
  ],
  templateUrl: './catalogador.component.html',
  styleUrls: ['./catalogador.component.scss']
})
export class CatalogadorComponent implements OnInit {
  displayedColumns: string[] = [
    "id",
    "nome",
    "actions"
  ];
  dataSource!: MatTableDataSource<any>;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  constructor(
    private _dialog: MatDialog,
    private _catalogadorService: CatalogadorService,
    private _coreService: CoreService
  ) {}
  ngOnInit(): void {
    this.restorePageState();
    this.getCatalogadorList();
  }
  openAddEditEmpForm() {
    const dialogRef = this._dialog.open(CatalogadorAddEditComponent);
    dialogRef.afterClosed().subscribe({
      next: (val: any) => {
        if (val) {
          this.getCatalogadorList();
        }
      },
    });
  }

  restorePageState() {
    const savedState = JSON.parse(sessionStorage.getItem('catalogadorPageState') || '{}');
    if (savedState.filter) {
      this.applyFilter({ target: { value: savedState.filter } } as any);
    }
    if (savedState.pageIndex && savedState.pageSize) {
      if (this.paginator) {
        this.paginator.pageIndex = savedState.pageIndex;
        this.paginator.pageSize = savedState.pageSize;
      }
    }
  }
  getCatalogadorList() {
    this._catalogadorService.listar().subscribe({
      next: (res: any[]) => {
        this.dataSource = new MatTableDataSource(res);
        this.dataSource.sort = this.sort;
        this.dataSource.paginator = this.paginator;
      },
      error: (err: any) => {
        console.log(err);
      }
    });
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  deleteCatalogador(id: number) {
    this._catalogadorService.excluir(id).subscribe({
      next: () => {
        this._coreService.openSnackBar('Catalogador deleted!', 'done');
        this.getCatalogadorList();
      },
      error: (err: any) => {
        console.log(err);
      }
    });
  }

  openEditForm(data: any) {
    const dialogRef = this._dialog.open(CatalogadorAddEditComponent, {
      data,
    });

    dialogRef.afterClosed().subscribe({
      next: (val: any) => {
        if (val) {
          this.getCatalogadorList();
        }
      },
    });
  }
}
