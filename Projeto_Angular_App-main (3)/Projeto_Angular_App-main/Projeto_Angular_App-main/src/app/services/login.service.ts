import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LoginResponse } from '../types/login-response.type';
import { tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  apiUrl: string = "http://localhost:8080"

  constructor(private httpClient: HttpClient) { }

  login(email: string, password: string, role: string){
    return this.httpClient.post<LoginResponse>(this.apiUrl + "/login", { email, password, role }).pipe(
      tap((value) => {
        if (value) {
          sessionStorage.setItem("accessToken", value.accessToken);
        }
      })
    );
  }
  signup(name: string, email: string, password: string, role: string){
    return this.httpClient.post<LoginResponse>(this.apiUrl + "/register", { name, email, password, role }).pipe(
      tap((value) => {
        if (value) {
          sessionStorage.setItem("username", value.name);
        }
      })
    );
  }
}
