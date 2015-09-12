/**
 * *****************************************************
 * Program Number: A1_<problem 1 (ranging from 1 to 2) >
 * Purpose/Description: <Provide a sublinear time complexity to obtain the nth
 * fib term, I used matrix multiplication>
 * Author: <Alberto Camacho>
 * Due date: <09/10/15>
 * Certification: I hereby certify that this work is my own and none of it is
 * the work of any other person.
 * < Alberto Jesus Camacho >
******************************************************
 */
package fibonacci;

import java.math.BigInteger;
import java.util.Scanner;

public class Fibonacci {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // Fibonacci at the first power
        BigInteger[] matrix = {BigInteger.ONE, BigInteger.ONE, BigInteger.ONE, BigInteger.ZERO};
        // Fibonacci at the power of zero
        BigInteger[] product = {BigInteger.ONE, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ONE};

        // Temporary variables to carry out matrix multiplication, prevent corruption
        BigInteger a;
        BigInteger b;
        BigInteger c;
        BigInteger d;

        // Prompt user for n-th fibonacci term
        System.out.println("Enter the n-th fibbonaci term: ");
        int n = in.nextInt();

        // Input validation
        while (n < 0) {
            System.out.println("Please enter a positive number: ");
            n = in.nextInt();
        }

        // Repeated exponentiation used to multiply matrices
        while (n != 0) {
            // If we find an odd n value then multiply power matrix with the product matrix
            if (n % 2 != 0) {
                // Performing matrix multiplication
                a = product[0].multiply(matrix[0]).add(product[1].multiply(matrix[2]));
                b = product[0].multiply(matrix[1]).add(product[1].multiply(matrix[3]));
                c = product[2].multiply(matrix[0]).add(product[3].multiply(matrix[2]));
                d = product[2].multiply(matrix[1]).add(product[3].multiply(matrix[3]));

                product[0] = a;
                product[1] = b;
                product[2] = c;
                product[3] = d;
            }
            // Cutting problem size by 2, hence the running time is O(log(N))
            n /= 2;
            
            // Squaring the power matrix
            a = matrix[0].multiply(matrix[0]).add(matrix[1].multiply(matrix[2]));
            b = matrix[0].multiply(matrix[1]).add(matrix[1].multiply(matrix[3]));
            c = matrix[2].multiply(matrix[0]).add(matrix[3].multiply(matrix[2]));
            d = matrix[2].multiply(matrix[1]).add(matrix[3].multiply(matrix[3]));

            matrix[0] = a;
            matrix[1] = b;
            matrix[2] = c;
            matrix[3] = d;
        }
        // Output the n-th fibonacci term
        System.out.println(product[1]);

    }
}
