package com.example.lib_hw7;

import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XSSFixed {

	public static void main(String args[]) {
		//find an input "skippe which was not "XSS" here
		// assume "s" is the input that may be susceptible to XSS attacks

		String s = "<script†>"; // malicious input

		// Deletes all non-valid characters first before matching (ANSWER)
		s = s.replaceAll("[^\\p{ASCII}]", "");

		//String s = "<script> alert('hey there, you have been hacked') </script> ";
		//			String s = "\uFE64" + "script" + "\uFE65";
		s = Normalizer.normalize(s, Form.NFKC);
		Pattern pattern = Pattern.compile("<script>");
		Matcher matcher = pattern.matcher(s);
		if (matcher.find()) {
			System.out.println("blacklisted tag");
		} else {
			// . . .
		}
		System.out.println(s);
		//find an input "skipped which was is "XSS" here
	}
}
