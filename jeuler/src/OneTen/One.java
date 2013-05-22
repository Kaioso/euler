/**
* Class Details: Multiples of 3 and 5
*
*
**/
package OneTen;

import Main.Solvable;

/**
 *
 * @author Rory "Howl" Howe
 */
public class One implements Solvable {

    @Override
    public Object solve() {
        int LIMIT = 1000;
        
        int sum = 0;
        for (int i = 1; i < LIMIT; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        Integer total = sum;
        return total;
    }
    
}
