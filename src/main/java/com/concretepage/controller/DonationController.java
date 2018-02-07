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

import com.concretepage.dao.IntDonationDAO;
import com.concretepage.entity.Donation;
import com.concretepage.entity.Inventory;
import com.concretepage.service.IntDonationService;
import com.google.gson.Gson;
import com.concretepage.service.DonationService;
import com.google.gson.Gson;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("donation")
public class DonationController {

	@Autowired
	private IntDonationDAO donationDAO;
	
	@Autowired
	private IntDonationService donationService;
	/*
	@GetMapping("input")
	public @ResponseBody String inputDonation (
			@RequestParam int donation,
			@RequestParam String org_name,
			@RequestParam String user_name,
			@RequestParam int deli,
			@RequestParam int dairy,
			@RequestParam int meat,
			@RequestParam int produce,
			@RequestParam int pantry,
			@RequestParam int bakery,
			@RequestParam int pet_food,
			@RequestParam int nonfood,
			@RequestParam String date,
			@RequestParam String page) {
		
		return donationService.separateDonations(donation, org_name, user_name, deli, 
				dairy, meat, produce, pantry, bakery, pet_food, nonfood, date, page);
	}

	@GetMapping("input")
	public @ResponseBody String addToInventory(
			@RequestParam String user_name,
			@RequestParam String category,
			@RequestParam String size,
			@RequestParam int amount) {



	}*/
//	@GetMapping("input")
//	public @ResponseBody int inputDonation (
//			@RequestParam String org_name,
//			@RequestParam String category,
//			@RequestParam int weight,
//			@RequestParam int donation) {
//		
//		return donationDAO.inputDonation(org_name, category, weight, donation);
//	}
	/*
	@GetMapping("listOrg")
	public @ResponseBody List<String> listOrg (
			@RequestParam int donation) {
		
		return donationDAO.listOrg(donation);
	}

	@GetMapping("listInfo")
	public @ResponseBody List<Donation> listInfo (
			@RequestParam String org_name,
			@RequestParam int donation) {
		
		return donationDAO.listInfo(org_name, donation);
	}*/
	
	@GetMapping("init")
	public @ResponseBody String initDonationTable() {
		donationDAO.initDonationTable();
		
		return "Donation table created";
	}
/*
	@GetMapping("frequency")
	public @ResponseBody List<String> frequency(@RequestParam String org_name) {

		List<String> categories = donationDAO.getFrequency(org_name);
		return categories;
	}*/
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

		System.out.println(start_date);
		
		if (user_name != "")
		{
			//donationDAO.inputPage(user_name, page);
			//donationService.reportTabPrediction(user_name, time, donation, type);
		}
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
		return x.toString();
	}
