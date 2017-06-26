import java.util.Stack;
import java.util.EmptyStackException;

/** Class to check for balanced parentheses.
**/
public class ParenthesisChecker {

    // Constants
    /** Set of opening parenthesis characters. */
    private static final String OPEN = "([{";
    /** Set of closing parenthesis characters, matches OPEN. */
    private static final String CLOSE = ")]}";

    /**
     * Test the input string to see that it contains balanced
     * parentheses. This method tests an input string to see
     * that each type of parenthesis is balanced. '(' is matched
     * with ')', '[' is matched with ']', and
     * '{' is matched with '}'.
     * @param expression A String containing the expression to
     *        be examined
     * @return true if all the parentheses match
     */
    public static boolean isBalanced(String expression) {
        // Create an empty stack.
        Stack<Character> s = new Stack<Character>();
        boolean balanced = true;
        try {
            int index = 0;
            while (balanced && index < expression.length()) {
                char nextCh = expression.charAt(index);
                if (isOpen(nextCh)) {
                    s.push(nextCh);
                } else if (isClose(nextCh)) {
                    char topCh = s.pop();
                    balanced = OPEN.indexOf(topCh) == CLOSE.indexOf(nextCh);
                }
                index++;
            }
        } catch (EmptyStackException ex) {
            balanced = false;
        }
        return (balanced && s.empty());
    }

    /**
     * Method to determine whether a character is one of the
     * opening parentheses.
     * @param ch Character to be tested
     * @return true if ch is one of the opening parentheses
     */
    private static boolean isOpen(char ch) {
        return OPEN.indexOf(ch) > -1;
    }

    /**
     * Method to determine whether a character is one of the
     * closing parentheses.
     * @param ch Character to be tested
     * @return true if ch is one of the closing parentheses
     */
    private static boolean isClose(char ch) {
        return CLOSE.indexOf(ch) > -1;
    }


    public static void main(String args[]) {
        String expression =                     "[{(((1+2))*4) ]} ";
        
        
        if (ParenthesisChecker.isBalanced(expression)) {
            System.out.println(expression + " is balanced");
        } else {
            System.out.println(expression + " is not balanced");
        }
    }
}