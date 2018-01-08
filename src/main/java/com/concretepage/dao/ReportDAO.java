package com.concretepage.dao;

import java.util.List;

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
