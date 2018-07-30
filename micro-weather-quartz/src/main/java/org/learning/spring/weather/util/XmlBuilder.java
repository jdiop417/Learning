package org.learning.spring.weather.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.InputStream;

public class XmlBuilder {
    public static Object xmlStr2Object(Class<?> clazz, InputStream in) throws JAXBException, IOException {
        Object xmlObject = null;
        JAXBContext context = JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        xmlObject = unmarshaller.unmarshal(in);

        return xmlObject;
    }
}
