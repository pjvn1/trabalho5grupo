import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { DefaultLoginLayoutComponent } from '../../components/default-login-layout/default-login-layout.component';
import { PrimaryInputComponent } from '../../components/primary-input/primary-input.component';
import { LoginService } from '../../services/login.service';
import { ToastrService } from 'ngx-toastr';

interface LoginForm {
  email: FormControl;
  password: FormControl;
  role: FormControl;
}

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    DefaultLoginLayoutComponent,
    ReactiveFormsModule,
    PrimaryInputComponent
  ],
  providers: [LoginService],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent implements OnInit {
  loginForm!: FormGroup<LoginForm>;

  constructor(
    private router: Router,
    private loginService: LoginService,
    private toastService: ToastrService
  ) {
    this.loginForm = new FormGroup({
      email: new FormControl('', [Validators.required, Validators.email]),
      password: new FormControl('', [Validators.required, Validators.minLength(6)]),
      role: new FormControl('', [Validators.required])
    });
  }

  ngOnInit(): void {
    // Redirecionamento automático para /catalogador
    this.router.navigate(['/catalogador']);
  }

  submit(): void {
    this.loginService.login(
      this.loginForm.value.email,
      this.loginForm.value.password,
      this.loginForm.value.role
    ).subscribe({
      next: () => {
        this.router.navigate(['/user']);
        this.toastService.success('Login feito com sucesso!');
      },
      error: () => {
        this.toastService.error('Erro inesperado! Tente novamente mais tarde');
      }
    });
  }

  navigate(): void {
    this.router.navigate(['signup']);
  }
}
