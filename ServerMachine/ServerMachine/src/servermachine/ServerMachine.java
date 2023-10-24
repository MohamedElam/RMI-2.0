/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servermachine;

import dao.IDao;
import entities.Machine;
import entities.Salles;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.MachineService;
import service.SalleService;

/**
 *
 * @author Lachgar
 */
public class ServerMachine {

    /**
     * @param args the command line arguments
     * @throws java.rmi.RemoteException
     */
    public static void main(String[] args) throws RemoteException {
    try {
            IDao<Machine> daoMachine = new  MachineService();
            IDao<Salles> daoSalles = new SalleService();
            
            LocateRegistry.createRegistry(1099);
            
            Naming.bind("rmi://localhost:1099/dao/machine", daoMachine);
            Naming.bind("rmi://localhost:1099/dao/salles", daoSalles);
            
            System.out.println("En attente d'un client ");
            
        } catch (AlreadyBoundException ex) {
            Logger.getLogger(ServerMachine.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ServerMachine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
