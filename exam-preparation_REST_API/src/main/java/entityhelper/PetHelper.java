/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityhelper;

import java.util.Date;

/**
 *
 * @author hvn15
 */
public class PetHelper {
    private int id;
    private String name;
    private Date birth;
    private String species;
    private String first_name;
    private String last_name;
    private String event;

    public PetHelper(int id) {
        this.id = id;
    }

    public PetHelper(String name, String event) {
        this.name = name;
        this.event = event;
    }

    
    
    
    
    public PetHelper(int id, String name, Date birth, String species, String first_name, String last_name) {
        this.id = id;
        this.name = name;
        this.birth = birth;
        this.species = species;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    @Override
    public String toString() {
        return "Pet{" + "id=" + id + ", name=" + name + ", birth=" + birth + ", species=" + species + ", first_name=" + first_name + ", last_name=" + last_name + '}';
    }
    
    
}
