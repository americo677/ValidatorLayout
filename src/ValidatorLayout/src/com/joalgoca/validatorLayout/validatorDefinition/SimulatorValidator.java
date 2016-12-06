/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joalgoca.validatorLayout.validatorDefinition;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author jgonzalezc
 */
public class SimulatorValidator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*DocumentValidator documentValidator=new DocumentValidator();
        documentValidator.setFlatFixedRowValue(new FlatFixedPositionValue(0,2));
        RowValidator itemsValidatorHeader=new RowValidator("01","Header");        
        itemsValidatorHeader.setFlatFixedTypeRow(new FlatFixedPositionValue(0,2,15));
        itemsValidatorHeader.addItemValidator(new ItemValidator("tipo",true,"Identifica el tipo de registro. ","Debe ser numérico y siempre debe de contener 01"));
        itemsValidatorHeader.getListItemValidator().get(0).setFlatFixedItemValue(new FlatFixedPositionValue(0,2));
        itemsValidatorHeader.getListItemValidator().get(0).addObjectValidatorInterface(new ObjectRegexValidator("01"));
        itemsValidatorHeader.addItemValidator(new ItemValidator("secuencia",true,"Número de registro incremental ascendente","Debe ser numérico"));
        itemsValidatorHeader.getListItemValidator().get(1).setFlatFixedItemValue(new FlatFixedPositionValue(2,7));
        itemsValidatorHeader.getListItemValidator().get(1).addObjectValidatorInterface(new ObjectRegexValidator("[0-9]{5}"));
        itemsValidatorHeader.addItemValidator(new ItemValidator("fecha",true,"Fecha actual","Fecha del dia de hoy"));
        itemsValidatorHeader.getListItemValidator().get(2).setFlatFixedItemValue(new FlatFixedPositionValue(7,15));
        itemsValidatorHeader.getListItemValidator().get(2).addObjectValidatorInterface(new ObjectDateValidator(TypeOperationDateEnum.TODAY,"ddMMyyyy",0));
        RowValidator itemsValidatorBody=new RowValidator("02","Body");
        itemsValidatorBody.setFlatFixedTypeRow(new FlatFixedPositionValue(0,2,32));
        itemsValidatorBody.addItemValidator(new ItemValidator("tipo",true,"Identifica el tipo de registro. ","Debe ser numérico y siempre debe de contener 02"));
        itemsValidatorBody.getListItemValidator().get(0).setFlatFixedItemValue(new FlatFixedPositionValue(0,2));
        itemsValidatorBody.getListItemValidator().get(0).addObjectValidatorInterface(new ObjectRegexValidator("02"));
        itemsValidatorBody.addItemValidator(new ItemValidator("secuencia",true,"Número de registro incremental ascendente","Debe ser numérico"));
        itemsValidatorBody.getListItemValidator().get(1).setFlatFixedItemValue(new FlatFixedPositionValue(2,7));
        itemsValidatorBody.getListItemValidator().get(1).addObjectValidatorInterface(new ObjectRegexValidator("[0-9]{5}"));
        itemsValidatorBody.addItemValidator(new ItemValidator("rfc",true,"RFC","RFC"));
        itemsValidatorBody.getListItemValidator().get(2).setFlatFixedItemValue(new FlatFixedPositionValue(7,20));
        itemsValidatorBody.getListItemValidator().get(2).addObjectValidatorInterface(new ObjectRegexValidator("^([A-Z,Ñ,&]{3,4}([0-9]{2})(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])[A-Z|\\d]{3})$"));
        itemsValidatorBody.addItemValidator(new ItemValidator("importe",true,"Es el monto de la transacción"," Debe estar informado y los últimos 2 dígitos serviran como decimales y no debe contener punto decimal"));
        itemsValidatorBody.getListItemValidator().get(3).setFlatFixedItemValue(new FlatFixedPositionValue(20,32));
        itemsValidatorBody.getListItemValidator().get(3).addObjectValidatorInterface(new ObjectRegexValidator("\\d{12}"));         
        RowValidator itemsValidatorFooter=new RowValidator("03","Footer");
        itemsValidatorFooter.setFlatFixedTypeRow(new FlatFixedPositionValue(0,2,19));
        itemsValidatorFooter.addItemValidator(new ItemValidator("tipo",true,"Identifica el tipo de registro. ","Debe ser numérico y siempre debe de contener 03"));
        itemsValidatorFooter.getListItemValidator().get(0).setFlatFixedItemValue(new FlatFixedPositionValue(0,2));
        itemsValidatorFooter.getListItemValidator().get(0).addObjectValidatorInterface(new ObjectRegexValidator("03"));
        itemsValidatorFooter.addItemValidator(new ItemValidator("secuencia",true,"Número de registro incremental ascendente","Debe ser numérico"));
        itemsValidatorFooter.getListItemValidator().get(1).setFlatFixedItemValue(new FlatFixedPositionValue(2,7));
        itemsValidatorFooter.getListItemValidator().get(1).addObjectValidatorInterface(new ObjectRegexValidator("[0-9]{5}"));
        itemsValidatorFooter.addItemValidator(new ItemValidator("total",true,"Es el monto total de todos los importes"," Debe estar informado y los últimos 2 dígitos serviran como decimales y no debe contener punto decimal"));
        itemsValidatorFooter.getListItemValidator().get(2).setFlatFixedItemValue(new FlatFixedPositionValue(7,19));
        itemsValidatorFooter.getListItemValidator().get(2).addObjectValidatorInterface(new ObjectRegexValidator("\\d{12}")); 

        documentValidator.addRowValidator(itemsValidatorHeader);
        documentValidator.addRowValidator(itemsValidatorBody);
        documentValidator.addRowValidator(itemsValidatorFooter);*/
        
        DocumentValidator documentValidator=new DocumentValidator();
        RowValidator itemsValidatorHeader=new RowValidator("01","Header");        
        itemsValidatorHeader.addItemValidator(new ItemValidator("TipoRegistro",true,"Identifica el tipo de registro. ","Debe ser numérico y siempre debe de contener 01"));
        itemsValidatorHeader.getListItemValidator().get(0).addObjectValidatorInterface(new ObjectRegexValidator("01"));
        itemsValidatorHeader.addItemValidator(new ItemValidator("Folio",true,"Nombre de columna","Nombre de columna incorrecto"));
        itemsValidatorHeader.getListItemValidator().get(1).addObjectValidatorInterface(new ObjectRegexValidator("Folio"));
        itemsValidatorHeader.addItemValidator(new ItemValidator("NoMovimiento",true,"Nombre de columna","Nombre de columna incorrecto"));
        itemsValidatorHeader.getListItemValidator().get(2).addObjectValidatorInterface(new ObjectRegexValidator("NoMovimiento"));
        itemsValidatorHeader.addItemValidator(new ItemValidator("TipoIndicador",true,"Nombre de columna","Nombre de columna incorrecto"));
        itemsValidatorHeader.getListItemValidator().get(3).addObjectValidatorInterface(new ObjectRegexValidator("TipoIndicador"));
        itemsValidatorHeader.addItemValidator(new ItemValidator("Clave",true,"Nombre de columna","Nombre de columna incorrecto"));
        itemsValidatorHeader.getListItemValidator().get(4).addObjectValidatorInterface(new ObjectRegexValidator("Clave"));
        itemsValidatorHeader.addItemValidator(new ItemValidator("Concepto",true,"Nombre de columnae","Nombre de columna incorrecto"));
        itemsValidatorHeader.getListItemValidator().get(5).addObjectValidatorInterface(new ObjectRegexValidator("Concepto"));
        itemsValidatorHeader.addItemValidator(new ItemValidator("Tipo",true,"Nombre de columna","Nombre de columna incorrecto"));
        itemsValidatorHeader.getListItemValidator().get(6).addObjectValidatorInterface(new ObjectRegexValidator("Tipo"));
        itemsValidatorHeader.addItemValidator(new ItemValidator("Importe",true,"Nombre de columna","Nombre de columna incorrecto"));
        itemsValidatorHeader.getListItemValidator().get(7).addObjectValidatorInterface(new ObjectRegexValidator("Importe"));
        itemsValidatorHeader.addItemValidator(new ItemValidator("ImporteGravado",true,"Nombre de columna","Nombre de columna incorrecto"));
        itemsValidatorHeader.getListItemValidator().get(8).addObjectValidatorInterface(new ObjectRegexValidator("ImporteGravado"));
        itemsValidatorHeader.addItemValidator(new ItemValidator("ImporteExcento",true,"Nombre de columna","Nombre de columna incorrecto"));
        itemsValidatorHeader.getListItemValidator().get(9).addObjectValidatorInterface(new ObjectRegexValidator("ImporteExcento"));
        RowValidator itemsValidatorBody=new RowValidator("02","Body");
        itemsValidatorBody.addItemValidator(new ItemValidator("TipoRegistro",true,"Identifica el tipo de registro. ","Debe ser numérico y siempre debe de contener 02"));
        itemsValidatorBody.getListItemValidator().get(0).addObjectValidatorInterface(new ObjectRegexValidator("02"));
        itemsValidatorBody.addItemValidator(new ItemValidator("secuencia",true,"Número de registro incremental ascendente","Debe ser numérico"));
        itemsValidatorBody.getListItemValidator().get(1).addObjectValidatorInterface(new ObjectRegexValidator("[0-9]{5}"));
        itemsValidatorBody.addItemValidator(new ItemValidator("rfc",true,"RFC","RFC"));
        itemsValidatorBody.getListItemValidator().get(2).addObjectValidatorInterface(new ObjectRegexValidator("^([A-Z,Ñ,&]{3,4}([0-9]{2})(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])[A-Z|\\d]{3})$"));
        itemsValidatorBody.addItemValidator(new ItemValidator("importe",true,"Es el monto de la transacción"," Debe estar informado y los últimos 2 dígitos serviran como decimales y no debe contener punto decimal"));
        itemsValidatorBody.getListItemValidator().get(3).addObjectValidatorInterface(new ObjectRegexValidator("\\d{12}"));         
        

        documentValidator.addRowValidator(itemsValidatorHeader);
        documentValidator.addRowValidator(itemsValidatorBody);
        
        //File f=new File("C:\\Users\\jgonzalezc\\Desktop\\ValidadorLayout\\DocumentoValidatorXLSX.xml");
        /*try{
            FileWriter w = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(w);
            PrintWriter wr = new PrintWriter(bw); 
            wr.write(JaxbValidatorConverter.createXmlFromObject(documentValidator));//escribimos en el archivo
            wr.close();
            bw.close();
        }catch(IOException e){};*/
    }
    
        /*List<String[]> listValues=new ArrayList();
        listValues.add(new String[]{"91010",null,"25.0A"});
        listValues.add(new String[]{"91010","GOCA770804TX8","25"});
        
        for(String[] valores:listValues)
            System.out.println(itemsValidator.validate(valores).getMessage());*/
        
        /*ItemValidator itemValidator=new ItemValidator("CODIGO_POSTAL");
        itemValidator.addObjectValidatorInterface(new ObjectRegexValidator("\\d{1,5}"));
        itemValidator.addObjectValidatorInterface(new TypeObjectValidator(INTEGER,null));*/
        
        /*String xml="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
"<ItemsValidator name=\"body\">\n" +
"    <listItemValidator name=\"codigoPostal\">\n" +
"        <listObjectValidatorInterface xsi:type=\"regexObjectValidator\" regularExpresion=\"\\d{5}\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>\n" +
"    </listItemValidator>\n" +
"    <listItemValidator name=\"rfc\">\n" +
"        <listObjectValidatorInterface xsi:type=\"regexObjectValidator\" regularExpresion=\"^([A-Z,Ñ,&amp;]{3,4}([0-9]{2})(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])[A-Z|\\d]{3})$\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>\n" +
"    </listItemValidator>\n" +
"    <listItemValidator name=\"importe\">\n" +
"        <listObjectValidatorInterface xsi:type=\"regexObjectValidator\" regularExpresion=\"\\d{1,5}\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>\n" +
"        <listObjectValidatorInterface xsi:type=\"typeObjectValidator\" typeObject=\"DOUBLE\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>\n" +
"    </listItemValidator>\n" +
"</ItemsValidator>";
        InputStream stream = new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8));
        
        RowValidator instance =new RowValidator();
        instance=(RowValidator)JaxbValidatorConverter.createObjectFromXml(stream,instance);
        System.out.println(instance);*/
    
    
    
    
    
        //TypeObjectValidator typeObjectValidator=new TypeObjectValidator(DOUBLE,null);
        //System.out.println(createXmlFromObject(typeObjectValidator));
        
        /*String xml="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
"<ItemValidator name=\"CODIGO_POSTAL\">\n" +
"    <listObjectValidatorInterface xsi:type=\"regexObjectValidator\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
"        <regularExpresion>\\d{1,5}</regularExpresion>\n" +
"    </listObjectValidatorInterface>\n" +
"    <listObjectValidatorInterface xsi:type=\"typeObjectValidator\" typeObject=\"INTEGER\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>\n" +
"</ItemValidator>";
        InputStream stream = new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8));
        
        ItemValidator instance =new ItemValidator();
        instance=(ItemValidator)createObjectFromXml(stream,instance);
        System.out.println(instance);
        
        /*ResponseValidator instance = new ResponseValidator(true,"Error de no se que");
        System.out.println(createXmlFromObject(instance));*/
        
        /*String xml="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                    "<RegexObjectValidator message=\"Error de no se que\" success=\"true\"/>";
        InputStream stream = new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8));
        
        ResponseValidator instance =new ResponseValidator();
        instance=(ResponseValidator)createObjectFromXml(stream,instance);
        System.out.println(instance);*/
    //}
   /* private static String createXmlFromObject(Object object){
        StringWriter sw = new StringWriter();
        try {

            //File file = new File("C:\\Users\\jgonzalezc\\Desktop\\file.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            //jaxbMarshaller.marshal(instance, file);
            jaxbMarshaller.marshal(object, sw);
            if(sw!=null)
                return sw.toString();

          } catch (JAXBException e) {
            e.printStackTrace();
          }
        return null;
    }
    
    
    private static Object createObjectFromXml(InputStream inputStream,Object object){
        try {
            //File file = new File("C:\\Users\\jgonzalezc\\Desktop\\file.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            //jaxbMarshaller.marshal(instance, file);
            return jaxbUnmarshaller.unmarshal( inputStream );

          } catch (JAXBException e) {
            e.printStackTrace();
          }
        return null;
    }*/
    
}
