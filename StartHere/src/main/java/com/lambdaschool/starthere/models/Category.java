package com.lambdaschool.starthere.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lambdaschool.starthere.logging.Loggable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Loggable
@Entity
@Table(name = "categories")
public class Category extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long categoryid;

    @Column(nullable = false,
            unique = true)
    private String categoryname;

//    @OneToMany(mappedBy = "category",
//            cascade = CascadeType.ALL)
//    @JsonIgnoreProperties("category")
//    private List<Interest> interests = new ArrayList<>();

    public Category()
    {
    }

    public Category(String categoryname/*, List<Interest> interests*/)
    {
        this.categoryname = categoryname;
//        this.interests = interests;
    }

    public long getCategoryid()
    {
        return categoryid;
    }

    public void setCategoryid(long categoryid)
    {
        this.categoryid = categoryid;
    }

    public String getCategoryname()
    {
        return categoryname;
    }

    public void setCategoryname(String categoryname)
    {
        this.categoryname = categoryname;
    }

//    public List<Interest> getInterests()
//    {
//        return interests;
//    }
//
//    public void setInterests(List<Interest> interests)
//    {
//        this.interests = interests;
//    }

    @Override
    public String toString()
    {
        return "Category{" +
                "categoryid=" + categoryid +
                ", categoryname='" + categoryname + '\'' +
//                ", interests=" + interests +
                '}';
    }
}
