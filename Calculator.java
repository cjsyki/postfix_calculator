import java.util.Stack;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {

    public static int calculate( String postfix ) {
        String[ ] array = postfix.split( " " );
        Stack< Integer > ans = new Stack< Integer >( );
        for ( int i = 0; i < array.length; i++ ) {
            String pos = array[ i ];
            if ( pos.equals( "+" ) ) {
                int b = ans.pop( );
                int a = ans.pop( );
                int r = a + b;
                ans.push( r );
            }
            else if ( pos.equals( "-" ) ) {
                int b = ans.pop( );
                int a = ans.pop( );
                int r = a - b;
                ans.push( r );
            }
            else if ( pos.equals( "*" ) ) {
                int b = ans.pop( );
                int a = ans.pop( );
                int r = a * b;
                ans.push( r );
            }
            else if ( pos.equals( "/" ) ) {
                int b = ans.pop( );
                int a = ans.pop( );
                int r = a / b;
                ans.push( r );
            }
            else
                ans.push( Integer.parseInt( pos ) ); //WILL ALWAYS WORK SINCE POS CANNOT BE AN OPERATOR
        }
        return ans.pop( );
    }



    public static void main ( String [] args ) {
        Convert conv = new Convert( );
        // conv.main( String [] args );
        // String x = "(4+8)*(6-5)/((3-2)*(2+2))";
        // String x = "3+4*5/6";
        // String x = "(300+23)*(43-21)/(84+7)";
        System.out.println( "type your infix expression w parentheses" );
        Scanner in = new Scanner( System.in );
        String expression = in.nextLine( );
        in.close( );
        String ret = conv.toPostFix( expression );
        int ans = calculate( ret );
        System.out.println( "Answer = " + ans );
    }


}