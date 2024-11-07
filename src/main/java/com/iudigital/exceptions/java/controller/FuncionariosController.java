package com.iudigital.exceptions.java.controller;

import com.iudigital.exceptions.java.data.FuncionariosDao;
import com.iudigital.exceptions.java.domain.Funcionarios;

import java.sql.SQLException;
import java.util.List;

public class FuncionariosController {

    private FuncionariosDao funcionariosDao;

    public FuncionariosController() {
        funcionariosDao = new FuncionariosDao();
    }

    public List<Funcionarios> getAllFuncionarios() throws SQLException {
        return funcionariosDao.getAllFuncionarios();
    }

    public void createFuncionario(Funcionarios funcionario) throws SQLException {
        funcionariosDao.createFuncionario(funcionario);
    }

    public Funcionarios getOneFuncionario(int idPersona) throws SQLException {
        return funcionariosDao.getOneFuncionario(idPersona);
    }

    public void updateFuncionario(Funcionarios funcionario, int idPersona) throws SQLException {
        funcionariosDao.updateFuncionario(funcionario, idPersona);
    }

    public void deleteFuncionario(int idFuncionario) throws SQLException {
        funcionariosDao.deleteFuncionario(idFuncionario);
    }
}
