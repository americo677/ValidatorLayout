/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joalgoca.validatorLayout.validatorDefinition;

import com.joalgoca.validatorLayout.validatorDefinition.ObjectTypeValidator;
import com.joalgoca.validatorLayout.validatorDefinition.ResponseValidator;
import static com.joalgoca.validatorLayout.validatorDefinition.TypeObjectEnum.*;
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
public class TypeObjectValidatorTest {
    
    public TypeObjectValidatorTest() {
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
     * Test of validate method, of class ObjectTypeValidator.
     */
    @Test
    public void testValidate() {
        System.out.println("validate");
        String value = "2015.0";
        ObjectTypeValidator instance = new ObjectTypeValidator(DOUBLE,null);
        ResponseValidator expResult = new ResponseValidator(true, "Success validation");
        ResponseValidator result = instance.validate(value);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
