import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

export interface Materia {
  id: number;
  nombre: string;
}

export interface MateriaRequest {
  nombre: string;
}

export interface PaginaMaterias {
    size: number,
    index: number,
    pageCount: number,
    items: Materia[]
}

@Injectable({
  providedIn: 'root'
})
export class MateriaService {
  private BASE_URL = 'http://localhost:8080/api/materias';

  constructor(private http: HttpClient) {}

  obtenerMaterias(page : number, size: number): Observable<PaginaMaterias> {
    return this.http.get<PaginaMaterias>(`${this.BASE_URL}?index=${page}&size=${size}`);
  }
  obtenerTodasLasMaterias(): Observable<Materia[]>{
    return this.http.get<Materia[]>(`${this.BASE_URL}/todos`);
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