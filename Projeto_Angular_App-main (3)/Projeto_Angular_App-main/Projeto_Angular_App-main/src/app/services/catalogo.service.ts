import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { Catalogo } from '../models/catalogo.model';
@Injectable({
  providedIn: 'root'
})
export class CatalogoService {
  private apiUrl = 'http://localhost:8080/catalogo';

  constructor(private http: HttpClient) { }

  listar(): Observable<Catalogo[]> {
    return this.http.get<Catalogo[]>(this.apiUrl);
  }

  adicionar(catalogo: Catalogo): Observable<Catalogo> {
    return this.http.post<Catalogo>(this.apiUrl, catalogo);
  }

  atualizar(id: number, data: any): Observable<any> {
    return this.http.put<Catalogo>(`${this.apiUrl}/${id}`, data);
  }

  excluir(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
