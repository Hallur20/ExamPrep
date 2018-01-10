/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Semester;
import entities.Student;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author hvn15
 */
public class Factory {

    EntityManagerFactory emf;

    public Factory() {
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

        Factory f = new Factory();
        f.addEntityManagerFactory(emf);
        //System.out.println(f.getAllStudents()); //all students
        //f.getStudentAnders(); //students named anders
        //f.newStudent("Hallur", "við Neyst", 2); //add student and assign to semester
        
        
    }
    public String getAllStudents(){
        EntityManager em = emf.createEntityManager();
        try{
            TypedQuery<Student> query = em.createNamedQuery("Student.findAll", Student.class);
            List<Student> results = query.getResultList();
            String fill = "";
            for(int i = 0; i < results.size(); i++){
                fill+= "fName: "+results.get(i).getFirstname() +"\nlName: "+results.get(i).getLastname() + "\nsemesterId: " + results.get(i).getCurrentsemesterId() +"\n\n";
            }
            return fill;
        } finally {
            
        }
    }
    public void getStudentAnders(){
        EntityManager em = emf.createEntityManager();
        try{
            TypedQuery<Student> query = em.createNamedQuery("Student.findByFirstname", Student.class);
            query.setParameter("firstname", "anders");
            List<Student> results = query.getResultList();
            for(int i = 0; i < results.size(); i++){
                System.out.println("found: " + results.get(i).getFirstname());
            }
        } finally{
            
        }
    }
    public void newStudent(String fName, String  lName, int semId){
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(new Student(fName,lName, new Semester(Long.valueOf(semId))));
            em.getTransaction().commit();
        } finally{
            
        }
    }
}
