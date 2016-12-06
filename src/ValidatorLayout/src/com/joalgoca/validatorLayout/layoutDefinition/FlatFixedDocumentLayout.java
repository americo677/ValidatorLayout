/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joalgoca.validatorLayout.layoutDefinition;

import com.joalgoca.validatorLayout.validatorDefinition.ResponseValidator;
import com.joalgoca.validatorLayout.validatorDefinition.RowValidator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jgonzalezc
 */
public class FlatFixedDocumentLayout extends DocumentLayoutAbstract{    

    public FlatFixedDocumentLayout(String fileName){
        super.setFileName(fileName);
    }
    
    @Override
    public ResponseValidator validateDocument(InputStream inputStream) {
        ResponseValidator response;
        StringBuilder stringBuilder=new StringBuilder();
        if(isReadyToValidate() && inputStream!=null){
            HashMap rowsType=new HashMap();
            for(int i=0;i<documentValidator.getListRowValidator().size();i++){
                rowsType.put(documentValidator.getListRowValidator().get(i).getName(), i);
            }
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String line=""; 
                int rownum=0;
                int wrong=0;
                int right=0;
                while ((line = reader.readLine()) != null) {  
                    String rowType=line.substring(documentValidator.getFlatFixedRowValue().getPositionBegin(),documentValidator.getFlatFixedRowValue().getPositionEnd());
                    if(rowsType.containsKey(rowType)){
                        RowValidator rowValidator=documentValidator.getListRowValidator().get((int)rowsType.get(rowType));
                        int columnNum=rowValidator.getListItemValidator().size();
                        if(line.length()==rowValidator.getFlatFixedTypeRow().getSize())
                        {
                            String[] values=new String[columnNum];
                            for(int i=0;i<columnNum;i++)
                                values[i]=line.substring(rowValidator.getListItemValidator().get(i).getFlatFixedItemValue().getPositionBegin(),rowValidator.getListItemValidator().get(i).getFlatFixedItemValue().getPositionEnd());
                            ResponseValidator responseValidator=rowValidator.validate(values);
                            if(!responseValidator.isSuccess()){
                                wrong++;
                                stringBuilder.append("{\"row\":").append(rownum).append(",\"message\":").append(responseValidator.getMessage()).append(",");
                            }else
                                right++;
                        }else{
                            wrong++;
                            stringBuilder.append("{\"row\":").append(rownum).append(",\"success\":false,\"message\":\"Line wrong size\"},").toString();
                        }
                    }else{
                        wrong++;
                        stringBuilder.append("{\"row\":").append(rownum).append(",\"success\":false,\"message\":\"Unknow row type\"},").toString();
                    }
                    rownum++;
                } 
                response=new ResponseValidator(right==rownum, "{\"wrong\":"+wrong+",\"right\":"+right+",\"count\":"+rownum+",\"errorMessages\":["+(stringBuilder.toString().length()>0?stringBuilder.substring(0,stringBuilder.toString().length()-1):"")+"]}");
            } catch (IOException ex) {
                Logger.getLogger(FlatFixedDocumentLayout.class.getName()).log(Level.SEVERE, null, ex);
                    response=new ResponseValidator(false, stringBuilder.append("\"success\":false,\"message\":\"").append(ex.getMessage()).append("\"}").toString());
            } finally {
                try {
                    inputStream.close();
                } catch (IOException ex) {
                    response=new ResponseValidator(false, stringBuilder.append("\"success\":false,\"message\":\"").append(ex.getMessage()).append("\"}").toString());
                } 
            }
        }else{
            response=new ResponseValidator(false, stringBuilder.append("\"success\":false,\"message\":\"No configuration loaded\"}").toString());
        }
        return response;
    }
    
}
