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
public class EventHelper {
    private int id;
    private int pet_id;
    private String event;
    private String remark;
    private Date date;

    public EventHelper(int pet_id) {
        this.pet_id = pet_id;
    }

    public EventHelper(int id, int pet_id, String event, String remark, Date date) {
        this.id = id;
        this.pet_id = pet_id;
        this.event = event;
        this.remark = remark;
        this.date = date;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPet_id() {
        return pet_id;
    }

    public void setPet_id(int pet_id) {
        this.pet_id = pet_id;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "EventHelper{" + "id=" + id + ", pet_id=" + pet_id + ", event=" + event + ", remark=" + remark + ", date=" + date + '}';
    }
    
    
}
