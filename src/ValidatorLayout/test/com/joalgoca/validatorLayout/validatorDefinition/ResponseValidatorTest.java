/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joalgoca.validatorLayout.validatorDefinition;

import com.joalgoca.validatorLayout.validatorDefinition.ResponseValidator;
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
public class ResponseValidatorTest {
    
    public ResponseValidatorTest() {
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
     * Test of isSuccess method, of class ResponseValidator.
     */
    @Test
    public void testIsSuccess() {
        System.out.println("isSuccess");
        ResponseValidator instance = new ResponseValidator(true,null);
        boolean expResult = true;
        boolean result = instance.isSuccess();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setSuccess method, of class ResponseValidator.
     */
    @Test
    public void testSetSuccess() {
        System.out.println("setSuccess");
        boolean success = false;
        ResponseValidator instance = new ResponseValidator();
        instance.setSuccess(success);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getMessage method, of class ResponseValidator.
     */
    @Test
    public void testGetMessage() {
        System.out.println("getMessage");
        ResponseValidator instance = new ResponseValidator();
        String expResult = null;
        String result = instance.getMessage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setMessage method, of class ResponseValidator.
     */
    @Test
    public void testSetMessage() {
        System.out.println("setMessage");
        String message = "";
        ResponseValidator instance = new ResponseValidator();
        instance.setMessage(message);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
