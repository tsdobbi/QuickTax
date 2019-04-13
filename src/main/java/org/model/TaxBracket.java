package org.model;

import java.io.Serializable;

public class TaxBracket implements Serializable {

	private static final long serialVersionUID = 1L;
	private String income;
	private String percentage;
	private String nextBracketPercent;
	private String totalTaxForBracket;
	private String percentageText;
	private String taxableIncome;

	public TaxBracket() {

	}

	public String getIncome() {
		return income;
	}

	public void setIncome(String income) {
		this.income = income;
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

	public String getNextBracketPercent() {
		return nextBracketPercent;
	}

	public void setNextBracketPercent(String nextBracketPercent) {
		this.nextBracketPercent = nextBracketPercent;
	}

	public String getTotalTaxForBracket() {
		return totalTaxForBracket;
	}

	public void setTotalTaxForBracket(String totalTaxForBracket) {
		this.totalTaxForBracket = totalTaxForBracket;
	}

	public String getPercentageText() {
		return percentageText;
	}

	public void setPercentageText(String percentageText) {
		this.percentageText = percentageText;
	}

	public String getTaxableIncome() {
		return taxableIncome;
	}

	public void setTaxableIncome(String taxableIncome) {
		this.taxableIncome = taxableIncome;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
	

}
