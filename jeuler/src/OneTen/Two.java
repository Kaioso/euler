/**
* Class Details: Even Fibonacci numbers
*
*
**/
package OneTen;

import Main.Solvable;

/**
 *
 * @author Rory "Howl" Howe
 */
public class Two implements Solvable {

    @Override
    public Object solve() {
        int LIMIT = 4000000;
        
        int sum = 0;
        int previousFib = 1;
        int currentFib = 1;
        while (currentFib <= LIMIT) {
            if (currentFib % 2 == 0) {
                sum += currentFib;
            }
            int transition = previousFib + currentFib;
            previousFib = currentFib;
            currentFib = transition;
        }
        Integer result = sum;
        return result;
    }
    
}
