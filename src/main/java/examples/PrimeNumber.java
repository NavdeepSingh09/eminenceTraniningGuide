/**
 * @author: Navdeep
 * Date: 2023-10-19
 * Time: 9:03 p.m.
 */
package examples;

public class PrimeNumber {
    public static void main(String[] args) {

        System.out.println("Prime numbers from 1 to 10:");

        for (int i = 1; i <= 10; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    // Function to check if a number is prime
    static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
