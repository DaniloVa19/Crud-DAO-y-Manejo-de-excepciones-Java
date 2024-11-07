package com.iudigital.exceptions.java.data;

import com.iudigital.exceptions.java.domain.Funcionarios;
import com.iudigital.exceptions.java.domain.Persona;
import com.iudigital.exceptions.java.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iudigital.exceptions.java.data.PersonaDao;

public class FuncionariosDao {

    private static final String GET_FUNCIONARIOS = "SELECT * FROM \"Persona\" as P INNER JOIN \"Funcionarios\" as F on P.id_persona  = F.id_persona";

    private static final String CREATE_FUNCIONARIO = "INSERT INTO \"Funcionarios\" (identificacion,id_persona) VALUES (?, ?)";

    private static final String UPDATE_FUNCIONARIO = "UPDATE \"Funcionarios\" set identificacion =?, id_persona=?";

    private static final String GET_FUNCIONARIO_BY_ID = "SELECT * FROM \"Persona\" as P INNER JOIN \"Funcionarios\" as F on P.id_persona  = F.id_persona where F.id_persona = ? ";

    private static final String DELETE_FUNCIONARIO = "delete from \"Funcionarios\" where idFuncionario = ? ";

    public List<Funcionarios> getAllFuncionarios() throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Funcionarios> funcionarios = new ArrayList<>();

        try {

            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_FUNCIONARIOS);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Funcionarios funcionario = new Funcionarios();
                funcionario.setIdPersona(resultSet.getInt("id_persona"));
                funcionario.setNombres(resultSet.getString("nombres"));
                funcionario.setApellidos(resultSet.getString("apellidos"));
                funcionario.setTipoIdentificacion(resultSet.getString("tipo_identificacion"));

                funcionario.setNumeroIdentificacion(resultSet.getString("numero_identificacion"));
                funcionario.setDireccion(resultSet.getString("direccion"));
                funcionario.setEstadoCivil(resultSet.getString("estado_civil"));
                funcionario.setSexo(resultSet.getString("sexo"));
                funcionario.setTelefono(resultSet.getString("telefono"));
                funcionario.setFechaNacimiento(resultSet.getDate("fecha_nacimiento").toLocalDate());

                funcionario.setIdentificacion(resultSet.getInt("identificacion"));
                funcionario.setIdFuncionario(resultSet.getInt("id_funcionario"));

                funcionarios.add(funcionario);
            }
            return funcionarios;

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

    public void createFuncionario(Funcionarios funcionario) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareCall(CREATE_FUNCIONARIO);
            preparedStatement.setInt(1, funcionario.getIdentificacion());
            preparedStatement.setInt(2, funcionario.getIdPersona());

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

    public Funcionarios getOneFuncionario(int idPersona) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Funcionarios funcionario = null;

        try {

            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_FUNCIONARIO_BY_ID);
            preparedStatement.setInt(1, idPersona);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                funcionario = new Funcionarios();
                funcionario.setIdPersona(resultSet.getInt("id_persona"));
                funcionario.setNombres(resultSet.getString("nombres"));
                funcionario.setApellidos(resultSet.getString("apellidos"));
                funcionario.setTipoIdentificacion(resultSet.getString("tipo_identificacion"));

                funcionario.setNumeroIdentificacion(resultSet.getString("numero_identificacion"));
                funcionario.setDireccion(resultSet.getString("direccion"));
                funcionario.setEstadoCivil(resultSet.getString("estado_civil"));
                funcionario.setSexo(resultSet.getString("sexo"));
                funcionario.setTelefono(resultSet.getString("telefono"));
                funcionario.setFechaNacimiento(resultSet.getDate("fecha_nacimiento").toLocalDate());

                funcionario.setIdentificacion(resultSet.getInt("identificacion"));
                funcionario.setIdFuncionario(resultSet.getInt("id_funcionario"));
            }
            return funcionario;

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

    public void updateFuncionario(Funcionarios funcionario, int idPersona) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_FUNCIONARIO);
            preparedStatement.setInt(1, funcionario.getIdentificacion());
            preparedStatement.setInt(2, funcionario.getIdPersona());

            preparedStatement.setInt(3, idPersona);
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

    public void deleteFuncionario(int idFuncionario) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(DELETE_FUNCIONARIO);
            preparedStatement.setInt(1, idFuncionario);
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
}
