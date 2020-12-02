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
import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author javie
 */
public class ValidarCadenasTest {
    
    public ValidarCadenasTest() {
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
     * Test of opcionesMenu method, of class ValidarCadenas.
     */
    @Test
    public void testOpcionesMenu() {
        System.out.println("opcionesMenu");
        ValidarCadenas instance = new ValidarCadenas();
        instance.opcionesMenu();
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of comprobarMatriculaAutomovil method, of class ValidarCadenas.
     */
    @Test
    public void testComprobarMatriculaAutomovil() {
        System.out.println("comprobarMatriculaAutomovil");
        String str = "";
        boolean expResult = false;
        boolean result = ValidarCadenas.comprobarMatriculaAutomovil(str);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of comprobarMatriculaCiclomotor method, of class ValidarCadenas.
     */
    @Test
    public void testComprobarMatriculaCiclomotor() {
        System.out.println("comprobarMatriculaCiclomotor");
        String str = "";
        boolean expResult = false;
        boolean result = ValidarCadenas.comprobarMatriculaCiclomotor(str);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}
