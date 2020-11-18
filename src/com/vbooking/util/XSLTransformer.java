package com.vbooking.util;

import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.jdom.Document;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class XSLTransformer {
	private Map<String, Transformer> transformerCache = new HashMap();
	private String path = null;

	public XSLTransformer(String setPath) {
		this.path = setPath;
	}

	public String transform(String xsltName, String xmlString) {
		if (xmlString == null) {
			throw new IllegalArgumentException("xmlString cannot be null");
		} else {
			Transformer trans = this.getTransformer(xsltName);
			Source xmlSource = new StreamSource(new StringReader(xmlString));
			StringWriter sw = new StringWriter();

			try {
				trans.transform(xmlSource, new StreamResult(sw));
			} catch (TransformerException var7) {
				var7.printStackTrace();
			}

			String transformedXML = sw.toString();
			System.out.println("Run xslt '" + xsltName + "' transformedXML: " + transformedXML);
			return transformedXML;
		}
	}

	public String transform(String xsltName, Document xmlDocument) {
		XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
		String xmlString = outputter.outputString(xmlDocument);
		return this.transform(xsltName, xmlString);
	}

	private Transformer getTransformer(String name) {
		Transformer trans = (Transformer) this.transformerCache.get(name);
		if (trans == null) {
			File xsltFile = new File(this.path, name);
			Source xsltSource = new StreamSource(xsltFile);
			TransformerFactory transFact = TransformerFactory.newInstance();

			try {
				trans = transFact.newTransformer(xsltSource);
				this.transformerCache.put(name, trans);
			} catch (TransformerConfigurationException var7) {
				System.err.println("Error making new XSLT transformer '" + name + "'");
				var7.printStackTrace();
			}
		}

		return trans;
	}
}