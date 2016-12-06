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
@XmlRootElement( name = "RegexObjectValidator" )
public class ResponseValidator {
    private boolean success;
    private String message;

    public ResponseValidator(boolean success,String message){
        this.success=success;
        this.message=message;
    }
    public ResponseValidator(){
        this.success=false;
        this.message=null;
    }
    /**
     * @return the success
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * @param success the success to set
     */
    @XmlAttribute( name = "success", required = true )
    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    @XmlAttribute( name = "message" )
    public void setMessage(String message) {
        this.message = message;
    }
    
    @Override
    public boolean equals(Object obj)
    {
        if(this == obj)
            return true;
        if((obj == null) || (obj.getClass() != this.getClass()))
                return false;
        // object must be Test at this point
        ResponseValidator test = (ResponseValidator)obj;
        return success == test.success &&
        ((message == null ? test.message == null : message.equals(test.message)) || (message != null && message.equals(test.message)));
    }

    @Override
    public int hashCode()
    {
            int hash = 7;
            hash = 31 * hash +  (success ? 1 : 0);
            hash = 31 * hash + (null == message ? 0 : message.hashCode());
            return hash;
    }
    
    @Override
    public String toString(){
        String devolver="{"+
                "\"success\":"+success+","+
                "\"message\":"+(message!=null?message:null)+
                "}";
        return devolver;
    }
}
