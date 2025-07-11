import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { Classe } from '../models/classe.model';
@Injectable({
  providedIn: 'root'
})
export class ClasseService {
  private apiUrl = 'http://localhost:8080/classe';

  constructor(private http: HttpClient) { }

  listar(): Observable<Classe[]> {
    return this.http.get<Classe[]>(this.apiUrl);
  }

  adicionar(classe: Classe): Observable<Classe> {
    return this.http.post<Classe>(this.apiUrl, classe);
  }

  atualizar(id: number, data: any): Observable<any> {
    return this.http.put<Classe>(`${this.apiUrl}/${id}`, data);
  }

  excluir(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
