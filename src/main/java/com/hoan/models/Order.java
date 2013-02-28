package com.hoan.models;

import java.sql.Timestamp;
import java.util.List;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.CascadeType;

@Entity(name="Orders")
public class Order
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private List<OrderDetail> orderDetail;

    private String status;

    @Column(name="date_created")
    private Timestamp dateCreated;

    public Order() {}

    public Order(Customer customer, String status)
    {
        this.customer = customer;
        this.status   = status;
    }

    // Generate suffix id number following the format nnnn
    private String suffix(int id) 
    {
        if (id < 10)
            return "000" + id;
        else if (id < 100)
            return "00" + id;
        else if (id < 1000)
            return "0" + id;
        else
            return String.valueOf(id);
    }

    // Create the formatted order id format ODRxxxx
    public String getFormattedId()
    {
        String prefix = "ODR";
        String suffix = suffix(getId());
        return prefix + suffix;
    }

    public List<OrderDetail> getOrderDetails()
    {
        return orderDetail;
    }
    public void setOrderDetails(List<OrderDetail> orderDetail)
    {
        this.orderDetail = orderDetail;
    }

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
