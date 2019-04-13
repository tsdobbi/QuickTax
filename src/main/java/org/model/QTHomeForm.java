package org.model;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class QTHomeForm implements Serializable {

	private static final long serialVersionUID = 1L;
	private Map<String, String> filingStatusList = new LinkedHashMap<String, String>();
	private double income = 0;
	private String filingStatus = "S";

	public QTHomeForm() {
		filingStatusList = new LinkedHashMap<String, String>();
		filingStatusList.put("S", "Single");
		filingStatusList.put("M", "Married-Joint File");
		filingStatusList.put("H", "Head of Household");
	}

	public String getFilingStatus() {
		return filingStatus;
	}

	public void setFilingStatus(String filingStatus) {
		this.filingStatus = filingStatus;
	}

	public Map<String, String> getFilingStatusList() {
		return filingStatusList;
	}

	public void setFilingStatusList(Map<String, String> filingStatusList) {
		this.filingStatusList = filingStatusList;
	}

	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
		this.income = income;
	}

}
