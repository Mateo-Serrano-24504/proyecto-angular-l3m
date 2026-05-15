import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

export interface Alumno {
    nombre: string,
    apellido: string,
    dni: string,
    email: string,
}

export interface PaginaAlumno {
    size: number,
    index: number,
    pageCount: number,
    items: Alumno[]
}

@Injectable({
    providedIn: 'root'
})

export class AlumnoService {
    private BASE_URL = 'http://localhost:8080/api/students'

    constructor(private http: HttpClient) { }

    getAlumnos(page: number, size: number): Observable<PaginaAlumno> {
        return this.http.get<PaginaAlumno>(`${this.BASE_URL}?index=${page}&size=${size}`);
    }

    crearAlumno(nuevoAlumno: Alumno): Observable<Alumno> {
        return this.http.post<Alumno>(`${this.BASE_URL}/alumno`, nuevoAlumno);
    }
}