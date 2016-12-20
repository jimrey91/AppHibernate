package com.reyes.controller;

import com.reyes.dao.PersonaDAO;
import com.reyes.model.Persona;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class PersonaController {
    
    private Persona persona = new Persona();
    private PersonaDAO personaDao = new PersonaDAO();
    private List<Persona> listaPersonas;

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public PersonaDAO getPersonaDao() {
        return personaDao;
    }

    public void setPersonaDao(PersonaDAO personaDao) {
        this.personaDao = personaDao;
    }

    public List<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public void setListaPersonas(List<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }
    
    public void registrar() throws Exception{
        personaDao.registrar(this.persona);
    }
    
    public void eliminar(Persona per) throws Exception{
        personaDao.eliminar(per);
    }
    
    public String leer(Persona per){
        this.persona = per;
        return "editar";
    }
    
    public String modificar() throws Exception{
        personaDao.modificar(this.persona);
        return "exito";
    }
    
    public void listar() throws Exception{
        this.listaPersonas = personaDao.listar();
    }
}
