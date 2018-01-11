/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randomdata;

/**
 *
 * @author Hallur
 */
public class Person {
    private String fname;
    private String lname;
    private int id;
    private int age;

    public Person(String fname, String lname, int id, int age) {
        this.fname = fname;
        this.lname = lname;
        this.id = id;
        this.age = age;
    }



    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" + "fname=" + fname + ", lname=" + lname + ", id=" + id + ", age=" + age + '}';
    }
    
    
}
