import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class Convert {

    private static List<String> parse(char[] input) {  
        List<String> parsed = new ArrayList<String>();
        for (int i = 0; i < input.length; ++i) {
            char c = input[i];
            if (Character.isDigit(c)) {
                String number = input[i] + "";
                for (int j = i + 1; j < input.length; ++j) {
                    if (Character.isDigit(input[j])) {
                        number += input[j];
                        i = j;
                    } else {
                        break;
                    }
                }
                parsed.add(number);
            } else if (c == '*' || c == '/' || 
                    c == '+' || c == '^' || 
                    c == '-' || c == '(' || c == ')') {
                parsed.add(c + "");
            }
        }
        return parsed;
    }

    public static boolean isOperator( String s ) {
        return s.equals( "+" ) || s.equals( "-" )  || s.equals( "/" ) || s.equals( "*" );
    } 

    public static boolean isOperator( char s ) {
        return s == '+' || s == '-' || s == '*' || s == '/';
    } 

    public static String toPostFix( String x ) {
        char[ ] test = x.toCharArray( );
        List< String > fix = parse( test );
        String ret = "";
        Stack<String> holder = new Stack<String>( );
        // System.out.print( fix.length( ) );
        for ( int i = 0; i < fix.size( ); i++ ) {
            String c = fix.get( i );
            // System.out.println( i + " " + c );
            // System.out.println( "stack: " + holder );
            // System.out.println( "return: " + ret );
            if ( holder.size( ) == 1 && isOperator( holder.peek( ) ) && 
            isOperator( c )  ) {  // if there's an operator and no parenthesis
                // System.out.println( true );
                ret += holder.pop( ) + " "; 
            }
            if ( isOperator( c ) || c.equals( "(" ) ) 
                holder.push( c );
            else if ( c.equals( ")" ) ) {
                while ( !( holder.peek( ).equals( "(" ) ) ) 
                    ret += holder.pop( ) + " ";  
                holder.pop( );
            }
            else {
                ret += c + " ";
            }    
            // System.out.println( "stack: " + holder );
            // System.out.println( "return: " + ret );
            // System.out.println( "----------" );
    }
    if ( holder.size( ) > 0 ) { //extra operator left over
        ret += holder.pop( );
    }
    System.out.println( "postfix = "  + ret );
    return ret;
}


    // public static String 
    
    public static void main( String [] args ) {
        // String x = "(4+8)*(6-5)/((3-2)*(2+2))";
        // String x = "3+4*5/6";
        String x = "(300+23)*(43-21)/(84+7)";
        String ret = toPostFix( x );
        System.out.println( ret );
        
    }


}