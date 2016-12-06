/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joalgoca.validatorLayout.validatorDefinition;

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
public class ObjectDateValidatorTest {
    
    public ObjectDateValidatorTest() {
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
     * Test of getTypeOperationDate method, of class ObjectDateValidator.
     */
    @Test
    public void testGetTypeOperationDate() {
        System.out.println("getTypeOperationDate");
        ObjectDateValidator instance = new ObjectDateValidator();
        TypeOperationDateEnum expResult = null;
        TypeOperationDateEnum result = instance.getTypeOperationDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTypeOperationDate method, of class ObjectDateValidator.
     */
    @Test
    public void testSetTypeOperationDate() {
        System.out.println("setTypeOperationDate");
        TypeOperationDateEnum typeOperationDate = null;
        ObjectDateValidator instance = new ObjectDateValidator();
        instance.setTypeOperationDate(typeOperationDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFormat method, of class ObjectDateValidator.
     */
    @Test
    public void testGetFormat() {
        System.out.println("getFormat");
        ObjectDateValidator instance = new ObjectDateValidator();
        String expResult = "";
        String result = instance.getFormat();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFormat method, of class ObjectDateValidator.
     */
    @Test
    public void testSetFormat() {
        System.out.println("setFormat");
        String format = "";
        ObjectDateValidator instance = new ObjectDateValidator();
        instance.setFormat(format);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAddless method, of class ObjectDateValidator.
     */
    @Test
    public void testGetAddless() {
        System.out.println("getAddless");
        ObjectDateValidator instance = new ObjectDateValidator();
        Integer expResult = null;
        Integer result = instance.getAddless();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAddless method, of class ObjectDateValidator.
     */
    @Test
    public void testSetAddless() {
        System.out.println("setAddless");
        Integer addless = null;
        ObjectDateValidator instance = new ObjectDateValidator();
        instance.setAddless(addless);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validate method, of class ObjectDateValidator.
     */
    @Test
    public void testValidate() {
        System.out.println("validate");
        String value = "01122016";
        ObjectDateValidator instance = new ObjectDateValidator(TypeOperationDateEnum.ADDDAYS,"ddMMyyyy",1);
        ResponseValidator expResult = new ResponseValidator(true, "\"ObjectDateValidator: Success adddays 1 validation.\"");
        ResponseValidator result = instance.validate(value);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class ObjectDateValidator.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ObjectDateValidator instance = new ObjectDateValidator();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
