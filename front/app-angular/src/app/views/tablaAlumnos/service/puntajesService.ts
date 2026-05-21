import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

export interface RegistrarPuntaje {
  estudianteId: number;
  materiaId: number;
  valor: number;
}

export interface Puntaje {
  id?: number;
  valor: number;
}

export interface Materia {
  id: number;
  nombre: string;
}

@Injectable({
  providedIn: 'root'
})
export class PuntajeService {
  private BASE_URL = 'http://localhost:8080/api/puntajes';

  constructor(private http: HttpClient) {}

  registrarPuntaje(puntaje: RegistrarPuntaje): Observable<Puntaje> {
    return this.http.post<Puntaje>(this.BASE_URL, puntaje);
  }

  obtenerMaterias(): Observable<Materia[]> {
  return this.http.get<Materia[]>('http://localhost:8080/api/materias/listar');
  }


  
  //Listar Materias method

  
}