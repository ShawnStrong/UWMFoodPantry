package com.concretepage.service;

import java.util.List;

import org.json.JSONObject;
import org.json.JSONException;

import com.concretepage.entity.Donation;

public interface IntReportService {

    public List<Donation> getReport(String donation, String time, String type, String start_date, String end_date);
    //public JSONObject constructReport(int donation, int time, int type, String start_date, String end_date);

}
