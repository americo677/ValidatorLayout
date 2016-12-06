/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joalgoca.validatorLayout.validatorDefinition;

import javax.xml.bind.annotation.XmlEnum;

/**
 *
 * @author jgonzalezc
 */
@XmlEnum 
public enum TypeOperationDateEnum {
     TODAY,
     ADDDAYS , 
     LESSDAYS ,
     BETWEENMOREDAYS ,
     BETWEENLESSDAYS ;
     
}
