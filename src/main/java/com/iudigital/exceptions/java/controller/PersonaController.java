package com.iudigital.exceptions.java.controller;

import com.iudigital.exceptions.java.data.PersonaDao;
import com.iudigital.exceptions.java.domain.Persona;
import java.sql.SQLException;
import java.util.List;

public class PersonaController {

    private PersonaDao personaDao;

    public PersonaController() {
        personaDao = new PersonaDao();
    }

    public List<Persona> getAllPersonas() throws SQLException {
        return personaDao.getAllPersonas();
    }

    public void createPersona(Persona persona) throws SQLException {
        personaDao.createPersona(persona);
    }

    public Persona getOnePersona(int idPersona) throws SQLException {
        return personaDao.getOnePersona(idPersona);
    }

    public void updatePersona(Persona persona, int idPersona) throws SQLException {
        personaDao.updatePersona(persona, idPersona);
    }

    public void deletePersona(int idPersona) throws SQLException {
        personaDao.deletePersona(idPersona);
    }

    public int obtenerUltimoIdPersona() throws SQLException {
        return personaDao.obtenerUltimoIdPersona();
    }

}
