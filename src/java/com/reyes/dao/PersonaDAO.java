package com.reyes.dao;

import com.reyes.model.HibernateUtil;
import com.reyes.model.Persona;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

/**
 *
 * @author Daniel
 */
public class PersonaDAO {
    private Session session;
    private Transaction trans;
    private List<Persona> listaEmpleado;
    
    public void registrar(Persona per) throws Exception{
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            trans = session.beginTransaction();
            session.save(per);
            trans.commit();
        } catch (Exception e) {
            throw e;
        }finally {
            session.close();
        }
    }
    
    public void eliminar(Persona per) throws Exception{
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            trans = session.beginTransaction();
            session.delete(per);
            trans.commit();
        } catch (Exception e) {
            throw e;
        }finally {
            session.close();
        }
    }
    
    public void modificar(Persona per) throws Exception{
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            trans = session.beginTransaction();
            session.update(per);
            trans.commit();
        } catch (Exception e) {
            throw e;
        }finally {
            session.close();
        }
    }
    
    public List<Persona> listar() throws Exception{
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Criteria cr = session.createCriteria(Persona.class);
            cr.addOrder(Order.asc("apellido"));
            listaEmpleado = cr.list();
        } catch (Exception e) {
            throw e;
        }
        return listaEmpleado;
    }
}
