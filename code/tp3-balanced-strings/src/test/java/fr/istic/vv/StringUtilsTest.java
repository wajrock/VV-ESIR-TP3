package fr.istic.vv;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import static fr.istic.vv.StringUtils.isBalanced;

class StringUtilsTest {

    @Test
    void testEmptyString() {
        assertTrue(isBalanced(""), " The empty string is balanced.");
    
    
    }

    @Test
    void testSingleOpeningWithoutClosing() {
        assertFalse(isBalanced("["), "Opening square without a closing square.");
        assertFalse(isBalanced("("), "Opening parenthesis without a closing parenthesis.");
        assertFalse(isBalanced("{"), "Opening brace without a closing brace .");

    }

    @Test
    void testSingleClosingWithoutOpening() {
        assertFalse(isBalanced("}"), "Closing brace without an opening brace.");
        assertFalse(isBalanced(")"), "Closing parenthesis without an opening parenthesis.");
        assertFalse(isBalanced("]"), "Closing square bracket without an opening square bracket.");
    }



    @Test
    void testSingleBalancedPairs() {
        assertTrue(isBalanced("()"), "balanced pair.");
        assertTrue(isBalanced("[]"), "balanced pair.");
        assertTrue(isBalanced("{}"), "balanced pair.");}

    @Test 
    void testSingleUnbalancedPairs(){
        assertFalse(isBalanced(")("),"unbalanced pair.");
        assertFalse(isBalanced("}{"),"unbalanced pair.");
        assertFalse(isBalanced("]["),"unbalanced pair.");

        
    }
    @Test 
    void testmultipleBalancedPairs(){
        assertTrue(isBalanced("(){}[]"), "balanced pairs.");
        assertTrue(isBalanced("{[()]}"), "balanced pairs.");
        assertTrue(isBalanced("{([])}"), "balanced pairs.");
        assertTrue(isBalanced("({[]})"), "balanced pairs.");
        assertTrue(isBalanced("([{}])"), "balanced pairs.");
        assertTrue(isBalanced("[({})]"), "balanced pairs.");
        assertTrue(isBalanced("[{()}]"), "balanced pairs.");



    }

    @Test 
    void testmultipleUnBalancedPairs(){
        assertFalse(isBalanced("{[()]}}"), "Unbalanced pairs.");
        assertFalse(isBalanced("{[(])}"), "Unbalanced pairs.");
        assertFalse(isBalanced("[({)]}"), "Unbalanced pairs.");
        assertFalse(isBalanced("}{"), "Unbalanced pairs.");
        assertFalse(isBalanced("()()}"), "Unbalanced pairs.");
        assertFalse(isBalanced("((((("), "Unbalanced pairs.");
        assertFalse(isBalanced("))))"), "Unbalanced pairs.");
        assertFalse(isBalanced("([)]"), "Unbalanced pairs.");
        assertFalse(isBalanced("{[}"), "Unbalanced pairs.");

        //other tests

        assertFalse(isBalanced("[(])"), "unbalanced pairs.");
        assertFalse(isBalanced("((())"), "Unbalanced due to unmatched opening.");
        assertFalse(isBalanced("())("), "Unbalanced due to unmatched closing.");

    }


    @Test
    void testBalancedNestedBrackets() {
        
        assertTrue(isBalanced("((((()))))"), "balanced pairs.");
        assertTrue(isBalanced("{[({[()]})]}"), "balanced pairs .");
    }
}


    
    


