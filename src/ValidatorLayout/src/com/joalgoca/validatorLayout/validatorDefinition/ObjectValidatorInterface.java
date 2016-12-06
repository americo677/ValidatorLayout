/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joalgoca.validatorLayout.validatorDefinition;

import com.sun.xml.internal.bind.AnyTypeAdapter;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author jgonzalezc
 */
@XmlRootElement
@XmlJavaTypeAdapter(AnyTypeAdapter.class)
public interface ObjectValidatorInterface {
    public ResponseValidator validate(String value);
}
