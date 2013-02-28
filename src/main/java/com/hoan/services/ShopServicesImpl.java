package com.hoan.services;

import com.hoan.models.Category;
import com.hoan.models.Product;
import com.hoan.models.Customer;
import com.hoan.models.Order;
import com.hoan.models.OrderDetail;
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

    @Override
    public void save(Customer customer)
    {
        em.getTransaction().begin();
        em.persist(customer);
        em.getTransaction().commit();
    }

    @Override
    public void save(Order order)
    {
        em.getTransaction().begin();
        em.persist(order);
        em.getTransaction().commit();
    }

    @Override
    public void save(OrderDetail orderDetail)
    {
        em.getTransaction().begin();
        em.persist(orderDetail);
        em.getTransaction().commit();
    }
}
