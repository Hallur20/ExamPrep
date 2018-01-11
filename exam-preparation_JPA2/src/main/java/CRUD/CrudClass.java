/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD;

import JPA.EBook;
import JPA.PaperBook;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author hvn15
 */
public class CrudClass {

    EntityManagerFactory emf;

    public CrudClass() {
    }

    public void addEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void main(String[] args) {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("pu");

        CrudClass c = new CrudClass();
        c.addEntityManagerFactory(emf);
        //c.createPaperBook(new PaperBook(12.32, 5, 2L,"something","other",43.22));
        //c.createEBook(new EBook("test", 100, 3L, "ehm", "hvad", 12.34));
        //System.out.println(c.readEBook());
        //System.out.println(c.readPaperBook());
        //c.updateEBookAuthor(2, "not hvad"); //choose isbn, new author
        c.deleteEBook(1); //delete based on isbn
        
    }

    public void createEBook(EBook eBook) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(eBook);
            em.getTransaction().commit();
        } finally {

        }
    }

    public void createPaperBook(PaperBook paperBook) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(paperBook);
            em.getTransaction().commit();
        } finally {

        }
    }

    public String readEBook() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<EBook> query
                    = em.createQuery("SELECT c FROM EBook c", EBook.class);
            List<EBook> results = query.getResultList();
            String fill = "";
            for (int i = 0; i < results.size(); i++) {
                fill += "\nelement:" + i + "\n" + results.get(i).getAuthor() + "\n"
                        + results.get(i).getDownloadUrl() + "\n"
                        + results.get(i).getTitle() +"\n"
                        + results.get(i).getIsbn() + "\n"
                        + results.get(i).getPrice() + "\n"
                        + results.get(i).getSizeMB();
            }
            return fill;
        } finally {

        }
    }
        public String readPaperBook() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<PaperBook> query
                    = em.createQuery("SELECT c FROM PaperBook c", PaperBook.class);
            List<PaperBook> results = query.getResultList();
            String fill = "";
            for (int i = 0; i < results.size(); i++) {
                fill += "\nelement:" + i + "\n" + results.get(i).getAuthor() + "\n"
                        + results.get(i).getTitle() + "\n"
                        + results.get(i).getInStock() +"\n"
                        + results.get(i).getIsbn() + "\n"
                        + results.get(i).getPrice() + "\n"
                        + results.get(i).getShippingWeight();
            }
            return fill;
        } finally {

        }
    }

    public void updateEBookAuthor(int id, String author) {
       EntityManager em = emf.createEntityManager();
       
       try{
           EBook ebook = em.find(EBook.class, Long.valueOf(id));
           em.getTransaction().begin();
           ebook.setAuthor(author);
           em.getTransaction().commit();
       } finally {
           
       }
    }

    public void deleteEBook(int id) {
EntityManager em = emf.createEntityManager();
       try{
           EBook ebook = em.find(EBook.class, Long.valueOf(id));
           em.getTransaction().begin();
           em.remove(ebook);
           em.getTransaction().commit();
       } finally {
           
       }
    }
}
