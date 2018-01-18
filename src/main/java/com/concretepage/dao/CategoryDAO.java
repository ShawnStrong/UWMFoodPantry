package com.concretepage.dao;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.concretepage.entity.Category;
import com.concretepage.entity.Inventory;

@Transactional
@Repository
public class CategoryDAO implements IntCategoryDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public int createCategory(String category_name, String category_size, float category_weight)
    {
        Query query = entityManager.createNativeQuery(
                "SELECT * FROM category_table WHERE (category_name='" +
                        category_name + "' AND category_size='" +
                        category_size + "');", Category.class);

        List<Category> categories = query.getResultList();

        if (categories.isEmpty()) {
            query = entityManager.createNativeQuery(
                    "INSERT INTO category_table SET category_name = ?1, category_size = ?2, category_weight = ?3");
            query.setParameter(1, category_name);
            query.setParameter(2, category_size);
            query.setParameter(3, category_weight);
            query.executeUpdate();
        }
        else
        {
            return 0;
        }
        return 1;
    }

    @Override
    public int deleteCategory(String category_name, String category_size)
    {
        System.out.println("got into delete category");
        Query query = entityManager.createNativeQuery(
                "SELECT * FROM category_table WHERE (category_name='" +
                        category_name + "' AND category_size='" +
                        category_size + "');", Category.class);

        List<Category> categories = query.getResultList();
        System.out.println("SELECT * FROM category_table WHERE (category_name='" +
                category_name + "' AND category_size='" +
                category_size + "');");
        if (!(categories.isEmpty())) {
            System.out.println("wasn't empty");
            query = entityManager.createNativeQuery(
                    "DELETE FROM category_table WHERE (category_name='" +
                            category_name + "' AND category_size='" +
                            category_size + "');"
            );
            query.executeUpdate();
        }
        else
        {
            System.out.println("was empty");
            return 0;
        }
        return 1;
    }

    @Override
    public List<Category> displayCategories()
    {
        Query query = entityManager.createNativeQuery(
                "SELECT * FROM category_table;", Category.class);

        List<Category> categories = query.getResultList();
        return categories;
    }

    @SuppressWarnings("unchecked")
    @Override
    public int updateCategory(String category_name, String category_size, String category_weight) {
        // error codes:
        // 0 for successful update
        // 1 for org not created yet
        category_name = category_name.replaceAll("'", "''");
        Query query = entityManager.createNativeQuery(
                "SELECT * FROM category_table WHERE (category_name='" +
                        category_name + "' and category_size='" + category_size +"');", Category.class);

        List<Category> categories = query.getResultList();

        // check if org is made
        if (!categories.isEmpty()) {
            float categoryWeight = Float.parseFloat(category_weight);
            query = entityManager.createNativeQuery(
                    "UPDATE category_table SET category_name = ?1, category_size = ?2, category_weight = ?3" +
                            " Where (category_name = ?4 and category_size = ?5)");
            query.setParameter(1, category_name);
            query.setParameter(2, category_size);
            query.setParameter(3, categoryWeight);
            query.setParameter(4, category_name);
            query.setParameter(5, category_size);
            query.executeUpdate();

            return 0;
        } else {
            return 1;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Category> listCategories() {

        Query q = entityManager.createNativeQuery("SELECT * FROM category_table order by category_name;", Category.class);
        List<Category> categories = q.getResultList();
        return categories;

    }

    @SuppressWarnings("unchecked")
    @Override
    public int addToInventory(String category_name, String category_quantity, String user_name) {
        category_name = category_name.replace("%20"," ");
        //get size
        String category_size = category_name.substring(category_name.lastIndexOf(" ")+1);
        category_name = category_name.substring(0,category_name.lastIndexOf(" "));
        System.out.println("Category Name: " + category_name);
        System.out.println("Category Size: " + category_size);
        //get weight
        Query query = entityManager.createNativeQuery(
                "SELECT * FROM category_table WHERE (category_name='" +
                        category_name + "' and category_size='" + category_size +"');", Category.class);

        List<Category> categories1 = query.getResultList();
        float category_weight = 0;
        for (Category x: categories1)
        {
            category_weight = x.getWeight();
        }
        //check if you need to update
        query = entityManager.createNativeQuery(
                "SELECT * FROM inventory_table WHERE (category_name='" +
                        category_name + "' and category_size='" + category_size +"');", Inventory.class);
        List<Inventory> categories = query.getResultList();
        float categoryWeight = category_weight;
        int categoryQuantity = Integer.parseInt(category_quantity);
        if (categories.isEmpty())
        {
            query = entityManager.createNativeQuery(
                    "INSERT INTO inventory_table SET category_name=?1, category_size=?2, " +
                            "category_weight=?3, category_quantity=?4");
            query.setParameter(1, category_name);
            query.setParameter(2, category_size);
            query.setParameter(3, categoryWeight);
            query.setParameter(4, categoryQuantity);
            query.executeUpdate();
        }
        else
        {
            int quantity = 0;
            for (Inventory x: categories)
            {
                quantity = x.getQuantity();
            }
            query = entityManager.createNativeQuery(
                    "UPDATE inventory_table SET category_quantity=?1" +
                            " Where (category_name = ?2 and category_size = ?3)");
            query.setParameter(1, quantity);
            query.setParameter(2, category_name);
            query.setParameter(3, category_size);
            query.executeUpdate();
        }



        return 0;
    }

}