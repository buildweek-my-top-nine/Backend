package com.lambdaschool.starthere.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lambdaschool.starthere.logging.Loggable;

import javax.persistence.*;
import java.io.Serializable;

@Loggable
@Entity
@Table(name = "userinterests")
//        uniqueConstraints = {@UniqueConstraint(columnNames = {"interestid", "userid"})})
public class UserInterests implements Serializable
{
    @Id
    @ManyToOne
    @JoinColumn(name = "interestid")
    @JsonIgnoreProperties("userinterests")
    private Interest interest;

    @Id
    @ManyToOne
    @JoinColumn(name = "userid")
    @JsonIgnoreProperties("userinterests")
    private User user;

    public UserInterests()
    {
    }

    public UserInterests(Interest interest, User user)
    {
        this.interest = interest;
        this.user = user;
    }

    public Interest getInterest()
    {
        return interest;
    }

    public void setInterest(Interest interest)
    {
        this.interest = interest;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    @Override
    public String toString()
    {
        return "UserInterests{" +
                "interest=" + interest +
                ", user=" + user +
                '}';
    }
}
