/**
 * @author: Navdeep
 * Date: 2023-06-01
 * Time: 11:22 p.m.
 */
package modifiers;

public class PublicExample1 {
    public static void main(String[] args) {
        // accessing the public class
        PublicExample publicExample = new PublicExample();

        // accessing the public variable
        publicExample.numberOfStudents = 4;
        // accessing the public method
        publicExample.display();
    }
}