/*
	@GetMapping("widget")
	public @ResponseBody List<String> widget(
			@RequestParam String username) {
		List<String> widgetTimes = donationService.findWidgetTimes(username);
		//widgetTimes = DonationService.findWidgetTimes(username);

		return widgetTimes;
		//return null;
	}*/

	@GetMapping("showDonations")
	public @ResponseBody String showDonations(@RequestParam String date){
		/*
		org_name = org_name.substring(9);
		String replaceString=org_name.replace("%20"," ");
		replaceString = replaceString.replaceAll("'", "''");
		System.out.println(replaceString);
		List<Donation> listOfDonations = donationDAO.showDonations(replaceString);
		for (Donation x : listOfDonations) {
			String name = x.getOrgName();
			name = name.replaceAll("''", "'");
			x.setOrgName(name);
		}*/
		String json = new Gson().toJson("x");
		System.out.println(json);
		return json;
	}

	@GetMapping("getInventory")
	public @ResponseBody List<Inventory> getInventory(){
		List<Inventory> lop = donationDAO.listCategories();
		for (Inventory x : lop) {
			String name = x.getName();
			name = name.replaceAll("''", "'");
			x.setName(name);
		}

		return lop;
	}

	@GetMapping("deleteDonation")
	public @ResponseBody String deleteDonation(@RequestParam String order_id){
		System.out.println(order_id);
		int response = donationDAO.deleteDonation(order_id);
		String json = new Gson().toJson(response);
		return json;
	}

	@GetMapping("displayPreviousEntries")
    public @ResponseBody List<Donation> displayCategories()
    {
        List<Donation> x = donationDAO.displayPreviousEntries();
        System.out.println("x exists");
        return x;
    }

    @GetMapping("changeLastEntry")
    public @ResponseBody int changeLastEntry(
            @RequestParam String quantity,
            @RequestParam String donation_type,
            @RequestParam String category_name,
            @RequestParam String category_size
    ){
	    System.out.println("donation_type: " + donation_type + " category_name: " + category_name +
            " category_size: " + category_size + " quantity: " + quantity);
	    return donationDAO.changeLastEntry(quantity, donation_type, category_name, category_size);
	    //return 1;
    }

	@GetMapping("updateDonations")
	public @ResponseBody int updateDonations(@RequestParam String x){
		System.out.println(x);
		String newQuantityPatternString = "(\"new_quantity\",\")(.*?)(\",\"category_name\")";
        String catNamePatternString = "(\"category_name\",\")(.*?)(\",\"category_size\")";
        String catWeightPatternString = "(\"category_weight\",\")(.*?)(\",\"category_quantity\")";
        String catSizePatternString = "(\"category_size\",\")(.*?)(\",\"category_weight\")";
        String catQuantityPatternString = "(\"category_quantity\",\")(.*?)(\",\"new_quantity\")";
        String lastNewQuantity = "(\"new_quantity\",\")(\\d*?)(\"])";
        String getUserName = "(,username,)(.*?)(,)(.*)(\"category_name\",\")";
        String userName = "";

        Pattern p = Pattern.compile(getUserName);
        Matcher m = p.matcher(x);
        while (m.find())
        {
            System.out.println("User Name: "+m.group(2));
            userName = m.group(2);
        }

        List<String> newQuantities = new ArrayList<String>();
        List<String> categories = new ArrayList<String>();
        List<String> sizes = new ArrayList<String>();
        List<String> weights = new ArrayList<String>();
        List<String> oldQuantities = new ArrayList<String>();

        p = Pattern.compile(catNamePatternString);
        Matcher m1 = p.matcher(x);
        while (m1.find())
        {
            System.out.println("Cat Name: "+m1.group(2));
            categories.add(m1.group(2));
        }
        p = Pattern.compile(newQuantityPatternString);
        Matcher m2 = p.matcher(x);
        while (m2.find())
        {
            if (m2.group(2).isEmpty())
            {
                return 0;
            }
            System.out.println("new quantity: "+m2.group(2));
            newQuantities.add(m2.group(2));
        }
        p = Pattern.compile(catWeightPatternString);
        Matcher m3 = p.matcher(x);
        while (m3.find())
        {
            System.out.println("Weight: "+m3.group(2));
            weights.add(m3.group(2));
        }
        p = Pattern.compile(catSizePatternString);
        Matcher m4 = p.matcher(x);
        while (m4.find())
        {
            System.out.println("Size: "+m4.group(2));
            sizes.add(m4.group(2));
        }
        p = Pattern.compile(catQuantityPatternString);
        Matcher m5 = p.matcher(x);
        while (m5.find())
        {
            System.out.println("old quantity: " + m5.group(2));
            oldQuantities.add(m5.group(2));
        }
        p = Pattern.compile(lastNewQuantity);
        Matcher m6 = p.matcher(x);
        while (m6.find())
        {
            if (m6.group(2).isEmpty())
            {
                return 0;
            }
            System.out.println("last new quantity: "+ m6.group(2));
            newQuantities.add(m6.group(2));
        }
        return donationDAO.updateDonations(userName, categories, sizes, weights, oldQuantities, newQuantities);
	}
}
