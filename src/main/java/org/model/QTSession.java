package org.model;

import java.io.Serializable;
import java.util.List;

public class QTSession implements Serializable {

	private static final long serialVersionUID = 1L;
	private boolean init = false;
	private boolean rateCalculated = false;
	private String income = "0";
	private List<TaxBracket> tbList;
	private String totalAnnualTaxPaid = "0";
	private String totalAnnualTaxRate = "0";
	private String filingStatus = "";

	public QTSession() {
		init();
	}

	private void init() {
		if (!init) {
			init = true;
		}
	}

	public boolean isInit() {
		return init;
	}

	public boolean isRateCalculated() {
		return rateCalculated;
	}

	public void setRateCalculated(boolean rateCalculated) {
		this.rateCalculated = rateCalculated;
	}


	public String getIncome() {
		return income;
	}

	public void setIncome(String income) {
		this.income = income;
	}

	public List<TaxBracket> getTbList() {
		return tbList;
	}

	public void setTbList(List<TaxBracket> tbList) {
		this.tbList = tbList;
	}

	public String getTotalAnnualTaxPaid() {
		return totalAnnualTaxPaid;
	}

	public void setTotalAnnualTaxPaid(String totalAnnualTaxPaid) {
		this.totalAnnualTaxPaid = totalAnnualTaxPaid;
	}

	public String getTotalAnnualTaxRate() {
		return totalAnnualTaxRate;
	}

	public void setTotalAnnualTaxRate(String totalAnnualTaxRate) {
		this.totalAnnualTaxRate = totalAnnualTaxRate;
	}

	public String getFilingStatus() {
		return filingStatus;
	}

	public void setFilingStatus(String filingStatus) {
		this.filingStatus = filingStatus;
	}
	
	
	
	

}
