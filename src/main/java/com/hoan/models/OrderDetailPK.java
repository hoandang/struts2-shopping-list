package com.hoan.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class OrderDetailPK implements Serializable
{
    private Product product;
    private Order order;

    public OrderDetailPK() {}

    public OrderDetailPK(Product product, Order order)
    {
        this.product = product;
        this.order   = order;
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

    @Override
    public int hashCode() 
    {
        return order.hashCode() + (product.hashCode() << 1);
    }
    
    @Override
    public boolean equals(Object that) 
    {
        return (this == that) || ((that instanceof OrderDetailPK) && this.order.equals(((OrderDetailPK) that).order) && this.product.equals(((OrderDetailPK) that).product));
    }
}
