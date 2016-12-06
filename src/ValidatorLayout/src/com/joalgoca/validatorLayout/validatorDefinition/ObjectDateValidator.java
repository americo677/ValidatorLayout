/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joalgoca.validatorLayout.validatorDefinition;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jgonzalezc
 */
@XmlRootElement(name="ObjectDateValidator")
public class ObjectDateValidator  implements ObjectValidatorInterface{
    private TypeOperationDateEnum typeOperationDate;
    private String format;
    private Integer addless;
    
    public ObjectDateValidator(){
        this.addless=0;
        this.format=null;
        this.typeOperationDate=null;
    }
    
    public ObjectDateValidator(TypeOperationDateEnum typeOperationDate,String format,Integer addless){
        this.addless=addless;
        this.format=format;
        this.typeOperationDate=typeOperationDate;
    }

    /**
     * @return the typeOperationDate
     */
    public TypeOperationDateEnum getTypeOperationDate() {
        return typeOperationDate;
    }

    /**
     * @param typeOperationDate the typeOperationDate to set
     */
    @XmlAttribute( name = "typeOperationDateEnum" )
    public void setTypeOperationDate(TypeOperationDateEnum typeOperationDate) {
        this.typeOperationDate = typeOperationDate;
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
     * @return the addless
     */
    public Integer getAddless() {
        return addless;
    }    

    /**
     * @param addless the addless to set
     */
    @XmlAttribute( name = "addless" )
    public void setAddless(Integer addless) {
        this.addless = addless;
    }
    
    @Override
    public ResponseValidator validate(String value) {
        ResponseValidator response;
        try{
            if(typeOperationDate!=null){
                if(value!=null){ 
                    if(isDate(value)){
                        Calendar todayCalendar=new GregorianCalendar();
                        SimpleDateFormat dateFormat=(format!=null?new SimpleDateFormat(format):new SimpleDateFormat("yyyy-MM-dd"));
                        switch(typeOperationDate){
                            case TODAY:
                                if(dateFormat.format(new Date(todayCalendar.getTimeInMillis())).equals(value))
                                    response=new ResponseValidator(true, "\"ObjectDateValidator: Success today validation.\"");
                                else                                
                                    response=new ResponseValidator(false, "\"ObjectDateValidator: Unsuccess today validation.\"");
                                break;
                            case ADDDAYS:
                                todayCalendar.add(Calendar.DAY_OF_MONTH, addless);
                                if(dateFormat.format(new Date(todayCalendar.getTimeInMillis())).equals(value))
                                    response=new ResponseValidator(true, "\"ObjectDateValidator: Success adddays "+addless+" validation.\"");
                                else                                
                                    response=new ResponseValidator(false, "\"ObjectDateValidator: Unsuccess  adddays "+addless+" validation.\"");
                                break;
                            case LESSDAYS:
                                todayCalendar.add(Calendar.DAY_OF_MONTH, -addless);
                                if(dateFormat.format(new Date(todayCalendar.getTimeInMillis())).equals(value))
                                    response=new ResponseValidator(true, "\"ObjectDateValidator: Success  lessays "+addless+" validation.\"");
                                else                                
                                    response=new ResponseValidator(false, "\"ObjectDateValidator: Unsuccess  lessdays "+addless+" validation.\"");
                                break;
                            case BETWEENMOREDAYS:
                                todayCalendar.set(Calendar.HOUR,0);
                                todayCalendar.set(Calendar.MINUTE,0);
                                todayCalendar.set(Calendar.SECOND,0);
                                Date todayDate=new Date(todayCalendar.getTimeInMillis());
                                todayCalendar.add(Calendar.DAY_OF_MONTH, addless+1);
                                Date finishDate=new Date(todayCalendar.getTimeInMillis());
                                Date valueDate=dateFormat.parse(value);
                                if(valueDate.getTime()>=todayDate.getTime() && valueDate.getTime()<finishDate.getTime())
                                    response=new ResponseValidator(true, "\"ObjectTypeValidator: Success  between today and "+addless+" validation.\"");
                                else                                
                                    response=new ResponseValidator(false, "\"ObjectDateValidator: Unsuccess between   today and  "+addless+" validation.\"");
                                break;
                            case BETWEENLESSDAYS:
                                todayCalendar.set(Calendar.HOUR,0);
                                todayCalendar.set(Calendar.MINUTE,0);
                                todayCalendar.set(Calendar.SECOND,0);
                                Date todayDatel=new Date(todayCalendar.getTimeInMillis());
                                todayCalendar.add(Calendar.DAY_OF_MONTH, -(addless+1));
                                Date finishDatel=new Date(todayCalendar.getTimeInMillis());
                                Date valueDatel=dateFormat.parse(value);
                                if(valueDatel.getTime()>finishDatel.getTime() && valueDatel.getTime()<=todayDatel.getTime())
                                    response=new ResponseValidator(true, "\"ObjectDateValidator: Success  between "+addless+" and today validation.\"");
                                else                                
                                    response=new ResponseValidator(false, "\"ObjectDateValidator: Unsuccess between   today and  "+addless+" validation.\"");
                                break;
                            default:
                                response=new ResponseValidator(false, "\"ObjectDateValidator: Unsuccess validation.\"");
                                break;
                        }
                    }else
                        response=new ResponseValidator(false, "\"ObjectDateValidator: Unsuccess format date validation.\"");
                }else
                    response=new ResponseValidator(false, "\"ObjectDateValidator: Value cant be null.");
            }else
                response=new ResponseValidator(false, "\"ObjectDateValidator: The object type cant be null.\"");
                    
        }catch(Exception e){
            response=new ResponseValidator(false, "\"ObjectDateValidator: Exception: "+e.getMessage()+"\"");            
        }
        return response;
    }
    
    @Override
    public String toString(){
        return "{\"name\":\"ObjectDateValidator\",\"addless\":"+(getAddless()!=null?"\""+getAddless()+"\"":null)+",\"typeOperationDateEnum\":"+(getTypeOperationDate()!=null?"\""+getTypeOperationDate()+"\"":null)+"}";
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
}
