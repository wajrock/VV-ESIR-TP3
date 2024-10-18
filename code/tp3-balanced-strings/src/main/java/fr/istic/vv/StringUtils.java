package fr.istic.vv;

import java.util.Stack;

public class StringUtils {

    private StringUtils() {

    }

    //vérifier si une chaine est équilibrée
    public static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>(); // on stocke les caractères symboles ouvrants dans une pile.
        for (char ch : str.toCharArray()) { // on parcourt les caractères
            if (ch == '(' || ch == '{' || ch == '[') { 
                stack.push(ch);} // on rajoute dans la pile les caractères ouvrants
            else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()){
                    return (false);}

                char top = stack.pop();
                if (!isMatchingPair(top, ch)){
                    return(false);
                }
            }    
        }
        return stack.isEmpty();                
    

    }
    
    private static boolean isMatchingPair(char opening, char closing) {
        return (opening == '(' && closing == ')') || (opening == '[' && closing == ']') || (opening == '{' && closing == '}');

    }

}
