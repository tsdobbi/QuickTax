package org.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.util.Constants.*;

import org.model.QTCalcForm;
import org.model.TaxBracket;

public class Calculator {
	
	private static DecimalFormat df = new DecimalFormat("#.00");

	public static TaxBracket percentCalc(double fincome, double currentBracket, double nextBracket, double percent,
			String bracketString) {
		TaxBracket bracket = new TaxBracket();
		double taxAmount = 0;
		bracket.setIncome(df.format(fincome));
		bracket.setNextBracketPercent(df.format(nextBracket));
		bracket.setPercentage(df.format(percent));
		bracket.setPercentageText(bracketString);
		if (fincome >= nextBracket) {
			if (percent == THIRTY_SEVEN_PERCENT) {
				bracket.setTaxableIncome(df.format((nextBracket) - (currentBracket - 1)));
				taxAmount = ((nextBracket) - (currentBracket - 1)) * percent;
			} else {
				if (currentBracket == TEN_PERCENT_BRACKET) {
					bracket.setTaxableIncome(df.format((nextBracket - 1) - (currentBracket)));
					taxAmount = ((nextBracket - 1) - (currentBracket)) * percent;
				} else {
					bracket.setTaxableIncome(df.format((nextBracket - 1) - (currentBracket - 1)));
					taxAmount = ((nextBracket - 1) - (currentBracket - 1)) * percent;
				}
			}
		} else {
			if (percent == TEN_PERCENT) {
				bracket.setTaxableIncome(df.format(fincome));
				taxAmount = TEN_PERCENT * fincome;
			} else {
				bracket.setTaxableIncome(df.format(fincome - (currentBracket - 1)));
				taxAmount = (fincome - (currentBracket - 1)) * percent;
			}
		}

		bracket.setTotalTaxForBracket(df.format(taxAmount));
		return bracket;
	}

	public static List<TaxBracket> process(double fincome, String filing) {
		double[] methodbracketArray;
		if(filing.equalsIgnoreCase("S")) {
			methodbracketArray = bracketArray;
		} else if(filing.equalsIgnoreCase("M")) {
			methodbracketArray = mBracketArray;
		} else if (filing.equalsIgnoreCase("H")) {
			methodbracketArray = hBracketArray;
		} else {
			methodbracketArray = bracketArray;
		}
		List<TaxBracket> tbList = new ArrayList<TaxBracket>();
		for (int i = 0; i < rateStringArray.length; i++) {

			if (fincome < methodbracketArray[i]) {
				break;
			} else {
				TaxBracket tb = new TaxBracket();
				int nextBracket = i + 1;
				if (nextBracket >= rateStringArray.length) {
					tb = percentCalc(fincome, methodbracketArray[i], fincome, rateArray[i], rateStringArray[i]);
				} else {

					tb = percentCalc(fincome, methodbracketArray[i], methodbracketArray[nextBracket], rateArray[i],
							rateStringArray[i]);
				}
				tbList.add(tb);
			}
		}

		return tbList;
	}

	public static String calculateTotalTax(List<TaxBracket> tbList) {
		String totalTax;
		double total = 0.00;
		for (TaxBracket taxBracket : tbList) {
			total = total + Double.parseDouble(taxBracket.getTotalTaxForBracket());
		}
		totalTax = df.format(total);

		return totalTax;

	}

	public static String calculateTaxRate(Double income, String totalTaxesString) {
		String totalTaxRate;
		double totalTaxes = Double.parseDouble(totalTaxesString);
		double rate = totalTaxes / income;

		totalTaxRate = df.format(rate);
		totalTaxRate = totalTaxRate.replace(".", "");

		return totalTaxRate;

	}

	public static String monthlyTaxes(String totalTaxesString) {
		double totalTaxes = Double.parseDouble(totalTaxesString);
		double monthlyTaxes = totalTaxes / 12;
		String totalMonthlyTaxes = df.format(monthlyTaxes);

		return totalMonthlyTaxes;

	}

	public static String monthlySalary(double fincome, String monthlyTax) {
		double monthlyTaxes = Double.parseDouble(monthlyTax);
		double monthlyIncomeAfterTax = fincome - monthlyTaxes;
		String totalMonthlyIncomeAfterTaxes = df.format(monthlyIncomeAfterTax);

		return totalMonthlyIncomeAfterTaxes;

	}
	
	public static String currencyFormat(String value) {
		double valueDouble = Double.parseDouble(value);
		Locale locale = new Locale("en", "US");      
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
		return currencyFormatter.format(valueDouble);
	}
	
	public static QTCalcForm setupCalcForm(List<TaxBracket> tbList, String income, String filingStatus, String taxPaid, String taxRate) {
		QTCalcForm qtCalcForm = new QTCalcForm();
		List<TaxBracket> tbListNew = new ArrayList<>();
		for(TaxBracket tb: tbList) {
			TaxBracket tbNew = new TaxBracket();
			tbNew.setIncome(currencyFormat(tb.getIncome()));
			tbNew.setNextBracketPercent(tb.getNextBracketPercent());
			tbNew.setPercentage(tb.getPercentage());
			tbNew.setPercentageText(tb.getPercentageText());
			tbNew.setTaxableIncome(currencyFormat(tb.getTaxableIncome()));
			tbNew.setTotalTaxForBracket(currencyFormat(tb.getTotalTaxForBracket()));
			tbListNew.add(tbNew);		
		}
		qtCalcForm.setTbList(tbListNew);
		qtCalcForm.setEffectiveTaxRate(taxRate);
		qtCalcForm.setAnnualTaxPaid(currencyFormat(taxPaid));
		qtCalcForm.setFilingStatus(filingStatus);
		qtCalcForm.setIncome(currencyFormat(income));
		return qtCalcForm;
	}

}
