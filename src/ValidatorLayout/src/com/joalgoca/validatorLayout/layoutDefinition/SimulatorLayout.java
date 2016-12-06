/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joalgoca.validatorLayout.layoutDefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jgonzalezc
 */
public class SimulatorLayout {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String path="C://Users//jgonzalezc//Desktop//ValidadorLayout//";
        String fileLayout="plantillaConceptos.xlsx";
        String fileDocumentConfiguration="DocumentoValidatorXLSX.xml";
        DocumentLayoutAbstract documentLayout;
        long inicio = System.currentTimeMillis();
        try {
            if(fileLayout.contains(".txt")){
                documentLayout=new FlatFixedDocumentLayout(fileLayout);
                documentLayout.loadDocumentValidator(path+fileDocumentConfiguration);
                System.out.println(documentLayout.validateDocument(new FileInputStream(new File(path+fileLayout))));
            }else if(fileLayout.contains(".xlsx")){
                documentLayout=new XLSXDocumentLayout(fileLayout);
                documentLayout.loadDocumentValidator(path+fileDocumentConfiguration);
                System.out.println(documentLayout.validateDocument(new FileInputStream(new File(path+fileLayout))));
            }
            long fin = System.currentTimeMillis() - inicio;
            DecimalFormat decimalFormat=new DecimalFormat("0.00");
            System.out.println("Tiempo de procesamiento: "+decimalFormat.format(fin/1000)+" segundos");

        } catch (IOException e) {
            Logger.getLogger(SimulatorLayout.class.getName()).log(Level.SEVERE, null, e);
        } catch (Exception ex) {
            Logger.getLogger(SimulatorLayout.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
}
