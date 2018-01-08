package com.concretepage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.concretepage.dao.IntReportDAO;
import com.concretepage.entity.Donation;
import com.concretepage.service.IntReportService;

@Controller
@RequestMapping("donation")
public class ReportController {

	@Autowired
	private IntReportDAO reportDAO;
	
	@Autowired
	private IntReportService reportService;
	
	@GetMapping("getInventory")
	public @ResponseBody List<Donation> getInventory () {
		return reportDAO.getInventory();
	}
	
	@GetMapping("getOutgoingDonations")
	public @ResponseBody List<Donation> getOutgoingDonations (
			@RequestParam int donation_type) {
		return reportDAO.getOutgoingDonations(donation_type);
	}
}
