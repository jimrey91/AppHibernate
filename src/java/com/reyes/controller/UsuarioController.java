
package com.reyes.controller;

import com.reyes.dao.UsuarioDAO;
import com.reyes.model.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.apache.commons.codec.digest.DigestUtils;

@ManagedBean
@SessionScoped
public class UsuarioController {
    
    private Usuario usuario = new Usuario();

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String verificarDatos() throws Exception{
        UsuarioDAO usDAO = new UsuarioDAO();
        Usuario us;
        String resultado;
        
        try {
            /*
            Enviando la encriptacion
            */
            String encrypt = DigestUtils.sha1Hex(this.usuario.getPassUsuario());
            this.usuario.setPassUsuario(encrypt);
            
            us = usDAO.verificarDatos(this.usuario);
            if (us!= null) {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", us);
                resultado = "exito";
            }else{
                resultado = "error";
            }
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }
    
    public boolean verificarSesion(){
        boolean estado;

        if (FacesContext.getCurrentInstance().getExternalContext()
                        .getSessionMap().get("usuario") == null) {
            estado = false;
        } else {
            estado = true;
        }

        return estado;
    }
    
    public String cerrarSesion(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index";
    }
    
}
