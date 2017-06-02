package acacia.ui.testing.utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

/**
 * Created by miaomiao on 6/2/2017.
 */
public class ReadXMLFile {


    public static void readXMLwithSAXReader(String xmlPath) {
        SAXReader reader = new SAXReader();
        Document document = null;
        String xmlFile = System.getProperty("user.dir") + File.separator + xmlPath;
        File file = new File(xmlFile);
        try {
            document = reader.read(file);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        Element rootelement = document.getRootElement();
        String rootElementName = rootelement.getName();
        System.out.println("Root element name is :" + rootElementName);
        List<Element> subElement = rootelement.elements();
        for (int i = 0; i < subElement.size(); i++) {
            System.out.format("The subelement %s is %s%n", i, subElement.get(i).getName());
            if (subElement.get(i).getName().equalsIgnoreCase("qa-suite")) {
                String qa_suite_value = subElement.get(i).elementText("value");
                System.out.println("The qa-suite value is " + qa_suite_value);
            }
        }
    }
}
