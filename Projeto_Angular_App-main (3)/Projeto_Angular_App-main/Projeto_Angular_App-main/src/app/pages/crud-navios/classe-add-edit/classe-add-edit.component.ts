import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ClasseService } from '../../../services/classe.service';
import { CoreService } from '../../../core/core.service';
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
import { MatDialogModule } from '@angular/material/dialog';

@Component({
  selector: 'app-classe-add-edit',
  standalone: true,
  imports: [
    MatDialogModule,
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
    MatSnackBarModule
  ],
  templateUrl: './classe-add-edit.component.html',
  styleUrls: ['./classe-add-edit.component.scss']
})
export class ClasseAddEditComponent implements OnInit {
  empForm: FormGroup;

  constructor(
    private _fb: FormBuilder,
    private _classeService: ClasseService,
    private _dialogRef: MatDialogRef<ClasseAddEditComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private _coreService: CoreService
  ) {
      this.empForm = this._fb.group({

        nome: [''],

      });
    }

    preventNegative(event: KeyboardEvent): void {
      if (event.key === '-' || event.key === '+' || event.key === 'e') {
        event.preventDefault();
      }
    }

    ngOnInit(): void {
      if (this.data) {
        this.empForm.patchValue(this.data);
      }
    }

    getErrorMessage(formControlName: string): string {
      if (this.empForm.get(formControlName)?.hasError('required')) {
        return 'Campo obrigatório';
      }
      return '';
    }

    onFormSubmit() {
      console.log("m");
      if (this.empForm.valid) {
        console.log("m2");

        if (this.data) {
          console.log("m3");

          console.log(this.data);
          this._classeService.atualizar(this.data.id, this.empForm.value).subscribe({
            next: (val: any) => {
              this._coreService.openSnackBar('Detalhes da classe atualizados!');
              this._dialogRef.close(true);
            },
            error: (err: any) => {
              console.log(err);
            },
          });
        } else {
          console.log("asdasda");
          console.log(this.data);
          this._classeService.adicionar(this.empForm.value).subscribe({
            next: (val: any) => {
              this._coreService.openSnackBar('classssse adicionado com sucesso');
              this._dialogRef.close(true);
            },
            error: (err: any) => {
              console.log(err);
            },
          });
        }
      }
    }
  }
