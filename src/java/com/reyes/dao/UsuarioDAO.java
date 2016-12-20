
package com.reyes.dao;

import com.reyes.model.HibernateUtil;
import com.reyes.model.Usuario;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Daniel
 */
public class UsuarioDAO {
    
    private Session session;
    
    
    public Usuario verificarDatos(Usuario us) throws Exception{
        Usuario usuario= null;
        
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "FROM Usuario WHERE nom_usuario= '" + us.getNomUsuario() +"' "
                    + "AND pass_usuario='" + us.getPassUsuario() +"'";
            Query query = session.createQuery(hql);
            if (!query.list().isEmpty()) {
                usuario = (Usuario)query.list().get(0);
            }
        } catch (Exception e) {
            throw e;
        }
        return usuario;
    }
    
}
