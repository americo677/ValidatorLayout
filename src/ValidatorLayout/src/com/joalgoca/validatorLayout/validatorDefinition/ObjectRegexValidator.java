/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joalgoca.validatorLayout.validatorDefinition;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author jgonzalezc
 */
@XmlRootElement(name="ObjectRegexValidator")
public class ObjectRegexValidator implements ObjectValidatorInterface{
    private String regularExpresion;
    
    public ObjectRegexValidator(){
        this.regularExpresion=null;
    }

    public ObjectRegexValidator(String regularExpresion){
        this.regularExpresion=regularExpresion;
    }
    
    @Override
    public ResponseValidator validate(String value) {
        ResponseValidator response;
        try{
            if(regularExpresion!=null){
                if(value!=null){
                    if(value.matches(regularExpresion))
                        response=new ResponseValidator(true, "\"ObjectRegexValidator: Success validation.\"");
                    else
                        response=new ResponseValidator(false, "\"ObjectRegexValidator: Unsuccess validation\"");
                }else
                    response=new ResponseValidator(false, "\"ObjectRegexValidator: Value cant be null.\"");
            }else
                response=new ResponseValidator(false, "\"ObjectRegexValidator: Regular expression cant be null.\"");
                    
        }catch(Exception e){
            response=new ResponseValidator(false, "\"ObjectRegexValidator: Exception: "+e.getMessage()+"\"");            
        }
        return response;
    }
    /**
     * @return the regularExpresion
     */
    public String getRegularExpresion() {
        return regularExpresion;
    }

    /**
     * @param regularExpresion the regularExpresion to set
     */
    @XmlAttribute( name = "regularExpresion" )
    public void setRegularExpresion(String regularExpresion) {
        this.regularExpresion = regularExpresion;
    }
    
    @Override
    public String toString(){
        return "{\"name\":\"ObjectRegexValidator\",\"regularExpresion\":"+(regularExpresion!=null?"\""+regularExpresion+"\"":null)+"}";
    }
    
}
