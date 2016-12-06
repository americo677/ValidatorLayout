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
@XmlRootElement(name="FlatFixedPositionValue")
public class FlatFixedPositionValue{
    private Integer positionBegin;
    private Integer positionEnd;
    private Integer size;
    
    public FlatFixedPositionValue(){
        this.positionBegin=null;
        this.positionEnd=null;
        this.size=null;
    }
    
    public FlatFixedPositionValue(Integer positionBegin,Integer positionEnd){
        this.positionBegin=positionBegin;
        this.positionEnd=positionEnd;
        this.size=null;
    }
    
    public FlatFixedPositionValue(Integer positionBegin,Integer positionEnd,Integer size){
        this.positionBegin=positionBegin;
        this.positionEnd=positionEnd;
        this.size=size;
    }
    

    /**
     * @return the positionBegin
     */
    public Integer getPositionBegin() {
        return positionBegin;
    }

    /**
     * @param positionBegin the positionBegin to set
     */
    @XmlAttribute( name = "positionBegin" )
    public void setPositionBegin(Integer positionBegin) {
        this.positionBegin = positionBegin;
    }

    /**
     * @return the positionEnd
     */
    public Integer getPositionEnd() {
        return positionEnd;
    }

    /**
     * @param positionEnd the positionEnd to set
     */
    @XmlAttribute( name = "positionEnd" )
    public void setPositionEnd(Integer positionEnd) {
        this.positionEnd = positionEnd;
    }
    
    @Override
    public String toString(){
        String devolver="{"+
            "\"positionBegin\":"+positionBegin+","+
            "\"size\":"+size+","+
            "\"positionEnd\":"+positionEnd+"}";
        return devolver;
    }

    /**
     * @return the size
     */
    public Integer getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    @XmlAttribute( name = "size" )
    public void setSize(Integer size) {
        this.size = size;
    }
    
}
