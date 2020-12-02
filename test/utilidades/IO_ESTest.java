/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 *
 * @author javie
 */
public class IO_ESTest {
    
    public IO_ESTest() {
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
     * Test of leerInteger method, of class IO_ES.
     */
    @Test
    public void testLeerInteger_3args() {
        System.out.println("leerInteger");
        String msj = "";
        int min = 0;
        int max = 0;
        int expResult = 0;
        int result = IO_ES.leerInteger(msj, min, max);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of leerInteger method, of class IO_ES.
     */
    @Test
    public void testLeerInteger_String_int() {
        System.out.println("leerInteger");
        String msj = "";
        int min = 0;
        int expResult = 0;
        int result = IO_ES.leerInteger(msj, min);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of leerReal method, of class IO_ES.
     */
    @Test
    public void testLeerReal() {
        System.out.println("leerReal");
        float expResult = 0.0F;
        float result = IO_ES.leerReal();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of leerIntegerLargo method, of class IO_ES.
     */
    @Test
    public void testLeerIntegerLargo() {
        System.out.println("leerIntegerLargo");
        long expResult = 0L;
        long result = IO_ES.leerIntegerLargo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of leerRealLargo method, of class IO_ES.
     */
    @Test
    public void testLeerRealLargo() {
        System.out.println("leerRealLargo");
        double expResult = 0.0;
        double result = IO_ES.leerRealLargo();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of escribir method, of class IO_ES.
     */
    @Test
    public void testEscribir() {
        System.out.println("escribir");
        String cadena = "";
        IO_ES.escribir(cadena);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of escribirLn method, of class IO_ES.
     */
    @Test
    public void testEscribirLn() {
        System.out.println("escribirLn");
        String cadena = "";
        IO_ES.escribirLn(cadena);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of leerMatricula method, of class IO_ES.
     */
    @Test
    public void testLeerMatricula() {
        System.out.println("leerMatricula");
        String expResult = "";
        String result = IO_ES.leerMatricula();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validarCoordenadas method, of class IO_ES.
     */
    @Test
    public void testValidarCoordenadas() {
        System.out.println("validarCoordenadas");
        String expResult = "";
        String result = IO_ES.validarCoordenadas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
