package com.hoan.controllers;

import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;
import com.hoan.models.Product;
import com.hoan.models.Category;
import com.hoan.services.ShopServicesImpl;
import java.util.List;

public class CategoriesController
{
    private ShopServicesImpl service;
    private List<Product> products;
    private List<Category> categories;
    private int id;

    public HttpHeaders show()
    {
        service = new ShopServicesImpl();
        categories = service.findAllCategories(); 
        products   = service.findProductsByCategory(id);
        return new DefaultHttpHeaders("show");
    }

    public List<Product> getProducts()
    {
        return products;
    }
    public List<Category> getCategories()
    {
        return categories;
    }
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
}
