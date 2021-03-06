package com.hoan.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.Transient;
import javax.persistence.CascadeType;
import java.util.List;

@Entity(name="Products")
public class Product
{
    @Id
    private int id;

    private String description;
    private double price;

    @Transient
    private double subtotal;
    @Transient
    private int quantity;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<OrderDetail> orderDetail;

    public Product() {}

    public Product(String description, double price)
    {
        this.description = description;
        this.price       = price;
    }

    public List<OrderDetail> getOrderDetail()
    {
        return orderDetail;
    }
    public void setOrderDetail(List<OrderDetail> orderDetail)
    {
        this.orderDetail = orderDetail;
    }

    public Category getCategory()
    {
        return category;
    }

    public boolean isAddedInto(List shoppingList)
    {
        return shoppingList.contains(this);
    }

    public void setCategory(Category category)
    {
        this.category = category;
    }

    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }

    public String getDescription()
    {
        return description;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }

    public double getPrice()
    {
        return price;
    }
    public void setPrice(double price)
    {
        this.price = price;
    }

    public double getSubtotal()
    {
        return subtotal;
    }
    public void setSubtotal(double subtotal)
    {
        this.subtotal = subtotal;
    }

    public int getQuantity()
    {
        return quantity;
    }
    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object obj)
    {
        return ((Product)obj).id == id;
    }

    @Override
    public String toString()
    {
        return "Id: " + getId() + ", Desc: " + getDescription() +
            ", Price: " + getPrice() + ", Quantity: " + getQuantity() + ", Subtotal: " + getSubtotal();
    }
}
