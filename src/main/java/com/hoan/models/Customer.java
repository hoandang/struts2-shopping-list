package com.hoan.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Transient;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import java.util.List;

@Entity(name="Customers")
public class Customer
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    @Column(name="shipping_address")
    private String shippingAddress;
    @Column(name="credit_number")
    private int creditNumber;
    @Column(name="expired_date")
    private String creditExpiredDate;

    @Transient
    private String firstName;
    @Transient
    private String lastName;
    @Transient
    private String shippingCity;
    @Transient
    private int shippingZip;

    public int getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public String getFirstName()
    {
        return firstName;
    }
    public String getLastName()
    {
        return lastName;
    }
    public String getEmail()
    {
        return email;
    }
    public String getShippingAddress()
    {
        return shippingAddress;
    }
    public String getShippingCity()
    {
        return shippingCity;
    }
    public int getShippingZip()
    {
        return shippingZip;
    }
    public int getCreditNumber()
    {
        return creditNumber;
    }
    public String getCreditExpiredDate()
    {
        return creditExpiredDate;
    }

    public void setId(int id)
    {
        this.id = id;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public void setShippingAddress(String shippingAddress)
    {
        this.shippingAddress = shippingAddress;
    }
    public void setShippingCity(String shippingCity)
    {
        this.shippingCity = shippingCity;
    }
    public void setShippingZip(int shippingZip)
    {
        this.shippingZip = shippingZip;
    }
    public void setCreditNumber(int creditNumber)
    {
        this.creditNumber = creditNumber;
    }
    public void setCreditExpiredDate(String creditExpiredDate)
    {
        this.creditExpiredDate = creditExpiredDate;
    }

    @Override
    public String toString()
    {
        return "<p>Name: " + getFirstName() + " " + getLastName() + "</p>" +
               "<p>Email: " + getEmail() + "</p>" +  
               "<p>Shipping Info: " + getShippingAddress() + " " +
               "<p>Credit Number: " + getCreditNumber() + "</p>" +
               "<p>Expired Date: " + getCreditExpiredDate() + "</p>";
    }
}
