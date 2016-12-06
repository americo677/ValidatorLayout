/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joalgoca.validatorLayout.validatorDefinition;

import com.joalgoca.validatorLayout.validatorDefinition.ItemValidator;
import com.joalgoca.validatorLayout.validatorDefinition.ResponseValidator;
import com.joalgoca.validatorLayout.validatorDefinition.ObjectValidatorInterface;
import java.util.List;
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
public class ItemValidatorTest {
    
    public ItemValidatorTest() {
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
     * Test of getListObjectValidatorInterface method, of class ItemValidator.
     */
    @Test
    public void testGetListObjectValidatorInterface() {
        System.out.println("getListObjectValidatorInterface");
        ItemValidator instance = null;
        List<ObjectValidatorInterface> expResult = null;
        List<ObjectValidatorInterface> result = instance.getListObjectValidatorInterface();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListObjectValidatorInterface method, of class ItemValidator.
     */
    @Test
    public void testSetListObjectValidatorInterface() {
        System.out.println("setListObjectValidatorInterface");
        List<ObjectValidatorInterface> listObjectValidatorInterface = null;
        ItemValidator instance = null;
        instance.setListObjectValidatorInterface(listObjectValidatorInterface);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addObjectValidatorInterface method, of class ItemValidator.
     */
    @Test
    public void testAddObjectValidatorInterface() {
        System.out.println("addObjectValidatorInterface");
        ObjectValidatorInterface objectValidatorInterface = null;
        ItemValidator instance = null;
        instance.addObjectValidatorInterface(objectValidatorInterface);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validate method, of class ItemValidator.
     */
    @Test
    public void testValidate() {
        System.out.println("validate");
        String value = "";
        ItemValidator instance = null;
        ResponseValidator expResult = null;
        ResponseValidator result = instance.validate(value);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
