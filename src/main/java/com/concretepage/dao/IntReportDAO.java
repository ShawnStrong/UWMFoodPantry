package com.concretepage.dao;

import java.util.List;

import com.concretepage.entity.Donation;

public interface IntReportDAO {

	public List<Donation> getInventory();

	List<Donation> getOutgoingDonations(int donation_type);

	public List<Donation> getDonations(int type, int donation, String start_Date, String end_Date);

	public List<Donation> getDonationTimesSorted(int donation, String start_Date, String end_Date);

}
