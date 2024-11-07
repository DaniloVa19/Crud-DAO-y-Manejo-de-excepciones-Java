package com.iudigital.exceptions.java.domain;

public class PersonasGruposFamiliaresRelacion {

    private int idPersonasGruposFamiliaresRelacion;
    private int idPersona;
    private int idGrupoFamiliar;
    private String rolEnElGrupoFamiliar;

    public int getIdPersonasGruposFamiliaresRelacion() {
        return idPersonasGruposFamiliaresRelacion;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public int getIdGrupoFamiliar() {
        return idGrupoFamiliar;
    }

    public String getRolEnElGrupoFamiliar() {
        return rolEnElGrupoFamiliar;
    }

    public void setIdPersonasGruposFamiliaresRelacion(int idPersonasGruposFamiliaresRelacion) {
        this.idPersonasGruposFamiliaresRelacion = idPersonasGruposFamiliaresRelacion;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public void setIdGrupoFamiliar(int idGrupoFamiliar) {
        this.idGrupoFamiliar = idGrupoFamiliar;
    }

    public void setRolEnElGrupoFamiliar(String rolEnElGrupoFamiliar) {
        this.rolEnElGrupoFamiliar = rolEnElGrupoFamiliar;
    }
    
    
    
}
