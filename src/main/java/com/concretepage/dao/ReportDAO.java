package com.concretepage.dao;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.concretepage.entity.Donation;

@Transactional
@Repository
public class ReportDAO implements IntReportDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	public List<Donation> getDonations(int type, int donation, String start_Date, String end_Date)
	{
		Query query = null;
		if (type == 0)
		{
			query = entityManager.createNativeQuery(
					"SELECT * FROM `donation_table`"
							+ " WHERE (ts >= '" + start_Date + " 00:00:00' AND ts <= '"
							+ end_Date + " 23:59:59') AND "
							+ "donation_type=" + donation + " ORDER BY category_name, ts;", Donation.class);
		}
		else
		{
			query = entityManager.createNativeQuery(
					"SELECT * FROM `donation_table`"
							+ " WHERE (ts >= '" + start_Date + "' AND ts <= '"
							+ end_Date + "') AND "
							+ "donation_type=" + donation + " ORDER BY category_name, ts;", Donation.class);
		}
		return query.getResultList();
	}

	public List<Donation> getDonationTimesSorted(int donation, String start_Date, String end_Date) {
		Query query = null;
		query = entityManager.createNativeQuery(
				"SELECT * FROM `donation_table`"
						+ " WHERE (date >= '" + start_Date + "' AND date <= '"
						+ end_Date + "') AND "
						+ "donation=" + donation + " ORDER BY date;", Donation.class);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Donation> getInventory(){
		Query query = entityManager.createNativeQuery(
				"SELECT * FROM inventory_table", Donation.class);
		List<Donation> donations = query.getResultList();
		return donations;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Donation> getOutgoingDonations(int donation_type) {
		Query query = entityManager.createNativeQuery(
				"SELECT * FROM donation_table WHERE donation_type = ?1", Donation.class);
		query.setParameter(1, donation_type);
		List<Donation> donations = query.getResultList();
		return donations;
	}

}
