/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Lachgar
 * @param <T>
 */
public interface IDao<T> extends Remote {
  boolean create(T o) throws RemoteException;

    boolean update(T o) throws RemoteException;

    boolean delete(T o) throws RemoteException;

    List<T> findAll() throws RemoteException;
    
    List<T> findMachinesBySalleId(int id) throws RemoteException;

    T findById(int id) throws RemoteException;
}