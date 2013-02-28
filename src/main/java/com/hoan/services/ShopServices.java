package com.hoan.services;

import com.hoan.models.Category;
import com.hoan.models.Product;
import com.hoan.models.Customer;
import com.hoan.models.Order;
import com.hoan.models.OrderDetail;
import java.util.List;

public interface ShopServices
{
    public List<Category> findAllCategories();
    public List<Product> findNewProducts(int numberOfProduct);
    public List<Product> findProductsByCategory(int categoryId);
    public Product findProduct(int id);
    public void save(Customer customer);
    public void save(Order order);
    public void save(OrderDetail orderDetail);
    public int getNewOrderId();
}
