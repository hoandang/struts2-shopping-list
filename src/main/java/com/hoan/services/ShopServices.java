package com.hoan.services;

import com.hoan.models.Category;
import com.hoan.models.Product;
import java.util.List;

public interface ShopServices
{
    public List<Category> findAllCategories();
    public List<Product> findNewProducts(int numberOfProduct);
    public List<Product> findProductsByCategory(int categoryId);
    public Product findProduct(int id);
}
