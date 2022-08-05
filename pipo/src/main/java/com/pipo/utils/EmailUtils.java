package com.pipo.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailUtils {

	public static boolean isEmailValido(String email) {
	    boolean isEmailValido = false;
	    if (email != null && email.length() > 0) {
	        String esxpressao = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
	        Pattern pattern = Pattern.compile(esxpressao, Pattern.CASE_INSENSITIVE);
	        Matcher matcher = pattern.matcher(email);
	        if (matcher.matches()) {
	        	isEmailValido = true;
	        }
	    }
	    return isEmailValido;
	}
}
