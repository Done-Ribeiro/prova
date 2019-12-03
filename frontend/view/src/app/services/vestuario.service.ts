import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Vestuario } from '../model/vestuario.module';

const url = 'http://localhost:8080/vestuario';
const httpOptions = {
  headers: new HttpHeaders({'content-Type': 'aplication/json'})
};

@Injectable({
  providedIn: 'root'
})
export class VestuarioService {

  constructor(private http: HttpClient) { }

  consultar (): Observable<Vestuario[]> {
    return this.http.get<Vestuario[]>(url);
  }

  consultarPorId (id: number): Observable<Vestuario> {
    const urlLocal = `${url}/${id}`;
    return this.http.get<Vestuario>(urlLocal);
  }

  adicionar (Vestuario): Observable<Vestuario> {
    return this.http.post<Vestuario>(url, Vestuario);
  }

  alterar (id, Vestuario): Observable<any> {
    const urlLocal = `${url}/${id}`;
    return this.http.put<Vestuario>(urlLocal, Vestuario);
  }

  excluir (id): Observable<Vestuario> {
    const urlLocal = `${url}/${id}`;
    return this.http.delete<Vestuario>(urlLocal);
  }

}