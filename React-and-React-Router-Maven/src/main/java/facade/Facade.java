/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.GitRepo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Hallur
 */
public class Facade {

   EntityManagerFactory emf;

    public Facade() {
    }

    public void addEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void add(GitRepo gr) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(gr);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    public List<GitRepo> getAll(){
        EntityManager em = getEntityManager();
        try{
            return em.createQuery("select e from GitRepo e").getResultList();
        } finally {
            em.close();
        }
    }
}
