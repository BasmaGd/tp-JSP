/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.IDao;
import entities.Machine;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Hibernate;
import services.MachineService;
import util.HibernateUtil;

/**
 *
 * @author DELL
 */
public class Test {

    public static void main(String[] args) {
        
            MachineService dao = new MachineService();
            dao.create(new Machine("GD33", "DELL", 2000,null));
            dao.create(new Machine("GD34", "Lenovo", 4000,null));
            dao.create(new Machine("GD35", "HP", 6000,null));
            
            System.out.println(dao.findAll());
            for (Machine mm : dao.findAll()) {
                System.out.println(mm);
                
            }  
            
      
    }
}
