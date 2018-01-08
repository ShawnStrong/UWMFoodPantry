package com.concretepage.dao;

import java.util.List;

import com.concretepage.entity.Donation;

public interface IntReportDAO {

	public List<Donation> getInventory();

	List<Donation> getOutgoingDonations(int donation_type);

}
