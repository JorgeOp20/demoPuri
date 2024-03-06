INSERT INTO proyecto (nombre, fecha_De_Creacion) VALUES
('Proyecto1', '2024-03-01'),
('Proyecto2', '2024-03-02'),
('Proyecto3', '2024-03-03');

INSERT INTO tarea (descripcion, fecha_Limite, orden, completada, proyecto_id) VALUES
('tarea1','2024-03-25',1, FALSE, 1),
('tarea2','2024-03-25',3, FALSE, 1),
('tarea3','2024-03-25',5, FALSE, 2),
('tarea4','2024-03-25',2, FALSE, 2),
('tarea5','2024-03-25',4, FALSE, 3);