package com.cofco.data.entity;

import com.google.common.base.Objects;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "owner")
public class Owner {
    private Long id;
    private String name;
    private String title;
    private List<Company> companies;

    @Id
    @GeneratedValue
    @Column(name="id")
    public Long getId() {
        return id;
    }

    public Owner setId(Long id) {
        this.id = id;
        return this;
    }

    @Basic
    @Column(name="name", nullable = false)
    public String getName() {
        return name;
    }

    public Owner setName(String name) {
        this.name = name;
        return this;
    }

    @Basic
    @Column(name="title", nullable = false)
    public String getTitle() {
        return title;
    }

    public Owner setTitle(String title) {
        this.title = title;
        return this;
    }


    @ManyToMany(mappedBy = "owners")
    public List<Company> getCompanies() {
        return companies;
    }

    public Owner setCompanies(List<Company> companies) {
        this.companies = companies;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owner owner = (Owner) o;
        return Objects.equal(id, owner.id) &&
                Objects.equal(name, owner.name) &&
                Objects.equal(title, owner.title);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, name, title);
    }
}