package com.concretepage.dao;

import java.util.List;

import com.concretepage.entity.Donation;
import com.concretepage.entity.Frequency;
import com.concretepage.entity.Inventory;

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

public interface IntDonationDAO {
	
	//public List<String> listOrg(int donation);
	
	/*public List<Donation> listInfo(String org_name,
			int donation);*/

	//public List<String> getFrequency(String org_name);

	void initDonationTable();

	//public List<Donation> getDonationTimesSorted(int donation, String start_Date, String end_Date);

	List<Object> getReport(int donation, int time, int type, String start_date, String end_date);

	//public List<String> getWidgetOrgs(String date, String username);

	//public int inputPage(String user_name, String page);

	//public int inputReportPrediction(String user_name, String tr, String io, String sd);

	//String getUserPage(String user_name, String ts);

	int inputDonation(String org_name, String user_name, String category, int weight, int donation, String date);

	List<Donation> showDonations(String date);

	public List<Object> getInventory();

	public int deleteDonation(String order_id);

	public List<Donation> getDonations(int type, int donation, String startDate, String endDate);

//	public List<Donation> getDonationTimesSorted(int donation, String start_Date, String end_Date);

	public List<Inventory> listCategories();

	public List<Donation> displayPreviousEntries();

	public int changeLastEntry(String quantity, String donation_type, String category_name, String category_size);

	public int updateDonations(String user_name, List<String> categories, List<String> sizes, List<String> weights, List<String> oldQuantities, List<String> newQuantities);

	//public List<Object> getInventory(int donation, int time, int type, String start_date, String end_date);
}
