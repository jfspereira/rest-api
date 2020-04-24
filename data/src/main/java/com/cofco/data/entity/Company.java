package com.cofco.data.entity;

import com.google.common.base.Objects;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "company")
public class Company {
    private Long id;
    private String name;
    private String address;
    private String city;
    private String country;
    private String email;
    private String phoneNumber;

    private List<Owner> owners;


    @Id
    @GeneratedValue
    @Column(name="id")
    public Long getId() {
        return id;
    }

    public Company setId(Long id) {
        this.id = id;
        return this;
    }

    @Basic
    @Column(name="name", nullable = false)
    public String getName() {
        return name;
    }

    public Company setName(String name) {
        this.name = name;
        return this;
    }

    @Basic
    @Column(name="address", nullable = false)
    public String getAddress() {
        return address;
    }

    public Company setAddress(String address) {
        this.address = address;
        return this;
    }

    @Basic
    @Column(name="city", nullable = false)
    public String getCity() {
        return city;
    }

    public Company setCity(String city) {
        this.city = city;
        return this;
    }

    @Basic
    @Column(name="country", nullable = false)
    public String getCountry() {
        return country;
    }

    public Company setCountry(String country) {
        this.country = country;
        return this;
    }

    @Basic
    @Column(name="email")
    public String getEmail() {
        return email;
    }

    public Company setEmail(String email) {
        this.email = email;
        return this;
    }

    @Basic
    @Column(name="phone_number")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "company_owner",
            joinColumns = @JoinColumn(name = "company_id"),
            inverseJoinColumns = @JoinColumn(name = "owner_id")
    )
    public List<Owner> getOwners() {
        return owners;
    }

    public Company setOwners(List<Owner> owners) {
        this.owners = owners;
        return this;
    }

    public Company setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equal(id, company.id) &&
                Objects.equal(name, company.name) &&
                Objects.equal(address, company.address) &&
                Objects.equal(city, company.city) &&
                Objects.equal(country, company.country) &&
                Objects.equal(email, company.email) &&
                Objects.equal(phoneNumber, company.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, name, address, city, country, email, phoneNumber);
    }
}