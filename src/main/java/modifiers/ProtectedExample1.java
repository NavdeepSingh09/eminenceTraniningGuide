/**
 * @author: Navdeep
 * Date: 2023-06-01
 * Time: 11:18 p.m.
 */
package modifiers;

public class ProtectedExample1 extends ProtectedExample{
    public static void main(String[] args) {
        // create an object of ProtectedExample class
        ProtectedExample  protectedExample = new ProtectedExample();
        // access protected method
        protectedExample.display();
    }
}
