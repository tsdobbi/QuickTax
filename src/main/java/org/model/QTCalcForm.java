package org.model;

import java.io.Serializable;
import java.util.List;

public class QTCalcForm implements Serializable{

	private static final long serialVersionUID = 1L;
	private List<TaxBracket> tbList;
	private String income;
	private String filingStatus;
	private String effectiveTaxRate;
	private String annualTaxPaid;
	
	
	public List<TaxBracket> getTbList() {
		return tbList;
	}
	public void setTbList(List<TaxBracket> tbList) {
		this.tbList = tbList;
	}
	public String getIncome() {
		return income;
	}
	public void setIncome(String income) {
		this.income = income;
	}
	public String getFilingStatus() {
		return filingStatus;
	}
	public void setFilingStatus(String filingStatus) {
		this.filingStatus = filingStatus;
	}
	public String getEffectiveTaxRate() {
		return effectiveTaxRate;
	}
	public void setEffectiveTaxRate(String effectiveTaxRate) {
		this.effectiveTaxRate = effectiveTaxRate;
	}
	public String getAnnualTaxPaid() {
		return annualTaxPaid;
	}
	public void setAnnualTaxPaid(String annualTaxPaid) {
		this.annualTaxPaid = annualTaxPaid;
	}
	
	

}
