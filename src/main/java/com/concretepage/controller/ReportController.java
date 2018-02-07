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

import com.concretepage.dao.IntReportDAO;
import com.concretepage.entity.Donation;
import com.concretepage.service.IntReportService;

@Controller
@RequestMapping("report")
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

	@GetMapping("getIncomingDonations")
	public @ResponseBody List<Donation> getIncomingDonations (
			@RequestParam int donation_type) {
		return reportDAO.getOutgoingDonations(donation_type);
	}
/*
	@SuppressWarnings("unchecked")
	@GetMapping("report")
	public @ResponseBody String getReport(
			@RequestParam int donation,
			@RequestParam int time,
			@RequestParam int type,
			@RequestParam String start_date,
			@RequestParam String end_date,
			@RequestParam String page,
			@RequestParam String user_name) throws JSONException {
/*
		System.out.println(start_date);
		List<Donation> donationList = new ArrayList<Donation>();
		String donation1 = Integer.toString(donation);
		String time1 = Integer.toString(time);
		String type1 = Integer.toString(type);
		donationList = reportService.getReport(donation1, time1, type1, start_date, end_date);
		//List<Donation> donationList = new ArrayList<Donation>();
		//donationList = donationDAO.getReport(donation, time, type, start_date, end_date);
		//return DonationService.convertToJson(type, donationList);
		//List<Object> ListOfReportStuff = donationDAO.getReport(donation, time, type, start_date, end_date);
		//List<Object> ListOfReportStuff = donationService.constructReport(donation, time, type, start_date, end_date);
		//JSONObject x = donationService.constructReport(donation, time, type, start_date, end_date);
		JSONObject x = null;
		if (x.equals(null))
		{
			x = new JSONObject().put("JSON", "error");
		}

		System.out.println(x.toString());
		return x.toString();*//*
		JSONObject x = reportService.constructReport(donation, time, type, start_date, end_date);
		if (x.equals(null))
		{
			x = new JSONObject().put("JSON", "error");
		}
		System.out.println(x.toString());
		return x.toString();
	}*/
}
