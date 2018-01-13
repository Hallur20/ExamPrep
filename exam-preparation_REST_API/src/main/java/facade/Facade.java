package facade;

import entity.Event;
import entity.Pet;
import entityhelper.EventHelper;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author hvn15
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

    public List<Pet> getAllPets() {
        EntityManager em = getEntityManager();
        try {
            return em.createNamedQuery("Pet.findAll").getResultList();
        } finally {
            em.close();
        }
    }

    public List<Pet> getAlivePets() {
        EntityManager em = getEntityManager();
        try {
            return em.createNamedQuery("Pet.findByDeath").getResultList();
        } finally {
            em.close();
        }
    }

    public List<Pet> getEventByDayPet(String date) throws ParseException {
        EntityManager em = getEntityManager();
        try {
            DateFormat format = new SimpleDateFormat("yyyy-M-d", Locale.ENGLISH);
            Date dateFix = format.parse(date);
            return em.createNamedQuery("Event.findByDate").setParameter("date", dateFix).getResultList();
        } finally {
            em.close();
        }
    }

    public void createEvent(String event, String remark, String date, Pet petId) throws ParseException {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            DateFormat format = new SimpleDateFormat("yyyy-M-d", Locale.ENGLISH);
            Date dateFix = format.parse(date);
            em.persist(new Event(event, remark, dateFix, petId));
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

}
