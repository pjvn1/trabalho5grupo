import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { ClasseService } from '../../../services/classe.service';
import { CoreService } from '../../../core/core.service';
import { ClasseAddEditComponent } from '../classe-add-edit/classe-add-edit.component';
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
  selector: 'app-classe',
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
  templateUrl: './classe.component.html',
  styleUrls: ['./classe.component.scss']
})
export class ClasseComponent implements OnInit {
  displayedColumns: string[] = ['id', 'classe', 'action'];
  dataSource: MatTableDataSource<any> = new MatTableDataSource();

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(
    private _dialog: MatDialog,
    private _classeService: ClasseService,
    private _coreService: CoreService
  ) {}

  ngOnInit(): void {
    this.restorePageState();
    this.getClasseList();
  }

  openAddEditEmpForm() {
    const dialogRef = this._dialog.open(ClasseAddEditComponent);
    dialogRef.afterClosed().subscribe({
      next: (val: any) => {
        if (val) {
          this.getClasseList();
        }
      },
    });
  }

  restorePageState() {
    const savedState = JSON.parse(sessionStorage.getItem('classePageState') || '{}');
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

  getClasseList() {
    this._classeService.listar().subscribe({
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

  deleteClasse(id: number) {
    this._classeService.excluir(id).subscribe({
      next: () => {
        this._coreService.openSnackBar('Class deleted!', 'done');
        this.getClasseList();
      },
      error: (err: any) => {
        console.log('Error deleting data:', err);
      }
    });
  }

  openEditForm(data: any) {
    const dialogRef = this._dialog.open(ClasseAddEditComponent, {
      data,
    });

    dialogRef.afterClosed().subscribe({
      next: (val: any) => {
        if (val) {
          this.getClasseList();
        }
      },
    });
  }
}
