package com.hoan.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.CascadeType;

@Entity(name="OrderDetails")
public class OrderDetail
{
    @Id
    private int id;

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="product_id")
    private Product product;

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="order_id")
    private Order order;

    private int quantity;
    private double subtotal;

    public OrderDetail() {}

    public OrderDetail(Product product, Order order, int quantity, double subtotal)
    {
        this.product  = product;
        this.order    = order;
        this.quantity = quantity;
        this.subtotal = subtotal;
    }

    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }

    public Product getProduct()
    {
        return product;
    }
    public void setProduct(Product product)
    {
        this.product = product;
    }

    public Order getOrder()
    {
        return order;
    }
    public void setOrder(Order order)
    {
        this.order = order;
    }

    public int getQuantity()
    {
        return quantity;
    }
    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public double getSubtotal()
    {
        return subtotal;
    }
    public void setSubtotal(double subtotal)
    {
        this.subtotal = subtotal;
    }

    public String toString()
    {
        return getProduct() + ", " + getOrder() + ", " +
               getQuantity() + ", " + getSubtotal();
    }
}
