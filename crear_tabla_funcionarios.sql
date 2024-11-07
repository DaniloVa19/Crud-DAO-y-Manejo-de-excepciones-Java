CREATE TABLE "Grupo_Familiar" (
  "id_grupo_familiar" SERIAL PRIMARY KEY,
  "nombre_grupo_familiar" VARCHAR(255) NOT NULL
);



CREATE TABLE "Persona" (
  "id_persona" SERIAL PRIMARY KEY,
  "nombres" VARCHAR(255) NOT NULL,
  "apellidos" VARCHAR(255) NOT NULL,
  "tipo_identificacion" VARCHAR(50),
  "numero_identificacion" VARCHAR(50),  -- Considera que puede tener letras
  "direccion" VARCHAR(255),
  "estado_civil" VARCHAR(50),
  "sexo" VARCHAR(10),
  "telefono" VARCHAR(15),  -- Cambiado a VARCHAR para incluir formatos
  "fecha_nacimiento" DATE
);

CREATE TABLE "Personas_Grupos_Familiares_Relacion" (
  "id_personas_grupos_familiares" SERIAL PRIMARY KEY,
  "id_persona" INT NOT NULL,
  "id_grupo_familiar" INT NOT NULL,
  "rol_en_el_grupo_familiar" VARCHAR(255),
  CONSTRAINT "FK_Personas_Grupos_Familiares_Relacion_id_grupo_familiar"
    FOREIGN KEY ("id_grupo_familiar")
      REFERENCES "Grupo_Familiar"("id_grupo_familiar")
      ON DELETE cascade,
  CONSTRAINT "FK_Personas_Grupos_Familiares_Relacion_id_persona"
  	FOREIGN KEY ("id_persona")
  		REFERENCES "Persona"("id_persona")
  		
);

CREATE TABLE "Funcionarios" (

  "id_funcionario" SERIAL PRIMARY KEY,
  "identificacion" INT NOT null,   
  "id_persona" INT NOT null,
  UNIQUE("id_persona"),
  CONSTRAINT "FK_Funcionarios_Relacion_Persona" FOREIGN KEY("id_persona") REFERENCES "Persona"("id_persona")
);



