INSERT INTO proyecto (id, nombre, fechaCreacion) VALUES
(1, 'Proyecto1', '2024-03-01'),
(2, 'Proyecto2', '2024-03-02'),
(3, 'Proyecto3', '2024-03-03');

INSERT INTO tarea (id, descripcion, fechaLimite, orden, completada, proyecto_id) VALUES
(1, 'tarea1','2024-03-25',1, FALSE, 1),
(2, 'tarea2','2024-03-25',3, FALSE, 1),
(3, 'tarea3','2024-03-25',5, FALSE, 2),
(4, 'tarea4','2024-03-25',2, FALSE, 2),
(5, 'tarea5','2024-03-25',4, FALSE, 3);