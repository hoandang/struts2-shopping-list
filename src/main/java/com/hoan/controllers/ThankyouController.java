package com.hoan.controllers;

import org.apache.struts2.interceptor.SessionAware; 
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;
import com.hoan.models.Order;
import com.hoan.services.ShopServicesImpl;
import java.util.Map;

public class ThankyouController 
{
    private String orderId;

    public HttpHeaders index()
    {
        ShopServicesImpl service = new ShopServicesImpl();
        Order order = new Order();
        order.setId(service.getNewOrderId());
        orderId = order.getFormattedId();
        return new DefaultHttpHeaders("index").withStatus(200);
    }

    public String getOrderId()
    {
        return orderId;
    }
    public void setOrderId(String orderId)
    {
        this.orderId = orderId;
    }
}
