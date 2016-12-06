/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joalgoca.validatorLayout.validatorDefinition;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 *
 * @author jgonzalezc
 */
@XmlRootElement(name="ItemValidator")
@XmlSeeAlso( { ObjectRegexValidator.class,ObjectTypeValidator.class,ObjectDateValidator.class })
public class ItemValidator {
    private List<ObjectValidatorInterface> listObjectValidatorInterface;
    private String name;
    private String description;
    private String validateFormat;
    private boolean validate;
    private FlatFixedPositionValue flatFixedItemValue;
     
    public ItemValidator(){
        this.name=null;
        this.description=null;
        this.validateFormat=null;
        this.validate=true;
    }
    public ItemValidator(String name,boolean validate){
        this.name=name;
        this.validate=validate;
    }
    
    public ItemValidator(String name,boolean validate,String description,String validateFormat){
        this.name=name;
        this.validate=validate;
        this.description=description;
        this.validateFormat=validateFormat;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    @XmlAttribute( name = "name" )
    public void setName(String name) {
        this.name = name;
    }
    

    /**
     * @return the validate
     */
    public boolean isValidate() {
        return validate;
    }

    /**
     * @param validate the validate to set
     */
    @XmlAttribute( name = "validate" )
    public void setValidate(boolean validate) {
        this.validate = validate;
    }

    /**
     * @return the flatFixedItemValue
     */
    public FlatFixedPositionValue getFlatFixedItemValue() {
        return flatFixedItemValue;
    }

    /**
     * @param flatFixedItemValue the flatFixedItemValue to set
     */
    public void setFlatFixedItemValue(FlatFixedPositionValue flatFixedItemValue) {
        this.flatFixedItemValue = flatFixedItemValue;
    }

    /**
     * @return the listValidators
     */
    public List<ObjectValidatorInterface> getListObjectValidatorInterface() {
        return listObjectValidatorInterface;
    }

    /**
     * @param listObjectValidatorInterface the listValidators to set
     */
    public void setListObjectValidatorInterface(List<ObjectValidatorInterface> listObjectValidatorInterface) {
        this.listObjectValidatorInterface = listObjectValidatorInterface;
    }
    /**
     * @param objectValidatorInterface
     */
    public void addObjectValidatorInterface(ObjectValidatorInterface objectValidatorInterface) {
        if(listObjectValidatorInterface==null)
            listObjectValidatorInterface=new ArrayList();
        this.listObjectValidatorInterface.add(objectValidatorInterface);
    }
    
    public ResponseValidator validate(String value) {
        ResponseValidator response;
        StringBuilder stringBuilder=new StringBuilder();
        try{
            if(listObjectValidatorInterface!=null){
                if(value!=null){
                    boolean success=true;
                    int i=0;
                    for(ObjectValidatorInterface validator:listObjectValidatorInterface){
                        ResponseValidator responseValidator=validator.validate(value);
                        if(!responseValidator.isSuccess() ){
                            stringBuilder.append("{\"id\":").append(i).append(",\"ObjectValidatorInterface\": ").append(responseValidator).append("},");
                            success=false;
                        }
                        i++;
                    }
                    response=new ResponseValidator(success, "{\"name\":\""+getName()+"\",\"success\":"+success+",\"listObjectValidatorInterface\": ["+(success?"{\"Success validation.\"}":stringBuilder.substring(0,stringBuilder.toString().length()-1))+"]}");
                }else
                    response=new ResponseValidator(false, stringBuilder.append("{\"name\":\"").append(getName()).append("\",\"success\":false,\"message\":\"Value cant be null\"}").toString());
            }else
                response=new ResponseValidator(false, stringBuilder.append("{\"name\":\"").append(getName()).append("\",\"success\":false,\"message\":\"Any validator has been defined.\"}").toString());
                    
        }catch(Exception e){
            response=new ResponseValidator(false, stringBuilder.append("{\"name\":\"").append(getName()).append("\",\"success\":false,\"message\":\"Exception: ").append(e.getMessage()).append("\"}").toString());            
        }
        return response;
    }
    
    @Override
    public String toString(){
        String devolver="{"+
            "\"name\":"+(name!=null?"\""+name+"\"":null)+","+
            "\"description\":"+(description!=null?"\""+description+"\"":null)+","+
            "\"validateFormat\":"+(validateFormat!=null?"\""+validateFormat+"\"":null)+","+
            "\"validate\":"+validate+","+
            "\"flatFixedItemValue\":"+(flatFixedItemValue!=null?flatFixedItemValue:null)+","+
            "\"itemValidator\":[";
            StringBuilder strbuilder=new StringBuilder();
            listObjectValidatorInterface.stream().forEach((objectValidatorInterface) -> {
                strbuilder.append(objectValidatorInterface.toString()).append(",");
            });
            devolver+=(strbuilder.length()>0?strbuilder.substring(0,strbuilder.length()-1):strbuilder.toString())+"]}";
        return devolver;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    @XmlAttribute( name = "description" )
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the validateFormat
     */
    public String getValidateFormat() {
        return validateFormat;
    }

    /**
     * @param validateFormat the validateFormat to set
     */
    @XmlAttribute( name = "validateFormat" )
    public void setValidateFormat(String validateFormat) {
        this.validateFormat = validateFormat;
    }
    
}
