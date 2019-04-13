package org.util;

public class Constants {

	// tax rate String
	public static final String TEN_PERCENT_STRING = "10%";
	public static final String TWELVE_PERCENT_STRING = "12%";
	public static final String TWENTY_TWO_PERCENT_STRING = "22%";
	public static final String TWENTY_FOUR_PERCENT_STRING = "24%";
	public static final String THIRTY_TWO_PERCENT_STRING = "32%";
	public static final String THIRTY_FIVE_PERCENT_STRING = "35%";
	public static final String THIRTY_SEVEN_PERCENT_STRING = "37%";

	// tax rate
	public static final double TEN_PERCENT = 0.10;
	public static final double TWELVE_PERCENT = 0.12;
	public static final double TWENTY_TWO_PERCENT = 0.22;
	public static final double TWENTY_FOUR_PERCENT = 0.24;
	public static final double THIRTY_TWO_PERCENT = 0.32;
	public static final double THIRTY_FIVE_PERCENT = 0.35;
	public static final double THIRTY_SEVEN_PERCENT = 0.37;

	// tax brackets - single
	public static final double TEN_PERCENT_BRACKET = 0.00;
	public static final double TWELVE_PERCENT_BRACKET = 9700.00;
	public static final double TWENTY_TWO_PERCENT_BRACKET = 39475.00;
	public static final double TWENTY_FOUR_PERCENT_BRACKET = 84200.00;
	public static final double THIRTY_TWO_PERCENT_BRACKET = 160725.00;
	public static final double THIRTY_FIVE_PERCENT_BRACKET = 204100.00;
	public static final double THIRTY_SEVEN_PERCENT_BRACKET = 510300.00;

	// tax brackets - married
	public static final double M_TEN_PERCENT_BRACKET = 0.00;
	public static final double M_TWELVE_PERCENT_BRACKET = 19400.00;
	public static final double M_TWENTY_TWO_PERCENT_BRACKET = 78950.00;
	public static final double M_TWENTY_FOUR_PERCENT_BRACKET = 168400.00;
	public static final double M_THIRTY_TWO_PERCENT_BRACKET = 321450.00;
	public static final double M_THIRTY_FIVE_PERCENT_BRACKET = 408200.00;
	public static final double M_THIRTY_SEVEN_PERCENT_BRACKET = 612350.00;

	// tax brackets - head of household
	public static final double H_TEN_PERCENT_BRACKET = 0.00;
	public static final double H_TWELVE_PERCENT_BRACKET = 13850.00;
	public static final double H_TWENTY_TWO_PERCENT_BRACKET = 52850.00;
	public static final double H_TWENTY_FOUR_PERCENT_BRACKET = 84200.00;
	public static final double H_THIRTY_TWO_PERCENT_BRACKET = 160700.00;
	public static final double H_THIRTY_FIVE_PERCENT_BRACKET = 204100.00;
	public static final double H_THIRTY_SEVEN_PERCENT_BRACKET = 510300.00;

	// arrays
	public static final double[] rateArray = new double[] { TEN_PERCENT, TWELVE_PERCENT, TWENTY_TWO_PERCENT,
			TWENTY_FOUR_PERCENT, THIRTY_TWO_PERCENT, THIRTY_FIVE_PERCENT, THIRTY_SEVEN_PERCENT };
	public static final double[] bracketArray = new double[] { TEN_PERCENT_BRACKET, TWELVE_PERCENT_BRACKET,
			TWENTY_TWO_PERCENT_BRACKET, TWENTY_FOUR_PERCENT_BRACKET, THIRTY_TWO_PERCENT_BRACKET,
			THIRTY_FIVE_PERCENT_BRACKET, THIRTY_SEVEN_PERCENT_BRACKET };
	public static final double[] mBracketArray = new double[] { M_TEN_PERCENT_BRACKET, M_TWELVE_PERCENT_BRACKET,
			M_TWENTY_TWO_PERCENT_BRACKET, M_TWENTY_FOUR_PERCENT_BRACKET, M_THIRTY_TWO_PERCENT_BRACKET,
			M_THIRTY_FIVE_PERCENT_BRACKET, M_THIRTY_SEVEN_PERCENT_BRACKET };
	public static final double[] hBracketArray = new double[] { H_TEN_PERCENT_BRACKET, H_TWELVE_PERCENT_BRACKET,
			H_TWENTY_TWO_PERCENT_BRACKET, H_TWENTY_FOUR_PERCENT_BRACKET, H_THIRTY_TWO_PERCENT_BRACKET,
			H_THIRTY_FIVE_PERCENT_BRACKET, H_THIRTY_SEVEN_PERCENT_BRACKET };
	public static final String[] rateStringArray = new String[] { TEN_PERCENT_STRING, TWELVE_PERCENT_STRING,
			TWENTY_TWO_PERCENT_STRING, TWENTY_FOUR_PERCENT_STRING, THIRTY_TWO_PERCENT_STRING,
			THIRTY_FIVE_PERCENT_STRING, THIRTY_SEVEN_PERCENT_STRING };
}
