package com.hoan.controllers;

import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;
import com.hoan.models.Category;
import com.hoan.models.Product;
import com.hoan.services.ShopServicesImpl;
import java.util.List;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.interceptor.SessionAware; 
import java.util.Map;

public class HomeController implements SessionAware
{
    private ShopServicesImpl service = new ShopServicesImpl();
    private List<Category> categories;
    private List<Product> products;
    private Map session;

    public HttpHeaders index()
    {
        products = service.findNewProducts(10);
        categories  = service.findAllCategories();
        return new DefaultHttpHeaders("index").disableCaching();
    }

    public List<Category> getCategories()
    {
        return categories;
    }
    public List<Product> getProducts()
    {
        return products;
    }

    public void setSession(Map session)
    {
        this.session = session;
    }
}
