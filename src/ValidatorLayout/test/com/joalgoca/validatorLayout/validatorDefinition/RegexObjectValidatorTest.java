/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joalgoca.validatorLayout.validatorDefinition;

import com.joalgoca.validatorLayout.validatorDefinition.ResponseValidator;
import com.joalgoca.validatorLayout.validatorDefinition.ObjectRegexValidator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jgonzalezc
 */
public class RegexObjectValidatorTest {
    
    public RegexObjectValidatorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of validate method, of class ObjectRegexValidator.
     */
    @Test
    public void testValidate() {
        System.out.println("validate");
        String value = null;
        ObjectRegexValidator instance = new ObjectRegexValidator("^([A-Z,Ñ,&]{3,4}([0-9]{2})(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])[A-Z|\\d]{3})$");
        ResponseValidator expResult = new ResponseValidator(false,"RegexObjectValidator: Success validation");
        ResponseValidator result = instance.validate(value);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getRegularExpresion method, of class ObjectRegexValidator.
     */
    @Test
    public void testGetRegularExpresion() {
        System.out.println("getRegularExpresion");
        ObjectRegexValidator instance =  new ObjectRegexValidator("[1-9]{0,5}");
        String expResult = "[1-9]{0,5}";
        String result = instance.getRegularExpresion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setRegularExpresion method, of class ObjectRegexValidator.
     */
    @Test
    public void testSetRegularExpresion() {
        System.out.println("setRegularExpresion");
        String regularExpresion = "[1-9]{0,5}";
        ObjectRegexValidator instance = new ObjectRegexValidator("[1-9]{0,5}");
        instance.setRegularExpresion(regularExpresion);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
