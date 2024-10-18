package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static fr.istic.vv.StringUtils.isBalanced;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @Test
    void testEmptyString() {
        assertTrue(isBalanced(""), " The empty string is balanced.");
    }

    @Test
    void testSingleBalancedPairs() {
        assertTrue(isBalanced("()"), "balanced pair .");
        assertTrue(isBalanced("[]"), "balanced pair.");
        assertTrue(isBalanced("{}"), "balanced pair.");}

    @Test 
    void testSingleUnbalancedPairs(){
        assertFalse(isBalanced(")("),"unbalanced pair");
        assertFalse(isBalanced("}{"),"unbalanced pair");
        assertFalse(isBalanced("]["),"unbalanced pair");
    }
    @Test 
    void testmultipleBalancedPairs(){
        assertTrue(isBalanced("(){}[]"), " balanced.");
        assertTrue(isBalanced("{[()]}"), " balanced.");
        assertTrue(isBalanced("{([])}"), "balanced.");
        assertTrue(isBalanced("({[]})"), "balanced.");
        assertTrue(isBalanced("([{}])"), "balanced.");
        assertTrue(isBalanced("[({})]"), "balanced.");
        assertTrue(isBalanced("[{()}]"), "balanced.");

    }
    




}