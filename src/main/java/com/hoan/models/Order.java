package com.hoan.models;

import java.sql.Timestamp;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;

@Entity(name="Orders")
public class Order
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    public Order() {}

    public Order(Customer customer, String status)
    {
        this.customer = customer;
        this.status   = status;
    }

    private String status;

    @Column(name="date_created")
    private Timestamp dateCreated;

    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }

    public Customer getCustomer()
    {
        return customer;
    }
    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }

    public String getStatus()
    {
        return status;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public Timestamp getDateCreated()
    {
        return dateCreated;
    }
    public void setDateCreated(Timestamp dateCreated)
    {
        this.dateCreated = dateCreated;
    }

    @Override
    public boolean equals(Object obj)
    {
        return ((Order)obj).id == id;
    }

    @Override
    public String toString()
    {
        return "Id: " + getId() + ", Customer: " + getCustomer() + ", " +
               "Status: " + getStatus() + ", Date Created: " + getDateCreated();
    }
}
