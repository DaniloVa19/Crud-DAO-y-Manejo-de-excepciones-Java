-- Insertar datos en la tabla Grupo_Familiar
INSERT INTO "Grupo_Familiar" (nombre_grupo_familiar) VALUES
('Familia Pérez'),
('Familia Gómez López'),
('Familia Rodríguez'),
('Familia Sánchez'),
('Familia Torres'),
('Familia González Pérez');

-- Insertar datos en la tabla Persona (incluyendo los funcionarios)
INSERT INTO "Persona" (nombres, apellidos, tipo_identificacion, numero_identificacion, direccion, estado_civil, sexo, telefono, fecha_nacimiento) VALUES
('Juan Carlos', 'Pérez Cruz', 'DNI', '12345678', 'Calle Falsa 123', 'Soltero', 'Masculino', '987654321', '1990-01-01'),  -- Funcionario
('María José', 'Gómez López', 'DNI', '87654321', 'Avenida Siempre Viva 742', 'Casada', 'Femenino', '987654322', '1985-05-05'),  -- Funcionario
('Carlos Alberto', 'Rodríguez García', 'RUC', '12345678901', 'Calle de la Paz 456', 'Soltero', 'Masculino', '987654323', '1992-03-03'),  -- Funcionario
('Ana María', 'López Ruiz', 'DNI', '23456789', 'Calle Libertad 789', 'Divorciada', 'Femenino', '987654324', '1988-07-07'),  -- Funcionario
('Luis Fernando', 'Sánchez Jiménez', 'DNI', '34567890', 'Calle Esperanza 321', 'Soltero', 'Masculino', '987654325', '1995-09-09'),  -- Funcionario
('Laura Isabel', 'Torres García', 'DNI', '45678901', 'Calle Amistad 654', 'Viuda', 'Femenino', '987654326', '1980-12-12'),  -- Funcionario
('Pedro Pablo', 'Pérez Cruz', 'DNI', '56789012', 'Calle Unión 111', 'Soltero', 'Masculino', '987654327', '1993-08-08'),  -- Hijo
('Lucía Fernanda', 'González Pérez', 'DNI', '67890123', 'Calle Solidaridad 222', 'Casada', 'Femenino', '987654328', '1987-02-02'),  -- Hijo
('Roberto Carlos', 'Díaz Hernández', 'DNI', '78901234', 'Calle Libertad 333', 'Divorciado', 'Masculino', '987654329', '1991-04-04'),  -- Hijo
('Carmen Elisa', 'Cruz Fernández', 'DNI', '89012345', 'Calle Esperanza 444', 'Viuda', 'Femenino', '987654330', '1982-06-06'),  -- Madre
('Andrés Felipe', 'Gómez López', 'DNI', '90123456', 'Avenida Siempre Viva 742', 'Casado', 'Masculino', '987654331', '1983-09-09');  -- Padre

-- Insertar datos en la tabla Personas_Grupos_Familiares_Relacion
-- Grupo Familiar: Familia Pérez
INSERT INTO "Personas_Grupos_Familiares_Relacion" (id_persona, id_grupo_familiar, rol_en_el_grupo_familiar) VALUES
(1, 1, 'Hijo'),    -- Juan Carlos Pérez Cruz
(10, 1, 'Madre'),         -- Carmen Elisa Cruz Fernández
(7, 1, 'Hijo');           -- Pedro Pablo Pérez Cruz

-- Grupo Familiar: Familia Gómez López
INSERT INTO "Personas_Grupos_Familiares_Relacion" (id_persona, id_grupo_familiar, rol_en_el_grupo_familiar) VALUES
(2, 2, 'Madre'),          -- María José Gómez López
(11, 2, 'Padre'),         -- Andrés Felipe Gómez López
(11, 2, 'Hijo'),          -- Lucía Fernanda González Pérez
(9, 2, 'Hijo');          -- Roberto Carlos Díaz Hernández

-- Grupo Familiar: Familia Rodríguez
INSERT INTO "Personas_Grupos_Familiares_Relacion" (id_persona, id_grupo_familiar, rol_en_el_grupo_familiar) VALUES
(3, 3, 'Funcionario'),    -- Carlos Alberto Rodríguez García
(7, 3, 'Hijo'),           -- Pedro Pablo Martínez González
(8, 3, 'Hijo');           -- Lucía Fernanda González Pérez

-- Grupo Familiar: Familia Sánchez
INSERT INTO "Personas_Grupos_Familiares_Relacion" (id_persona, id_grupo_familiar, rol_en_el_grupo_familiar) VALUES
(4, 4, 'Madre'),          -- Ana María López Ruiz
(9, 4, 'Hijo'),           -- Roberto Carlos Díaz Hernández
(10, 4, 'Hijo');          -- Pedro Pablo Martínez González

-- Grupo Familiar: Familia Torres
INSERT INTO "Personas_Grupos_Familiares_Relacion" (id_persona, id_grupo_familiar, rol_en_el_grupo_familiar) VALUES
(5, 5, 'Funcionario'),    -- Luis Fernando Sánchez Jiménez
(7, 5, 'Hijo'),           -- Pedro Pablo Martínez González
(9, 5, 'Hijo');          -- Roberto Carlos Díaz Hernández

-- Grupo Familiar: Familia González Pérez
INSERT INTO "Personas_Grupos_Familiares_Relacion" (id_persona, id_grupo_familiar, rol_en_el_grupo_familiar) VALUES
(6, 6, 'Madre'),          -- Laura Isabel Torres García
(10, 6, 'Hijo'),           -- Pedro Pablo Martínez González
(11, 6, 'Hijo');          -- Lucía Fernanda González Pérez


-- Insertar Id de funcionarios

INSERT INTO "Funcionarios" (identificacion,id_persona) VALUES
(100,1),
(200,2),
(300,3),
(400,4),
(500,5),
(600,6);
