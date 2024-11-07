package com.iudigital.exceptions.java.presentacion;

import com.iudigital.exceptions.java.controller.PersonaController;
import com.iudigital.exceptions.java.domain.Persona;

import com.iudigital.exceptions.java.controller.FuncionariosController;
import com.iudigital.exceptions.java.domain.Funcionarios;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExceptionsJava {

    public static void getPersonaList(FuncionariosController funcionariosController) {
        try {
            List<Funcionarios> funcionarios = funcionariosController.getAllFuncionarios();
            if (funcionarios.isEmpty()) {
                System.out.println("No hay datos");
            } else {
                funcionarios.forEach(persona -> {
                    System.out.println("Id: " + persona.getIdPersona());
                    System.out.println("Marca: " + persona.getNombres());
                    System.out.println("Modelo: " + persona.getFechaNacimiento());
                    System.out.println("Año: " + persona.getTelefono());
                    System.out.println("identificacion: " + persona.getIdentificacion());
                    System.out.println("Id Funcionario: " + persona.getIdFuncionario());

//                    System.out.println("Transmision: " + car.getTransmission());
//                    System.out.println("Color: " + car.getColor());
                    System.out.println("================================= ");
                    System.out.println("================================= ");
                    System.out.println("================================= ");

                });
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void guardarFuncionarioDesdeFormulario() {

        try {
            Funcionarios funcionario = new Funcionarios();
            FuncionariosController funcionariosController = new FuncionariosController();

            PersonaController personaController = new PersonaController();

            funcionario.setNombres("maria");
            funcionario.setApellidos("perez");
            funcionario.setDireccion("calle 45");
            funcionario.setEstadoCivil("Soltero");
            funcionario.setTipoIdentificacion("CC");
            funcionario.setTelefono("80000");

            funcionario.setSexo("Masculino");
            funcionario.setFechaNacimiento(LocalDate.parse("2000-03-14"));

            System.out.println("nacimiento" + funcionario.getFechaNacimiento());

            funcionario.setIdentificacion(9090);

            personaController.createPersona(funcionario);
            System.out.println("ultimo" + personaController.obtenerUltimoIdPersona());

            funcionario.setIdPersona(personaController.obtenerUltimoIdPersona());
            System.out.println("valor de funcionario" + funcionario.getIdPersona());
            funcionariosController.createFuncionario(funcionario);

        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void updateFuncionarioDesdeFormulario() {
        try {
            Funcionarios funcionario = new Funcionarios();
            FuncionariosController funcionariosController = new FuncionariosController();

            PersonaController personaController = new PersonaController();

            funcionario.setNombres("maria");
            funcionario.setApellidos("perez");
            funcionario.setDireccion("calle 45");
            funcionario.setEstadoCivil("Soltero");
            funcionario.setTipoIdentificacion("CC");
            funcionario.setTelefono("80000");

            funcionario.setSexo("Masculino");
            funcionario.setFechaNacimiento(LocalDate.parse("2000-03-14"));

            System.out.println("nacimiento" + funcionario.getFechaNacimiento());

            funcionario.setIdentificacion(9090);

            personaController.createPersona(funcionario);
            System.out.println("ultimo" + personaController.obtenerUltimoIdPersona());

            funcionario.setIdPersona(personaController.obtenerUltimoIdPersona());
            System.out.println("valor de funcionario" + funcionario.getIdPersona());
            funcionariosController.createFuncionario(funcionario);

        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        try {
            FuncionariosController funcionariosController = new FuncionariosController();
            getPersonaList(funcionariosController);

            guardarFuncionarioDesdeFormulario();

            System.out.println(funcionariosController.getOneFuncionario(2).getNombres());

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
