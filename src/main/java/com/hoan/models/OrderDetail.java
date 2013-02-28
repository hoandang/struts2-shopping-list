package com.hoan.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.EmbeddedId;
import javax.persistence.AttributeOverrides;
import javax.persistence.IdClass;
import javax.persistence.MapsId;

@Entity(name="OrderDetails")
@IdClass(OrderDetailPK.class)
public class OrderDetail
{
    @EmbeddedId
    private OrderDetailPK id;

    @Id
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="product_id", insertable=false, updatable=false)
    private Product product;

    @Id
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="order_id", insertable=false, updatable=false)
    private Order order;

    private int quantity;
    private double subtotal;

    public OrderDetail() {}

    public OrderDetail(OrderDetailPK id, int quantity, double subtotal)
    {
        this.product  = id.getProduct();
        this.order    = id.getOrder();
        this.quantity = quantity;
        this.subtotal = subtotal;
    }

    public OrderDetailPK getId()
    {
        return id;
    }
    public void setId(OrderDetailPK id)
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
	@Override
	public int hashCode() 
    {
		return getId().hashCode();
	}
	
	@Override
	public boolean equals(Object that) 
    {
		return (this == that) || ((that instanceof OrderDetail) && this.getId().equals(((OrderDetail) that).getId()));
	}

    @Override
    public String toString()
    {
        return getProduct() + ", " + getOrder() + ", " +
               getQuantity() + ", " + getSubtotal();
    }
}
