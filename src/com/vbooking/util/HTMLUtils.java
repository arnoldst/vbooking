package com.vbooking.util;

public class HTMLUtils {
	public static String addHTMLentities(String value, boolean addBRtags) {
		StringBuffer outputHTML = new StringBuffer();

		for (int i = 0; i < value.length(); ++i) {
			char ch = value.charAt(i);
			if (ch == '&') {
				outputHTML.append("&amp;");
			} else if (ch == '"') {
				outputHTML.append("&quot;");
			} else if (ch == '<') {
				outputHTML.append("&lt;");
			} else if (ch == '>') {
				outputHTML.append("&gt;");
			} else if (ch == '\n' && addBRtags) {
				outputHTML.append("<BR>\n");
			} else {
				outputHTML.append(ch);
			}
		}

		return outputHTML.toString();
	}
}
