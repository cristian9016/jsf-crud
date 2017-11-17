/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.query;

import com.entities.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author CristianDev
 */
public class LoginQuery {
    
    EntityManagerFactory emf;
    EntityManager em;

    public LoginQuery() {
        emf = Persistence.createEntityManagerFactory("loginPU");
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }
    
    public boolean loginControl(String username,String password){
        try{
            Usuario u = em.createNamedQuery("Usuario.login",Usuario.class).setParameter("username", username).setParameter("password", password).getSingleResult();
            System.out.println("username: "+u.getUsername());
            if(u != null){
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            return false;
        }
    }
    
    
}
