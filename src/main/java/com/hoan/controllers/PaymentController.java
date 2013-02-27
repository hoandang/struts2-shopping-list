package com.hoan.controllers;

import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;
import org.apache.struts2.interceptor.SessionAware; 
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.convention.annotation.Action;
import com.opensymphony.xwork2.ActionContext;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Enumeration;
import java.util.HashMap;
import com.hoan.models.Product;
import com.hoan.services.ShopServicesImpl;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.hoan.models.Customer;
import com.hoan.models.Order;
import com.hoan.models.OrderDetail;

//@Result(name="create", type="redirectAction", params = {"actionName" , "carts"})
//@Action(results={@Result(name="create", location="/carts", type="redirect")})
@Results({
    @Result(name="error", type="redirect", location="/"),
    @Result(name="create", type="redirect", location="/thankyou"),
    @Result(name="confirm", type="redirect", location="/payment/show")
})
public class PaymentController implements SessionAware
{
    private ShopServicesImpl service;
    private List<Product> shoppingList;
    private Map session;
    private Customer customer;

    // GET /payment/new
    public HttpHeaders editNew()
    {
        if (session.containsKey("shoppingList"))
        {
            customer = (Customer)session.get("customer");
            return new DefaultHttpHeaders("editNew").withStatus(200);
        }
        else 
        {
            return new DefaultHttpHeaders("error").withStatus(404);
        }
    }

    // POST /payment
    public HttpHeaders create()
    {
        service = new ShopServicesImpl();

        // Save customer
        customer = (Customer)session.get("customer");
        service.save(customer);

        // Save order
        Order order = new Order(customer, "UNPAID");
        service.save(order);

        //// Create order line between product and order
        shoppingList = (List<Product>)session.get("shoppingList");
        for (Product product : shoppingList)
        {
            service.save(new OrderDetail(product, order,
                                         product.getQuantity(),
                                         product.getSubtotal()));
        }

        return new DefaultHttpHeaders("create").withStatus(200);
    }

    // REDIRECT from /payment/confirm to /payment/show
    public HttpHeaders show()
    {
        customer = (Customer)session.get("customer");
        return new DefaultHttpHeaders("show");
    }

    // POST /payment/confirm
    public String execute()
    {
        customer.setName(customer.getFirstName() + " " + customer.getLastName());
        customer.setShippingAddress(customer.getShippingAddress() + " " + 
                                    customer.getShippingCity() + " " +
                                    customer.getShippingZip());
        session.put("customer", customer);
        return "confirm";
    }

    @Override
    public void setSession(Map session)
    {
        this.session = session;
    }
    public Customer getCustomer()
    {
        return customer;
    }
    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }
}
