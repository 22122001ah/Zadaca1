package ba.unsa.etf.rpr;

import java.io.InputStreamReader;
import java.util.Scanner;
/**
 * Main class
 * An expression is entered from console and we check if it is
 * correct(no illegal parameters) and calculate the result if the expression
 * is correct
 * @author Adna Herak
 */
public class App 
{
    private static String[] args;

    public static void main(String[] args )
    {
        try {
            ExpressionEvaluator.Ex(args[0]);
            System.out.println(ExpressionEvaluator.evaluate(args[0]));
        } catch (RuntimeException e){
            System.out.println(e);
        }


    }
}
