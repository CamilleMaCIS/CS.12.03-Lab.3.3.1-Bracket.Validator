import java.util.Stack;

public class BracketValidator {

    // Method called checkValidParentheses that returns a boolean indicating whether a string of brackets is valid or not.
    public static boolean checkValidParentheses(String expression) {

        // Obtain an array of the brackets (each element is a single bracket).
        String[] brackets = new String[expression.length()];
        for (int i = 0; i < expression.length(); i++){
            brackets[i] = String.valueOf(expression.charAt(i));
        }

        // Create a stack.
        Stack<String> stack = new Stack<>();

        // Iterate over the array of brackets.
        for (String bracket : brackets){
            //if it is an open bracket (, [, or {

            // Check if the bracket is an opening bracket. If it is, push it onto the stack.
            if (isLeftBracket(bracket)){
                stack.push(bracket);
            }
            //otherwise it is a closed bracket ), ], }
            else{
                // If the stack is empty
                // then return false as this must mean that the expression is invalid.
                if (stack.empty()){
                    //e,g, ()), where there is an extra close bracket without an open bracket pair
                    return false;
                }

                // Or if the popped bracket is not equal to the reverse bracket of the current bracket,
                // then return false as this must mean that the expression is invalid.

                // Obtain the reversed version of bracket.
                String reversed = getReversedBracket(bracket);
                String popped = stack.pop();
                if (!reversed.equals(popped)){
                    //e.g. (){], where the pairs are not the same type of bracket
                    return false;
                }
            }

        }

        // If the stack is empty after we have finished iterating over the array of brackets,
        // then return true as this must mean that the expression is valid.
        // If the stack is not empty, this must mean that the expression is invalid.
        return stack.empty();
    }

    // Private helper method called isLeftBracket that returns a boolean value to indicate whether the bracket is a left (opening) bracket.
    private static boolean isLeftBracket(String bracket) {

        return (bracket.equals("(") || bracket.equals("[") || bracket.equals("{"));

    }

    // Private helper method called getReversedBracket that returns a String which is the reverse version of the bracket passed to the method.
    private static String getReversedBracket(String bracket) {
        // Remember, the only use of getReversedBracket are on line 38
        // The parameter bracket will always be passed as a right bracket (aka close brackets)
        // which means, DON'T NEED to check if bracket equals "(" or "[" or "{"
        if (bracket.equals(")")){
            return "(";
        }
        else if (bracket.equals("]")){
            return "[";
        }
        else{
            return "{";
        }
    }
}
