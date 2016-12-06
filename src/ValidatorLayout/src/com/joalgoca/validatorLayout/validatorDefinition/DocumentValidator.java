/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joalgoca.validatorLayout.validatorDefinition;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jgonzalezc
 */
@XmlRootElement(name="DocumentValidator")
public class DocumentValidator {
    private List<RowValidator> listRowValidator;
    private FlatFixedPositionValue flatFixedRowValue;
    
    public DocumentValidator(){
    }

    /**
     * @return the listRowValidator
     */
    public List<RowValidator> getListRowValidator() {
        return listRowValidator;
    }

    /**
     * @param listRowValidator the listRowValidator to set
     */
    public void setListRowValidator(List<RowValidator> listRowValidator) {
        this.listRowValidator = listRowValidator;
    }    
    /**
     * @param rowValidator
     */
    public void addRowValidator(RowValidator rowValidator) {
        if(listRowValidator==null)
            listRowValidator=new ArrayList();
        this.listRowValidator.add(rowValidator);
    }

    /**
     * @return the flatFixedRowValue
     */
    public FlatFixedPositionValue getFlatFixedRowValue() {
        return flatFixedRowValue;
    }

    /**
     * @param flatFixedRowValue the flatFixedRowValue to set
     */
    public void setFlatFixedRowValue(FlatFixedPositionValue flatFixedRowValue) {
        this.flatFixedRowValue = flatFixedRowValue;
    }

    
}
