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
        Query query = entityManager.createNativeQuery(
                "SELECT * FROM category_table WHERE (category_name='" +
                        category_name + "' AND category_size='" +
                        category_size + "');", Category.class);

        List<Category> categories = query.getResultList();

        if (categories.isEmpty()) {
            query = entityManager.createNativeQuery(
                    "DELETE FROM category_table WHERE (category_name='" +
                            category_name + "' AND category_size='" +
                            category_size + "');"
            );
            query.executeUpdate();
        }
        else
        {
            return 0;
        }
        return 1;
    }
}