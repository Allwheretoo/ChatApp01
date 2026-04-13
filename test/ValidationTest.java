/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidationTest {
    ChatApp01 chatapp01 = new ChatApp01();
    
    
    //Test Username
    @Test
    public void testUsernameCorrect() {
        assertTrue(chatapp01.checkUsername("abcd_"));
    }
    
    @Test
    public void testUsernameIncorrect() {
        assertFalse(chatapp01.checkUsername("abcdef")); // no underscore and it is too long
    }
    
    //Test Password
    @Test
    public void testPasswordCoreccet() {
        assertTrue(chatapp01.checkPasswordComplexity("Pass@123"));
    }
    
    @Test
    public void testPasswordIncorrect() {
        assertFalse(chatapp01.checkPasswordComplexity("password")); //No number or any special character
    }
    
    //Test cellphone number
    @Test
    public void testCellphoneNumberCorrect() {
        assertTrue(chatapp01.checkCellphoneNumber("+27629824217"));
    }
    
    @Test
    public void testCellphoneNumberIncorrect() {
        assertFalse(chatapp01.checkCellphoneNumber("0629824217")); // No international code(+27)
    }
    }
    
