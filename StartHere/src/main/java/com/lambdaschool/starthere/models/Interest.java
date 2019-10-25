package com.lambdaschool.starthere.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lambdaschool.starthere.logging.Loggable;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@ApiModel(value = "Interest", description = "The Interest Entity")
@Loggable
@Entity
@Table(name = "interest")
public class Interest extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long interestid;

//    @Column(nullable = false,
//            unique = true)
    private String interestname;

    private String description;

    @OneToMany(fetch = FetchType.EAGER) // <-- added for testing
    @JsonIgnoreProperties(value = {
            "interest"
    })
    private List<UserInterests> users = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "categoryid",
            nullable = false)
    @JsonIgnoreProperties("interests")
    private Category category;

    public Interest()
    {
    }

    public Interest(String interestname, Category category)
    {
        this.interestname = interestname;
        this.category = category;
    }

    public Interest(String interestname, String description, List<UserInterests> users, Category category)
    {
        this.interestname = interestname;
        this.description = description;
        this.users = users;
        this.category = category;
    }

    public long getInterestid()
    {
        return interestid;
    }

    public void setInterestid(long interestid)
    {
        this.interestid = interestid;
    }

    public String getInterestname()
    {
        return interestname;
    }

    public void setInterestname(String interestname)
    {
        this.interestname = interestname;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public List<UserInterests> getUsers()
    {
        return users;
    }

    public void setUsers(List<UserInterests> users)
    {
        this.users = users;
    }

    public Category getCategory()
    {
        return category;
    }

    public void setCategory(Category category)
    {
        this.category = category;
    }

    @Override
    public String toString()
    {
        return "Interest{" +
                "interestid=" + interestid +
                ", interestname='" + interestname + '\'' +
                ", description='" + description + '\'' +
                ", users=" + users +
                ", category=" + category +
                '}';
    }
}
