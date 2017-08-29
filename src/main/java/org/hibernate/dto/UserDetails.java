package org.hibernate.dto;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity


public class UserDetails {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    private String userName;

    @ManyToMany(cascade=CascadeType.ALL)
    private Collection<Vehicle> vehicle = new ArrayList<Vehicle>();

    public Collection<Vehicle> getVehicle() {
        return vehicle;
    }
    public void setVehicle(Collection<Vehicle> vehicle) {
        this.vehicle = vehicle;
    }

    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
//    @Column (name = "USER_NAME")
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
}
