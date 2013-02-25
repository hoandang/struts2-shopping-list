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

//@Result(name="create", type="redirectAction", params = {"actionName" , "carts"})
//@Action(results={@Result(name="create", location="/carts", type="redirect")})
@Results({
    @Result(name="create", type="redirect", location="/carts"),
    @Result(name="delete", type="redirect", location="/carts"),
    @Result(name="update", type="redirect", location="/carts")
})
public class CartsController implements SessionAware, ServletRequestAware
{
    private ShopServicesImpl service;
    private Map session;
    private List shoppingList;
    private HttpServletRequest request;
    private String id;

    public HttpHeaders index()
    {
        if (session.containsKey("shoppingList"))
            shoppingList = (List)session.get("shoppingList");
        return new DefaultHttpHeaders("index").disableCaching();
    }

    public HttpHeaders create()
    {
        service = new ShopServicesImpl();
        Product product = service.findProduct(Integer.parseInt(id));
        if (session.containsKey("shoppingList"))
        {
            shoppingList = (List)session.get("shoppingList");
            if (product.isAddedInto(shoppingList))
            {
                product = (Product)shoppingList.get(shoppingList.indexOf(product));
                product.setQuantity(product.getQuantity() + 1);
                product.setSubtotal(product.getQuantity() * product.getPrice());
            }
            else
            {
                product.setQuantity(1);
                product.setSubtotal(product.getQuantity() * product.getPrice());
                shoppingList.add(0, product);
            }
        }
        else
        {
            product.setQuantity(1);
            product.setSubtotal(product.getQuantity() * product.getPrice());
            shoppingList = new ArrayList<Product>();
            shoppingList.add(0, product);
        }
        session.put("shoppingList", shoppingList);
        return new DefaultHttpHeaders("create").withStatus(201);
    }

    public HttpHeaders destroy()
    {
        if (id.equals("empty"))
        {
            session.remove("shoppingList");
        }
        else
        {
            service = new ShopServicesImpl();
            shoppingList = (List)session.get("shoppingList");
            shoppingList.remove(service.findProduct(Integer.parseInt(id)));

            if (shoppingList.size() == 0)
                session.remove("shoppingList");
            else
                session.put("shoppingList", shoppingList);
        }
        return new DefaultHttpHeaders("delete").withStatus(200);
    }

    public HttpHeaders update()
    {
        String[] newQuantities = request.getParameterValues("productQuantity");
        shoppingList = (List)session.get("shoppingList");

        for (int i = 0; i < newQuantities.length; i++)
        {
            try
            {
                int newQuantity = Integer.parseInt(newQuantities[i]);
                if (newQuantity > 0)
                {
                    Product product = (Product)shoppingList.get(i);
                    product.setQuantity(newQuantity);
                    product.setSubtotal(newQuantity * product.getPrice());
                }
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }

        session.put("shoppingList", shoppingList);
        return new DefaultHttpHeaders("update").withStatus(200);
    }

    public String getId()
    {
        return id;
    }
    public void setId(String id)
    {
        this.id = id;
    }

    public List getShoppingList()
    {
        return shoppingList;
    }
    public void setShoppingList(List shoppingList)
    {
        this.shoppingList = shoppingList;
    }

    @Override
    public void setSession(Map session)
    {
        this.session = session;
    }
    
    @Override
	public void setServletRequest(HttpServletRequest request) 
    {
		this.request = request;
	}
}
