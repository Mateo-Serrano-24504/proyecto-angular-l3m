import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Alumno } from "./alumno.service";

export interface ChartResponse{
    labels : string[];
    data: number[];
}
export interface PuntajeEstudiante {
  id?: number;
  materiaId: number;
  materia: string;
  valor: number;
}



@Injectable({
  providedIn: 'root'
})

export class EstudiantesService{
    private apiUrl = 'http://localhost:8080/api'

    constructor(private http: HttpClient){}

    getChart(id: Number | null): Observable<ChartResponse> {
      const idField = id == null ? "" : `/${id}`;
      return this.http.get<ChartResponse>(`${this.apiUrl}/puntajes/chart` + idField)
    }

    getEstudiantePorId(id: number): Observable<Alumno> {
      return this.http.get<Alumno>(`${this.apiUrl}/students/${id}`);
    }
}