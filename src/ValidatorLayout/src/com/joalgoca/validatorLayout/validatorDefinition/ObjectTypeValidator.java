/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joalgoca.validatorLayout.validatorDefinition;

import java.text.SimpleDateFormat;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jgonzalezc
 */
@XmlRootElement(name="ObjectTypeValidator")
public class ObjectTypeValidator implements ObjectValidatorInterface{

    private String format;
    private TypeObjectEnum typeObject;
    
    public ObjectTypeValidator(){
        this.format=null;
        this.typeObject=null;
    }
    
    public ObjectTypeValidator(TypeObjectEnum typeObject,String format){
        this.format=format;
        this.typeObject=typeObject;
    }
    
    @Override
    public ResponseValidator validate(String value) {
        ResponseValidator response;
        try{
            if(getTypeObject()!=null){
                if(value!=null){
                    switch(getTypeObject()){
                        case BOOLEAN:
                            if(isBoolean(value))
                                response=new ResponseValidator(true, "\"ObjectTypeValidator: Success boolean validation.\"");
                            else                                
                                response=new ResponseValidator(false, "\"ObjectTypeValidator: Unsuccess boolean validation.\"");
                            break;
                        case INTEGER:
                            if(isInteger(value))
                                response=new ResponseValidator(true, "\"ObjectTypeValidator: Success integer validation.\"");
                            else                                
                                response=new ResponseValidator(false, "\"ObjectTypeValidator: Unsuccess integer validation.\"");
                            break;
                        case DOUBLE:
                            if(isDouble(value))
                                response=new ResponseValidator(true, "\"ObjectTypeValidator: Success double validation.\"");
                            else                                
                                response=new ResponseValidator(false, "\"ObjectTypeValidator: Unsuccess double validation.\"");
                            break;
                        case LONG:
                            if(isLong(value))
                                response=new ResponseValidator(true, "\"ObjectTypeValidator: Success long validation.\"");
                            else                                
                                response=new ResponseValidator(false, "\"ObjectTypeValidator: Unsuccess long validation.\"");
                            break;
                        case DATE:
                            if(isDate(value))
                                response=new ResponseValidator(true, "\"ObjectTypeValidator: Success date validation.\"");
                            else                                
                                response=new ResponseValidator(false, "\"ObjectTypeValidator: Unsuccess date validation.\"");
                            break;
                        default:
                            response=new ResponseValidator(false, "\"ObjectTypeValidator: Unsuccess validation.\"");
                            break;
                    }
                }else
                    response=new ResponseValidator(false, "\"ObjectTypeValidator: Value cant be null.\"");
            }else
                response=new ResponseValidator(false, "\"ObjectTypeValidator: The object type cant be null.\"");
                    
        }catch(Exception e){
            response=new ResponseValidator(false, "\"ObjectTypeValidator: Exception: "+e.getMessage()+"\"");            
        }
        return response;
    }
    // We should replace this body of this methods, for better solutions.
    private boolean isInteger(String s) {
        try{
            s=s.replaceAll(",", "").trim();
            Integer.parseInt(s);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    private boolean isDouble(String s) {
        try{
            s=s.replaceAll(",", "").replace(".", "").trim();
            Double.parseDouble(s);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    private boolean isBoolean(String s) {
        try{
            Double.parseDouble(s);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    private boolean isLong(String s) {
        try{
            s=s.replaceAll(",", "").trim();
            Long.parseLong(s);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    private boolean isDate(String s) {
        try{
            SimpleDateFormat dateFormat;
            if(getFormat()!=null)
                dateFormat=new SimpleDateFormat(getFormat());
            else
                dateFormat=new SimpleDateFormat("yyyy-MM-dd");                
            dateFormat.parse(s);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    /**
     * @return the format
     */
    public String getFormat() {
        return format;
    }

    /**
     * @param format the format to set
     */
    @XmlAttribute( name = "format" )
    public void setFormat(String format) {
        this.format = format;
    }

    /**
     * @return the typeObject
     */
    public TypeObjectEnum getTypeObject() {
        return typeObject;
    }

    /**
     * @param typeObject the typeObject to set
     */
    @XmlAttribute( name = "typeObject" )
    public void setTypeObject(TypeObjectEnum typeObject) {
        this.typeObject = typeObject;
    }
    
    
    @Override
    public String toString(){
        return "{\"name\":\"TypeObjectValidator\",\"typeObject\":"+(typeObject!=null?"\""+typeObject+"\"":null)+",\"format\":"+(format!=null?"\""+format+"\"":null)+"}";
    }
       
}

