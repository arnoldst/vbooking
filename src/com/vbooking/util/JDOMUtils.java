package com.vbooking.util;

import java.io.IOException;
import java.io.StringReader;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.jdom.xpath.XPath;

public class JDOMUtils {
	public static Document parseToJDOMdoc(String xmlString) {
		StringReader stringReader = new StringReader(xmlString);
		SAXBuilder parser = new SAXBuilder();

		try {
			return parser.build(stringReader);
		} catch (IOException var4) {
			throw new RuntimeException("IOException", var4);
		} catch (JDOMException var5) {
			throw new RuntimeException("JDOM building error with reponse XML", var5);
		}
	}

	public static String getDataField(Document dataDocument, String xpathString, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		Element retreivedElement = getElement(dataDocument, xpathString, request, response);
		return retreivedElement.getText().trim();
	}

	public static Element getElement(Document dataDocument, String xpathString, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		try {
			XPath xpath = XPath.newInstance(xpathString);
			Element retreivedElement = (Element) xpath.selectSingleNode(dataDocument);
			if (retreivedElement != null && retreivedElement.getText() != null) {
				return retreivedElement;
			} else {
				request.setAttribute("msg", "Bad response XML. Failed to retrieve expected field");
				XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());
				String dataDocString = xmlOutputter.outputString(dataDocument);
				request.setAttribute("details", "using xpath '" + xpathString + "'<BR>\n" + "dataDocString '"
						+ HTMLUtils.addHTMLentities(dataDocString, true) + "'");
				throw new ServletException("Bad response XML");
			}
		} catch (JDOMException var8) {
			var8.printStackTrace();
			throw new ServletException("XPATH Error", var8);
		}
	}
}
