package com.company.validation;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class CustomValidator {

	public boolean nullOrEmpty(String obj){
		if( obj == null || "".equals(obj)){
			return true;
		}

		return false;
	}


	public boolean emailValidate(String email) {

		if(email == null || email == ""){
			return false;
		}

		Pattern regexPattern = Pattern.compile("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$");

		Matcher regMatcher = regexPattern.matcher(email);

		if (regMatcher.matches()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean mobileValidate(String mobileNo) {


		if(mobileNo == null || mobileNo == ""){
			return false;
		}

		// 1) Begins with 0
		// 2) second position contains 1-9.
		// 3) Then contains 9 digits

		Pattern regexPattern = Pattern.compile("^0[1][0-9]{9}");
		Matcher regMatcher = regexPattern.matcher(mobileNo);
		if (regMatcher.matches()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean nidValidate(String nid) {
		if(nid == null || nid == ""){
			return false;
		}

		if (nid.length() == 10 || nid.length() == 17) {

			Pattern regexPattern = Pattern.compile("[0-9]{9,17}");
			Matcher regMatcher = regexPattern.matcher(nid);
			if (regMatcher.matches()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}


	public boolean dateFormatValidate(Date  date){
		if(date == null ){
			return false;
		}
		String dateString = new SimpleDateFormat("dd/MM/yyyy").format(date);
		return dateFormatValidate(dateString);
	}

	public boolean dateFormatValidate(String date) {
		if(date == null || date == ""){
			return false;
		}

		// dd/mm/yyyy

		Pattern regexPattern = Pattern.compile("^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$");
		Matcher regMatcher = regexPattern.matcher(date);
		if (regMatcher.matches()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean subscriberNameValidate(String subscriberName) {

		if(subscriberName == null || subscriberName == ""){
			return false;
		}

	 	Pattern regexPattern = Pattern.compile("^[a-zA-Z._-]+$");

		String subscriberNameWitoutWhitespace = subscriberName.replaceAll("\\s", "");

		// System.out.println("subscriberNameWitoutWhitespace " +
		// subscriberNameWitoutWhitespace);

		Matcher regMatcher = regexPattern.matcher(subscriberNameWitoutWhitespace);

		if (regMatcher.matches()) {
			return true;
		} else {
			return false;
		}

	}

	public boolean stringContainsOnlyNumber(String str) {
		if(str == null || str == "") {
			return false;
		}

		if (!str.matches("[0-9]+")) {
			return false;
		}

		return true;

	}

	public boolean tinValidate(String tin) {

		if(tin == null || tin == ""){
			return false;
		}

		if (tin.length() == 10 || tin.length() == 12) {

			Pattern regexPattern = Pattern.compile("[0-9]+");
			Matcher regMatcher = regexPattern.matcher(tin);
			if (regMatcher.matches()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public Boolean genderValidator(String gender) {
		if(gender == null || gender == ""){
			return false;
		}

		if(gender.equals("M") || gender.equals("F") || gender.equals("O"))
		{
			return true;
		}
		return false;
	}
}
