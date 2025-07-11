import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { FamiliaService } from '../../../services/familia.service';
import { CoreService } from '../../../core/core.service';
import { FamiliaAddEditComponent } from '../familia-add-edit/familia-add-edit.component';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatDialogModule } from '@angular/material/dialog';

@Component({
  selector: 'app-familia',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    MatButtonModule,
    MatInputModule,
    MatFormFieldModule,
    MatIconModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    MatSnackBarModule,
    MatDialogModule
  ],
  templateUrl: './familia.component.html',
  styleUrls: ['./familia.component.scss']
})
export class FamiliaComponent implements OnInit {
  displayedColumns: string[] = ['id', 'familia', 'action'];
  dataSource: MatTableDataSource<any> = new MatTableDataSource();

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(
    private _dialog: MatDialog,
    private _familiaService: FamiliaService,
    private _coreService: CoreService
  ) {}

  ngOnInit(): void {
    this.restorePageState();
    this.getFamiliaList();
  }

  openAddEditEmpForm() {
    const dialogRef = this._dialog.open(FamiliaAddEditComponent);
    dialogRef.afterClosed().subscribe({
      next: (val: any) => {
        if (val) {
          this.getFamiliaList();
        }
      },
    });
  }

  restorePageState() {
    const savedState = JSON.parse(sessionStorage.getItem('familiaPageState') || '{}');
    if (savedState.filter) {
      this.applyFilter({ target: { value: savedState.filter } } as any);
    }
    if (savedState.pageIndex !== undefined && savedState.pageSize !== undefined) {
      if (this.paginator) {
        this.paginator.pageIndex = savedState.pageIndex;
        this.paginator.pageSize = savedState.pageSize;
      }
    }
  }

  getFamiliaList() {
    this._familiaService.listar().subscribe({
      next: (res: any[]) => {
        this.dataSource = new MatTableDataSource(res);
        this.dataSource.sort = this.sort;
        this.dataSource.paginator = this.paginator;
      },
      error: (err: any) => {
        console.error('Error fetching data:', err);
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

  deleteFamilia(id: number) {
    this._familiaService.excluir(id).subscribe({
      next: () => {
        this._coreService.openSnackBar('Familia deleted!', 'done');
        this.getFamiliaList();
      },
      error: (err: any) => {
        console.error('Error deleting data:', err);
      }
    });
  }

  openEditForm(data: any) {
    const dialogRef = this._dialog.open(FamiliaAddEditComponent, {
      data,
    });

    dialogRef.afterClosed().subscribe({
      next: (val: any) => {
        if (val) {
          this.getFamiliaList();
        }
      },
    });
  }
}
