/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joalgoca.validatorLayout.layoutDefinition;

import com.joalgoca.validatorLayout.validatorDefinition.DocumentValidator;
import com.joalgoca.validatorLayout.validatorDefinition.JaxbValidatorConverter;
import com.joalgoca.validatorLayout.validatorDefinition.ResponseValidator;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 *
 * @author jgonzalezc
 */
public abstract class DocumentLayoutAbstract {
    private String fileName;
    private boolean readyToValidate;
    protected DocumentValidator documentValidator;
    
    public DocumentLayoutAbstract(){
        fileName=null;
        readyToValidate=false;
        documentValidator=new DocumentValidator();
    }
    public final void loadDocumentValidator(String path) throws Exception{
        loadDocumentValidator(new FileInputStream(new File(path)));
    }
    public final void loadDocumentValidator(InputStream inputStream) throws Exception{        
        documentValidator=(DocumentValidator)JaxbValidatorConverter.createObjectFromXml(inputStream,documentValidator);
        readyToValidate=true;
    }
    
    public abstract ResponseValidator validateDocument(InputStream inputStream);

    /**
     * @return the fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @param fileName the fileName to set
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * @return the readyToValidate
     */
    public boolean isReadyToValidate() {
        return readyToValidate;
    }

       
    
}
