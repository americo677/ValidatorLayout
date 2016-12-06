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

/**
 *
 * @author jgonzalezc
 */
@XmlRootElement(name="RowValidator")
public class RowValidator {
    private List<ItemValidator> listItemValidator;
    private String name;
    private String description;
    private FlatFixedPositionValue flatFixedTypeRow;
    
    public RowValidator(String name,String description){
        this.name=name;
        this.description=description;
    }

    public RowValidator(){
        this.name=null;
        this.description=null;
    }
    /**
     * @return the listItemValidator
     */
    public List<ItemValidator> getListItemValidator() {
        return listItemValidator;
    }

    /**
     * @param listItemValidator the listItemValidator to set
     */
    public void setListItemValidator(List<ItemValidator> listItemValidator) {
        this.listItemValidator = listItemValidator;
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
     * @param itemValidator
     */
    public void addItemValidator(ItemValidator itemValidator) {
        if(listItemValidator==null)
            listItemValidator=new ArrayList();
        this.listItemValidator.add(itemValidator);
    }
    
    public ResponseValidator validate(String[] values) {
        ResponseValidator response;
        StringBuilder stringBuilder=new StringBuilder();
        try{
            if(listItemValidator!=null){
                if(values!=null){
                    if(values.length==listItemValidator.size()){
                        boolean success=true;
                        int i=0;
                        for(ItemValidator itemValidator:listItemValidator){
                            ResponseValidator responseValidator=itemValidator.validate(values[i]);
                            if(!responseValidator.isSuccess() ){
                                stringBuilder.append("{\"id\":").append(i).append(",\"ItemValidator\": ").append(responseValidator.getMessage()).append("},");
                                success=false;
                            }
                            i++;
                        }
                        response=new ResponseValidator(success, "{\"name\":\""+name+"\",\"success\":"+success+",\"message\":"+(success?"\"Success validation.\"":"\"Unsuccess validation.\",\"listItemValidator\": ["+stringBuilder.substring(0,stringBuilder.toString().length()-1)+"]")+"}");
                    }else
                        response=new ResponseValidator(false, stringBuilder.append("{\"name\":\"").append(name).append("\",\"success\":false,\"message\":\"Values.lenght != listItemValidator.size()\"}").toString());
                }else
                    response=new ResponseValidator(false, stringBuilder.append("{\"name\":\"").append(name).append("\",\"success\":false,\"message\":\"Value cant be null.\"}").toString());
            }else
                response=new ResponseValidator(false, stringBuilder.append("{\"name\":\"").append(name).append("\",\"success\":false,\"message\":\"Any validator has been defined.\"}").toString());
                    
        }catch(Exception e){
            response=new ResponseValidator(false, stringBuilder.append("{\"name\":\"").append(name).append("\",\"success\":false,\"message\":\"Exception: ").append(e.getMessage()).append("\"}").toString());            
        }
        return response;
    }
    
    @Override
    public String toString(){
        String devolver="{"+
            "\"name\":"+(name!=null?"\""+name+"\"":null)+","+
            "\"description\":"+(description!=null?"\""+description+"\"":null)+","+
            "\"flatFixedTypeRow\":"+(flatFixedTypeRow!=null?flatFixedTypeRow:null)+","+
            "\"rowValidator\":[";
            StringBuilder strbuilder=new StringBuilder();
            listItemValidator.stream().forEach((ItemValidator itemValidator) -> {
                strbuilder.append(itemValidator.toString()).append(",");
            });
            devolver+= (strbuilder.length()>0?strbuilder.substring(0,strbuilder.length()-1):strbuilder.toString())+"]}";
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
     * @return the flatFixedTypeRow
     */
    public FlatFixedPositionValue getFlatFixedTypeRow() {
        return flatFixedTypeRow;
    }

    /**
     * @param flatFixedTypeRow the flatFixedTypeRow to set
     */
    public void setFlatFixedTypeRow(FlatFixedPositionValue flatFixedTypeRow) {
        this.flatFixedTypeRow = flatFixedTypeRow;
    }
}
