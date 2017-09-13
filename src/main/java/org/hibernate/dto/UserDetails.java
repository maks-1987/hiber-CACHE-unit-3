package org.hibernate.dto;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Cacheable;
import javax.persistence.*;

@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage= CacheConcurrencyStrategy.READ_ONLY)//, region = "STATIC_DATA")
@NamedQuery(name="UserDetails.byId", query ="from UserDetails where userId = ?")
//@NamedNativeQuery(name="UserDetails.byName", query = "select * from User_Details where username = ?", resultClass = UserDetails.class)
@Table(name = "User_Details")
@org.hibernate.annotations.Entity(selectBeforeUpdate=true)
public class UserDetails {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    private String userName;

    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
}
