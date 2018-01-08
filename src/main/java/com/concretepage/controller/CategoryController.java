package com.concretepage.controller;

import java.util.List;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.concretepage.dao.IntCategoryDAO;
import com.concretepage.entity.Category;
import com.concretepage.service.IntDonationService;
import com.google.gson.Gson;
import com.concretepage.service.DonationService;
import com.google.gson.Gson;

@Controller
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private IntCategoryDAO categoryDAO;

    @GetMapping("create")
    public @ResponseBody
    int createCategory(
            @RequestParam String category_name,
            @RequestParam String category_size,
            @RequestParam float category_weight) {
        return categoryDAO.createCategory(category_name, category_size, category_weight);
    }

    @GetMapping("delete")
    public @ResponseBody
    int deleteCategory(
            @RequestParam String category_name,
            @RequestParam String category_size
    ) {
        return categoryDAO.deleteCategory(category_name, category_size);
    }
}

    /*method below used to create table for user when they are going to add to the inventory
    @GetMapping("getCategoriesAdd")
    public @ResponseBody List<Category> listCategories() {

        List<Category> lop = categoryDAO.listCategoriesAdd();
        for (Category x : lop) {
            String name = x.getName();
            name = name.replaceAll("''", "'");
            x.setName(name);
        }

        return lop;
    }

    //method below used to create table for user to update the inventory
    @GetMapping("getCategoriesUpdate")
    public @ResponseBody List<Category> listCategories() {

        List<Category> lop = categoryDAO.listCategoriesUpdate();
        for (Category x : lop) {
            String name = x.getName();
            name = name.replaceAll("''", "'");
            x.setName(name);
        }

        return lop;
    }
}*/