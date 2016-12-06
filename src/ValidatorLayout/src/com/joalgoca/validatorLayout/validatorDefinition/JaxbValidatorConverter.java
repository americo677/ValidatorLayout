/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joalgoca.validatorLayout.validatorDefinition;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author jgonzalezc
 */
public class JaxbValidatorConverter {
    
    public static String createXmlFromObject(Object object){
        StringWriter sw = new StringWriter();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(object, sw);
            return sw.toString();

          } catch (JAXBException e) {
            e.printStackTrace();
          }
        return null;
    }
    
    public static Object createObjectFromXml(InputStream inputStream,Object object){
        Object responseObject=null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            responseObject= jaxbUnmarshaller.unmarshal( inputStream );
        } catch (JAXBException e) {
            Logger.getLogger(JaxbValidatorConverter.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            if(inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException ex) {
                    Logger.getLogger(JaxbValidatorConverter.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
                } 
            }
        }
        return responseObject;
    }
}
