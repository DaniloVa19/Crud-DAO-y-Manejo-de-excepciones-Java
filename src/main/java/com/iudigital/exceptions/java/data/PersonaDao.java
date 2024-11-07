package com.iudigital.exceptions.java.data;

import com.iudigital.exceptions.java.domain.Persona;
import com.iudigital.exceptions.java.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonaDao {

    private static final String GET_PERSONAS = "SELECT * FROM \"Persona\"";

    private static final String CREATE_PERSONA = "insert into \"Persona\" (nombres, apellidos, tipo_identificacion, "
            + "numero_identificacion, direccion,estado_civil,sexo,telefono,fecha_nacimiento) values (?, ?, ?, ?, ?, ?, ?, ?,?::date)";

    private static final String GET_PERSONA_BY_ID = "select * from \"Persona\" where id_persona = ? ";

    private static final String UPDATE_PERSONA = "update \"Persona\" set nombres = ?, apellidos = ?, "
            + "tipo_identificacion = ?, direccion = ?, estado_civil = ?,sexo = ?,telefono = ?,fecha_nacimiento = ?::date where id_persona = ?";

    private static final String DELETE_PERSONA = "delete from \"Persona\" where id_persona = ? ";

    private static final String GET_PERSONA_LAST_ID = "SELECT * FROM \"Persona\" ORDER BY id_persona desc LIMIT 1";

    public List<Persona> getAllPersonas() throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Persona> personas = new ArrayList<>();

        try {

            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_PERSONAS);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Persona persona = new Persona();
                persona.setIdPersona(resultSet.getInt("id_persona"));
                persona.setNombres(resultSet.getString("nombres"));
                persona.setApellidos(resultSet.getString("apellidos"));
                persona.setTipoIdentificacion(resultSet.getString("tipo_identificacion"));

                persona.setNumeroIdentificacion(resultSet.getString("numero_identificacion"));
                persona.setDireccion(resultSet.getString("direccion"));
                persona.setEstadoCivil(resultSet.getString("estado_civil"));
                persona.setSexo(resultSet.getString("sexo"));
                persona.setTelefono(resultSet.getString("telefono"));
                persona.setFechaNacimiento(resultSet.getDate("fecha_nacimiento").toLocalDate());

                personas.add(persona);
            }
            return personas;

        } finally {

            if (connection != null) {
                connection.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (resultSet != null) {
                resultSet.close();
            }

        }
    }

    public void createPersona(Persona persona) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareCall(CREATE_PERSONA);
            preparedStatement.setString(1, persona.getNombres());
            preparedStatement.setString(2, persona.getApellidos());
            preparedStatement.setString(3, persona.getTipoIdentificacion());
            preparedStatement.setString(4, persona.getNumeroIdentificacion());
            preparedStatement.setString(5, persona.getDireccion());
            preparedStatement.setString(6, persona.getEstadoCivil());
            preparedStatement.setString(7, persona.getSexo());
            preparedStatement.setString(8, persona.getTelefono());
            preparedStatement.setString(9, persona.getFechaNacimiento().toString());

            preparedStatement.executeUpdate();

        } finally {
            if (connection != null) {
                connection.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    public Persona getOnePersona(int idPersona) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Persona persona = null;

        try {

            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_PERSONA_BY_ID);
            preparedStatement.setInt(1, idPersona);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                persona = new Persona();
                persona.setIdPersona(resultSet.getInt("id_persona"));
                persona.setNombres(resultSet.getString("nombres"));
                persona.setApellidos(resultSet.getString("apellidos"));
                persona.setTipoIdentificacion(resultSet.getString("tipo_identificacion"));

                persona.setNumeroIdentificacion(resultSet.getString("numero_identificacion"));
                persona.setDireccion(resultSet.getString("direccion"));
                persona.setEstadoCivil(resultSet.getString("estado_civil"));
                persona.setSexo(resultSet.getString("sexo"));
                persona.setTelefono(resultSet.getString("telefono"));
                persona.setFechaNacimiento(resultSet.getDate("fecha_nacimiento").toLocalDate());
            }
            return persona;

        } finally {

            if (connection != null) {
                connection.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (resultSet != null) {
                resultSet.close();
            }

        }
    }

    public void updatePersona(Persona persona, int idPersona) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_PERSONA);
            preparedStatement.setString(1, persona.getNombres());
            preparedStatement.setString(2, persona.getApellidos());
            preparedStatement.setString(3, persona.getTipoIdentificacion());
            preparedStatement.setString(4, persona.getNumeroIdentificacion());
            preparedStatement.setString(5, persona.getDireccion());
            preparedStatement.setString(6, persona.getEstadoCivil());
            preparedStatement.setString(7, persona.getSexo());
            preparedStatement.setString(8, persona.getTelefono());
            preparedStatement.setString(9, persona.getFechaNacimiento().toString());

            preparedStatement.setInt(10, idPersona);
            preparedStatement.executeUpdate();

        } finally {
            if (connection != null) {
                connection.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    public void deletePersona(int idPersona) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(DELETE_PERSONA);
            preparedStatement.setInt(1, idPersona);
            preparedStatement.executeUpdate();

        } finally {
            if (connection != null) {
                connection.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }

    }

    public int obtenerUltimoIdPersona() throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int id = 0 ;

        try {

            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_PERSONA_LAST_ID);

            resultSet=preparedStatement.executeQuery();
            
            if (resultSet.next()) {
            
            id =resultSet.getInt("id_persona");
            }
            
            

        } finally {
            if (connection != null) {
                connection.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }
            
            return id;
        }

        
    }
}
