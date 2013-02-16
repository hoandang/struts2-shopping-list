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
import java.util.HashMap;
import com.hoan.models.Product;
import com.hoan.services.ShopServicesImpl;

//@Result(name="create", type="redirectAction", params = {"actionName" , "carts"})
//@Action(results={@Result(name="create", location="/carts", type="redirect")})
@Results({
    @Result(name="create", type="redirect", location="/carts"),
    @Result(name="delete", type="redirect", location="/carts"),
    @Result(name="update", type="redirect", location="/carts")
})
public class CartsController implements SessionAware
{
    private ShopServicesImpl service;
    private Map session, shoppingList;
    private List<Product> products;
    private String id;

    public HttpHeaders index()
    {
        if (session.containsKey("shoppingList"))
        {
            service = new ShopServicesImpl();
            products = new ArrayList<Product>();
            shoppingList = (Map)session.get("shoppingList");
            for (Map.Entry<String, Integer> entry : ((Map<String, Integer>)shoppingList).entrySet()) 
            {
                String id = entry.getKey();
                Integer quantity = entry.getValue();
                Product product = service.findProduct(Integer.parseInt(id));
                product.setQuantity(quantity);
                products.add(product);
            }
        }
        return new DefaultHttpHeaders("index").disableCaching();
    }

    public HttpHeaders create()
    {
        if (session.containsKey("shoppingList"))
        {
            shoppingList = (Map)session.get("shoppingList");
            if (productWasAlreadyIn(shoppingList))
                increaseQuantity();
            else
                shoppingList.put(id, 1);
        }
        else
        {
            shoppingList = new HashMap<String, Integer>();
            shoppingList.put(id, 1);
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
            shoppingList = (Map)session.get("shoppingList");
            shoppingList.remove(id);
            if (shoppingList.size() == 0)
                session.remove("shoppingList");
            else
                session.put("shoppingList", shoppingList);
        }
        //for (Map.Entry<String, Integer> entry : ((Map<String, Integer>)shoppingList).entrySet()) 
        //{

            ////System.out.println("-----------------ID: " + entry.getKey() + "------QUANTITY----------" + entry.getValue());
        //}
        return new DefaultHttpHeaders("delete").withStatus(200);
    }

    public HttpHeaders update()
    {
        return new DefaultHttpHeaders("update").withStatus(200);
    }

    private boolean productWasAlreadyIn(Map shoppingList)
    {
        return shoppingList.get(id) != null;
    }
    private void increaseQuantity()
    {
        int quantity = Integer.parseInt(shoppingList.get(id).toString());
        shoppingList.put(id, quantity + 1);
    }

    public String setId()
    {
        return id;
    }
    public void setId(String id)
    {
        this.id = id;
    }

    public void setSession(Map session)
    {
        this.session = session;
    }
    public List<Product> getProducts()
    {
        return products;
    }
    public void setProducts(List<Product> products)
    {
        this.products = products;
    }
}
