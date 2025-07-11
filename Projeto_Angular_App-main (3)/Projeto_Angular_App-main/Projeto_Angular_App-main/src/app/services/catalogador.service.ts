import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { Catalogador } from '../models/catalogador.model';
@Injectable({
  providedIn: 'root'
})
export class CatalogadorService {
  private apiUrl = 'http://localhost:8080/catalogador';

  constructor(private http: HttpClient) { }

  listar(): Observable<Catalogador[]> {
    return this.http.get<Catalogador[]>(this.apiUrl);
  }

  adicionar(catalogador: Catalogador): Observable<Catalogador> {
    return this.http.post<Catalogador>(this.apiUrl, catalogador);
  }

  atualizar(id: number, data: any): Observable<any> {
    return this.http.put<Catalogador>(`${this.apiUrl}/${id}`, data);
  }

  excluir(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
