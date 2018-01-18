package com.concretepage.dao;

import java.util.List;

import com.concretepage.entity.Category;

/**
 * Stored procedures for donation_table:
 Donation(org_name, category, weight, donation,
 date_created) � add entry to the donation table with
 incoming or outgoing donation flag

 ListOrg(donation) � return org_name for all incoming
 or outgoing entries. in other words, returns 'all orgs that
 donate' (donation = 0) or 'all orgs that receive' (donation = 1)

 ListInfo(org_name, donation) � return org_name,
 category, weight, date_created

 initDonationTable() - initiate donation_table
 *
 *
 */

public interface IntCategoryDAO {

    public int createCategory(String category_name, String category_size, float category_weight);

    public int deleteCategory(String category_name, String category_size);

    public List<Category> displayCategories();

    public int updateCategory(String category_name, String category_size, String category_weight);

    public List<Category> listCategories();
}