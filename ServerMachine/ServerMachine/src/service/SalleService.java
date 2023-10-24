/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.IDao;
import entities.Machine;
import entities.Salles;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author bigmoe
 */
public class SalleService  extends UnicastRemoteObject implements IDao<Salles>{
     
    public SalleService() throws RemoteException {
        super();
    }

    @Override
    public boolean create(Salles o) throws RemoteException {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(o);
            tx.commit();
            return true;
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
        }finally {
            if(session != null)
                session.close();
        }
        return false;
    }

    @Override
    public boolean update(Salles o) throws RemoteException {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(o);
            tx.commit();
            return true;
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
        }finally {
            if(session != null)
                session.close();
        }
        return false;
    }

    @Override
    public boolean delete(Salles o) throws RemoteException {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.delete(o);
            tx.commit();
            return true;
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
        }finally {
            if(session != null)
                session.close();
        }
        return false;
    }

    @Override
    public List<Salles> findAll() throws RemoteException {
        Session session = null;
        Transaction tx = null;
        List<Salles> salles = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            salles  = session.getNamedQuery("findAllSalles").list();
            tx.commit();
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
        }finally {
            if(session != null)
                session.close();
        }
        return salles;
    }

    @Override
    public Salles findById(int id) throws RemoteException {
        Session session = null;
        Transaction tx = null;
        Salles salle = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            salle  = (Salles) session.get(Salles.class, id);
            tx.commit();
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
        }finally {
            if(session != null)
                session.close();
        }
        return salle;
    }
    
    public List<Salles> findMachinesBySalleId(int id) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
