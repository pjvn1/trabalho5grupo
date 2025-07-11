import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { Familia } from '../models/familia.model';
@Injectable({
  providedIn: 'root'
})
export class FamiliaService {
  private apiUrl = 'http://localhost:8080/familia';

  constructor(private http: HttpClient) { }

  listar(): Observable<Familia[]> {
    return this.http.get<Familia[]>(this.apiUrl);
  }

  adicionar(familia: Familia): Observable<Familia> {
    return this.http.post<Familia>(this.apiUrl, familia);
  }

  atualizar(id: number, data: any): Observable<any> {
    return this.http.put<Familia>(`${this.apiUrl}/${id}`, data);
  }

  excluir(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
