package ba.unsa.etf.rpr;
import java.util.Stack;
import java.util.ArrayList;

import static java.lang.Double.*;

public class ExpressionEvaluator {

    private static Stack<String> operators=new Stack<>();
    private static Stack<Double> numbers=new Stack<>();

    public ExpressionEvaluator() {
    }


    /**
     * This method is the main body of the Dijkstr  algorithm.
     * Using a foreach loop which navigates through our expression.
     * If our string value is ")" it means we are at the end of one subexpression,
     * and we can calculate its value.
     * I'm using switch case as a substitute for an if statement. After calculating its value, we pop the value
     * of the numbers and our operators from our stacks.
     * We continue the process until our string value is "(" which indicates a start of a new subexpression.
     * If our string is not ")", then we should check if the value of our string is an arithmetic operation(+,-,*,/).
     * If so, we add it to out operator Stack, if not we add it to our number Stack.
     * @param expression this is our expression that we are supposed to calculate.
     * @return it returns the value of the expression sent as a parameter.
     */

     public static Double evaluate(String expression){
         Ex(expression);

    String[] parsedString= expression.split(" ");
        for (String s : parsedString) {

            if (s.equals(")") && !operators.isEmpty()) {
                while (!(operators.peek().equals("(") )) {
                    String op = operators.pop();

                    double b=numbers.pop();
                    double tempvalues=0;
                    switch (op) {
                        case "+":
                            tempvalues = numbers.pop() +b;
                            break;
                        case "-":
                            tempvalues = numbers.pop() - b;
                            break;
                        case "*":
                            tempvalues = numbers.pop() * b;
                            break;
                        case "/":
                            if(b == 0)
                                throw new RuntimeException("You cannot divide with 0, as it is infinity.");
                            tempvalues = numbers.pop() / b;
                            break;
                        case "sqrt" :
                            tempvalues=Math.sqrt(b);
                            break;
                        case ")":
                            break;
                        default :throw new RuntimeException("The expression you have entered has illegal parameters");
                    }
                    numbers.push(tempvalues);
                    if(operators.isEmpty())
                        break;
                }
                if(!operators.isEmpty())
                operators.pop();
            }
            else if(s.equals("-") || s.equals("+") || s.equals("/") || s.equals("*")  || s.equals("sqrt") ){
                operators.push(s);
            }
            else {

                if(!(s.equals("(") || s.equals(")")))
                numbers.push(Double.parseDouble(s));
            }
        }

    return numbers.pop();
}

    /**
     * This public method Ex checks if the sent string is arithmetically correct. It uses the method toCharArray() that
     * will seperate the string into an Array of chars, allowing us to use the Character.isDigit(char) method. If the sent
     * string has a sign that is not allowed(signs that are allowed are the ones in the if statement), it throws a RuntimeException.
     * Otherwise, the method always returns true(the RuntimeException not being thrown indicates that the string sent is
     * arithmetically correct since it has gone through the entire foreach loop without throwing and Exception)
     * @param s string needing to be checked
     * @return true if sent string is arithmetically correct
     * @throws RuntimeException if forbidden characters are used
     */
    public static boolean Ex(String s) throws RuntimeException{
int numofrbrackets=0,numoflbrackets=0,op=0,num=0,sq=0;
    String[] x=(s.split(" "));
    for(String y:x){
        if(y.equals(")"))
            numofrbrackets++;
        else if(y.equals("("))
            numoflbrackets++;
        if(!(y.equals("-") || y.equals("+")|| y.equals("/") || y.equals("*") || y.equals("sqrt") ||y.equals(")")||y.equals("(") ))
        {
            char[] p=y.toCharArray();
            for(char r:p)
            {
                if(!(Character.isDigit(r) || r=='.') )
                    throw new RuntimeException("The expression you have entered has illegal parameters");

            }
            num++;
        }
        else if(y.equals("-") || y.equals("+")|| y.equals("/") || y.equals("*") || y.equals("sqrt") )
        op++;
        if(y.equals("sqrt"))
            sq++;

    }
        if(numoflbrackets!=numofrbrackets)
            throw new RuntimeException("The expression you have entered has illegal parameters");
   if( num-1+sq!=op)
       throw new RuntimeException("The expression you have entered has illegal parameters");

       if(numoflbrackets!=op)
           throw new RuntimeException("The expression you have entered has illegal parameters");
        if(s.contains("sqrt")){
            for(int i=0;i<x.length-1;i++){
if(x[i].equals("(")){
    if(x[i+1].equals("sqrt") && ( (i>2 && x[i-2].equals(")")) && !x[i+2].equals("(" )))
        throw new RuntimeException("The expression you have entered has illegal parameters");
}
            }
        }

        return true;

}

}
