import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Alumno } from "../views/tablaAlumnos/service/alumnoServis";

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
    private apiUrl = 'http://localhost:8080/api/students'

    constructor(private http: HttpClient){}

    getChart():Observable<ChartResponse> {
        return this.http.get<ChartResponse>(`${this.apiUrl}/chart`)
    }

    getEstudiantePorId(id: number): Observable<Alumno> {
    return this.http.get<Alumno>(`${this.apiUrl}/${id}`);}
}