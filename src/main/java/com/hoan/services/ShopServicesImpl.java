package com.hoan.services;

import com.hoan.models.Category;
import com.hoan.models.Product;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManagerFactory;

public class ShopServicesImpl implements ShopServices
{
    @PersistenceContext
    private EntityManager em;

    public ShopServicesImpl()
    {
        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("shop");
        em = emf.createEntityManager();
    }

    @Override
    public List<Category> findAllCategories()
    {
        String query = "SELECT c FROM Categories c";
        return em.createQuery(query).getResultList();
    }

    @Override
    public List<Product> findNewProducts(int numberOfProduct)
    {
		String query = "SELECT p FROM Products p " + 
                       "ORDER BY p.id DESC";
		return em.createQuery(query).setMaxResults(numberOfProduct)
				.getResultList();
    }
    @Override
    public List<Product> findProductsByCategory(int categoryId)
    {
        // select * from products p where p.category_id = 1 order by p.id desc;
        String query = "SELECT p FROM Products p " +
                       "WHERE p.category.id = " + categoryId + " " + 
                       "ORDER BY p.id DESC";
        return em.createQuery(query).getResultList();
    }

    @Override
    public Product findProduct(int id)
    {
        String query = "SELECT p FROM Products p " +
                       "WHERE p.id = " + id;
        return (Product)em.createQuery(query).getSingleResult();
    }
}
