package com.concretepage.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;//sounds cool
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.concretepage.dao.IntReportDAO;
import com.concretepage.service.IntReportService;
import com.concretepage.entity.Donation;
import com.concretepage.entity.OrgStats;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Service
public class ReportService implements IntReportService{

    @Autowired
    private IntReportDAO reportDAO;
/*
    @SuppressWarnings("unchecked")
    @Override
    public JSONObject constructReport(int donation, int time,
                                      int type, String start_date, String end_date) {

        List<Donation> donations = reportDAO.getDonations(type, donation, start_date, end_date);
        /*for (Donation x: donations)
        {
            System.out.println("Data returned by query: " + x.getCategorySize() + " Category: " + x.getCategoryName() + " Weight: " + x.getCategoryWeight() + "" +
                    " Date: " + x.getTs());
        }*/
        /*List<Donation> donationTimesSorted = reportDAO.getDonationTimesSorted(donation, start_date, end_date);
        /*for (Donation x: donationTimesSorted)
        {
            System.out.println("Data returned by query: " + x.getCategorySize() + " Category: " + x.getCategoryName() + " Weight: " + x.getCategoryWeight() + "" +
                    " Date: " + x.getTs());
        }*/
        /*String[] dates = findDateArray(time, start_date, end_date, donationTimesSorted);
       /* for (int i =0 ; i< dates.length;i++)
        {
            System.out.println("Dates Array: " + dates[i]);
        }*/
        //List<Donation> correctlyFormattedDonationList = formatDonationList(donations, dates, type, time);
        /*for (Donation x: correctlyFormattedDonationList)
        {
            System.out.println("Data returned by formatDonationList: " + x.getCategorySize() + " Category: " + x.getCategoryName() + " Weight: " + x.getCategoryWeight() + "" +
                    " Date: " + x.getTs());
        }*/
        /*correctlyFormattedDonationList = insertZeros(correctlyFormattedDonationList, dates);
        JSONObject x;
        try{
            x = convertToJSON(type, correctlyFormattedDonationList, dates);
        } catch (JSONException e)
        {
            System.out.print("JSON conversion failed");
            return null;
        }
        return x;

    }

    //@Override
    public JSONObject convertToJSON(int reportType, List<Donation> donationList, String[] timeArray) throws JSONException {
        JSONArray array = new JSONArray();
        String size = "";
        String category = "";
        float weight = 0;
        JSONObject item = null;
        int timeArrayPos = 0;
        for (Donation x: donationList) {
            // descriptive type, includes category
            if (reportType == 0) {
                // check if need to make new JSONObject
                if (!size.equals(x.getCategorySize()) || !category.equals(x.getCategoryName())) {
                    // checks for first org. if not, put it into array
                    if (item != null) {
                        array.put(item);
                    }
                    // make a new jsonobject
                    item = new JSONObject();
                    size = x.getCategorySize();
                    category = x.getCategoryName();
                    weight = x.getCategoryWeight();
                    item.put("org_size", size);
                    item.put("category", category);
                    timeArrayPos = 0;
                    item.put(timeArray[timeArrayPos], weight);
                    timeArrayPos++;
                    // check if this is the last x in donationList. if so, input it into array.
                    if (x.equals(donationList.get(donationList.size() - 1))) {
                        array.put(item);
                    }
                } else {
                    weight = x.getCategoryWeight();
                    item.put(timeArray[timeArrayPos], weight);
                    timeArrayPos++;
                    // check if this is the last x in donationList. if so, input it into array.
                    if (x.equals(donationList.get(donationList.size() - 1))) {
                        array.put(item);
                    }
                }
                // summary type
            } else {
                if (!size.equals(x.getCategorySize())) {
                    if (item != null) {
                        array.put(item);
                    }
                    item = new JSONObject();
                    size = x.getCategorySize();
                    weight = x.getCategoryWeight();
                    //System.out.println("Org size: " + size + " weight: " + weight + " ArrayIndex: " + timeArrayPos);
                    item.put("org_size", size);
                    timeArrayPos = 0;
                    item.put(timeArray[timeArrayPos], weight);
                    timeArrayPos++;
                    // check if this is the last x in donationList. if so, input it into array.
                    if (x.equals(donationList.get(donationList.size() - 1))) {
                        array.put(item);
                    }
                } else {
                    weight = x.getCategoryWeight();
                    //System.out.println("Org size: " + size + " weight: " + weight + " ArrayIndex: " + timeArrayPos);
                    item.put(timeArray[timeArrayPos], weight);
                    timeArrayPos++;
                    // check if this is the last x in donationList. if so, input it into array.
                    if (x.equals(donationList.get(donationList.size() - 1))) {
                        array.put(item);
                    }
                }
            }
        }

        //System.out.println(array.toString());

        JSONObject allData = new JSONObject();
        System.out.println("Time Array: " + timeArray[0]);
        if (reportType == 0) {
            String[] descriptive = new String[timeArray.length + 2];
            for (int i = 2; i <= timeArray.length + 1; i++) {
                descriptive[i] = timeArray[i-2];
            }
            descriptive[0] = "org_size";
            descriptive[1] = "category";
            System.out.println("Time Array: " + descriptive[2]);
            allData.put("columns", descriptive);
        } else {
            String[] summary = new String[timeArray.length + 1];
            for (int i = 1; i <= timeArray.length; i++) {
                summary[i] = timeArray[i-1];
            }
            summary[0] = "org_size";
            allData.put("columns", summary);
        }
        allData.put("data", array);

        return allData;
    }*/

    @SuppressWarnings("unchecked")
    @Override
    public List<Donation> getReport(String donation, String time, String type, String start_date, String end_date)
    {
        List<Donation> donationList = new ArrayList<Donation>();
        //donationList = reportDAO.getReport(donation, time, type, start_date, end_date);
        List<Donation> donationListToReturn = new ArrayList<Donation>();
        donationListToReturn = formatReport(time, type, donationList);
        return donationListToReturn;
    }

    public List<Donation> formatReport(String time, String type, List<Donation> donationList)
    {
        List<Donation> donationListToReturn = new ArrayList<Donation>();
        if (time.equals("2") && type.equals("1"))
        {
            donationListToReturn = getYearlySummaryReport(donationList);
        }
        else if (time.equals("2") && type.equals("0"))
        {
            donationListToReturn = getYearlyDescriptiveReport(donationList);
        }
        else if (time.equals("1") && type.equals("1"))
        {
            donationListToReturn = getMonthlySummaryReport(donationList);
        }
        else if (time.equals("1") && type.equals("0"))
        {
            donationListToReturn = getMonthlyDescriptiveReport(donationList);
        }
        else if (time.equals("0") && type.equals("1"))
        {
            donationListToReturn = getWeeklySummaryReport(donationList);
        }
        else
        {
            donationListToReturn = getWeeklyDescriptiveReport(donationList);
        }
        return donationListToReturn;
    }

    private List<Donation> getYearlySummaryReport(List<Donation> donationList)
    {
        return null;
    }

    private List<Donation> getYearlyDescriptiveReport(List<Donation> donationList)
    {
        return null;
    }

    private List<Donation> getMonthlySummaryReport(List<Donation> donationList)
    {
        return null;
    }

    private List<Donation> getMonthlyDescriptiveReport(List<Donation> donationList)
    {
        return null;
    }

    private List<Donation> getWeeklySummaryReport(List<Donation> donationList)
    {
        return null;
    }

    private List<Donation> getWeeklyDescriptiveReport(List<Donation> donationList)
    {
        return null;
    }

}
