import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

export interface Materia {
  id: number;
  nombre: string;
}

export interface MateriaRequest {
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

  crearMateria(materia: MateriaRequest): Observable<number> {
    return this.http.post<number>(this.BASE_URL, materia);
  }

  actualizarMateria(id: number, materia: Materia): Observable<Materia> {
    return this.http.put<Materia>(`${this.BASE_URL}/${id}`, materia);
  }

  eliminarMateria(id: number): Observable<void> {
    return this.http.delete<void>(`${this.BASE_URL}/${id}`);
  }
}
