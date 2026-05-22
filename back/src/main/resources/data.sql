INSERT INTO students (id, active, apellido, dni, email, nombre) VALUES
  (1, true, 'Messi', 30111222, 'lionel.messi@seleccion.test', 'Lionel'),
  (2, true, 'Di Maria', 31222333, 'angel.dimaria@seleccion.test', 'Angel'),
  (3, true, 'Martinez', 32333444, 'emiliano.martinez@seleccion.test', 'Emiliano'),
  (4, true, 'De Paul', 33444555, 'rodrigo.depaul@seleccion.test', 'Rodrigo'),
  (5, true, 'Paredes', 34555666, 'leandro.paredes@seleccion.test', 'Leandro'),
  (6, true, 'Mac Allister', 35666777, 'alexis.macallister@seleccion.test', 'Alexis'),
  (7, true, 'Alvarez', 36777888, 'julian.alvarez@seleccion.test', 'Julian'),
  (8, true, 'Fernandez', 37888999, 'enzo.fernandez@seleccion.test', 'Enzo');

INSERT INTO materia (id, activo, nombre) VALUES
  (1, true, 'Matematica'),
  (2, true, 'Lengua'),
  (3, true, 'Historia'),
  (4, true, 'Geografia'),
  (5, true, 'Fisica');

INSERT INTO puntajes (id, activo, estudiante_id, fecha_puntaje, materia_id, valor) VALUES
  (1, true, 1, '2026-05-01 09:00:00', 1, 10.0),
  (2, true, 1, '2026-05-03 10:30:00', 2, 9.5),
  (3, true, 1, '2026-05-05 11:15:00', 3, 10.0),
  (4, true, 2, '2026-05-01 09:30:00', 1, 8.5),
  (5, true, 2, '2026-05-04 10:00:00', 4, 9.0),
  (6, true, 3, '2026-05-02 08:45:00', 2, 7.5),
  (7, true, 3, '2026-05-06 12:00:00', 5, 8.0),
  (8, true, 4, '2026-05-02 09:15:00', 1, 8.0),
  (9, true, 4, '2026-05-07 10:45:00', 3, 7.0),
  (10, true, 5, '2026-05-03 11:00:00', 2, 8.5),
  (11, true, 5, '2026-05-08 09:20:00', 5, 7.5),
  (12, true, 6, '2026-05-04 08:30:00', 1, 9.0),
  (13, true, 6, '2026-05-09 10:10:00', 4, 8.0),
  (14, true, 7, '2026-05-05 09:40:00', 3, 8.5),
  (15, true, 7, '2026-05-10 11:30:00', 5, 9.5),
  (16, true, 8, '2026-05-06 08:50:00', 1, 9.0),
  (17, true, 8, '2026-05-11 10:25:00', 2, 8.0);
