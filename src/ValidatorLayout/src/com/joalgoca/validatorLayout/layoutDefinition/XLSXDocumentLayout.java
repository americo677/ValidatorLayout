/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joalgoca.validatorLayout.layoutDefinition;

import com.joalgoca.validatorLayout.validatorDefinition.ResponseValidator;
import com.joalgoca.validatorLayout.validatorDefinition.RowValidator;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author jgonzalezc
 */
public class XLSXDocumentLayout extends DocumentLayoutAbstract{

    
    public XLSXDocumentLayout(String fileName){
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
                int rownum=0;
                int wrong=0;
                int right=0;
                int skip=0;
                OPCPackage pkg = OPCPackage.open(inputStream);
                XSSFWorkbook workBook = new XSSFWorkbook(pkg);
                FormulaEvaluator evaluator=workBook.getCreationHelper().createFormulaEvaluator();
                XSSFSheet xssfSheet = workBook.getSheetAt(0);  
                for (Row row : xssfSheet){
                    String rowType=row.getCell(0).getStringCellValue();
                    if(rowsType.containsKey(rowType)){
                        RowValidator rowValidator=documentValidator.getListRowValidator().get((int)rowsType.get(rowType));
                        int columnNum=rowValidator.getListItemValidator().size();                        
                        if(row.getLastCellNum()==columnNum)
                        {
                            String[] values=new String[columnNum];
                            int i=0;
                            for (Cell cell:row) {   
                                switch (evaluator.evaluateInCell(cell).getCellType()){
                                    case Cell.CELL_TYPE_NUMERIC:
                                        values[i]=cell.getNumericCellValue() + "";
                                        break;
                                    case Cell.CELL_TYPE_STRING:
                                        values[i]=cell.getStringCellValue();
                                        break;
                                    case Cell.CELL_TYPE_FORMULA:
                                        values[i]="";
                                        break;
                                    case Cell.CELL_TYPE_BLANK:
                                        values[i]="";
                                        break;
                                }
                                i++;
                            }
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
                        skip++;
                        stringBuilder.append("{\"row\":").append(rownum).append(",\"success\":false,\"message\":\"Unknow row type\"},").toString();
                    }
                    rownum++;
                    
                }
                
                response=new ResponseValidator(wrong==0, "{\"skip\":"+skip+",\"wrong\":"+wrong+",\"right\":"+right+",\"count\":"+rownum+",\"errorMessages\":["+(stringBuilder.toString().length()>0?stringBuilder.substring(0,stringBuilder.toString().length()-1):"")+"]}");
            } catch (Exception ex) {
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
