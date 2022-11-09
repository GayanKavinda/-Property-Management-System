/*
 * IT18011494 Nasome P.V.R.D.V.
 * 
 * 
 */
package util;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



public class Query {

	 
		public static String queryByID(String id) throws SAXException, IOException, ParserConfigurationException {

			NodeList nodeList;
			Element element = null;
			/*
			 * Read the EmployeeQuery.xml file and read each query node into node
			 * list. It refers tag name query
			 */
			nodeList = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(System.getProperty("catalina.base") + "\\wtpwebapps\\Register\\WEB-INF\\query.xml"))
					.getElementsByTagName("query");

			/*
			 * Extract the node from node list using query id query id is taken from
			 * query node attribute
			 */
			for (int value = 0; value < nodeList.getLength(); value++) {
				element = (Element) nodeList.item(value);
				if (element.getAttribute("id").equals(id))
					break;
			}
			return element.getTextContent().trim();
		}
}
