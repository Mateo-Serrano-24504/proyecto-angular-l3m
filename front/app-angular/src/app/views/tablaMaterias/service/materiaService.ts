import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

export interface Materia {
  id: number;
  nombre: string;
}

@Injectable({
  providedIn: 'root'
})
export class MateriaService {
  private BASE_URL = 'http://localhost:8080/api/materias';

  constructor(private http: HttpClient) {}

  getMaterias(): Observable<Materia[]> {
    return this.http.get<Materia[]>(this.BASE_URL);
  }
}
