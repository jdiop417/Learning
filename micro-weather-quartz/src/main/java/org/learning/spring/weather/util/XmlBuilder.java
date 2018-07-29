package org.learning.spring.weather.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class XmlBuilder {
    public static Object xmlStr2Object(String xmlStr, Class<?> clazz) throws JAXBException, IOException {
        Object xmlObject = null;
        JAXBContext context = JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Reader reader = new StringReader(xmlStr);
        xmlObject = unmarshaller.unmarshal(reader);
        if (reader != null) {
            reader.close();
        }
        return xmlObject            ;
    }
}
