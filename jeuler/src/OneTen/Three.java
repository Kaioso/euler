/**
* Class Details: Largest prime factor
*
*
**/
package OneTen;

import Main.Solvable;

/**
 *
 * @author Rory "Howl" Howe
 */
public class Three implements Solvable {

    @Override
    public Object solve() {
        long magic = 600851475143l;
        long maxdiv = (long)Math.sqrt(magic);
        
        Long result = 1l;
        for (long i = maxdiv; i > 1; i--) {
            if (magic % i == 0) {
                if (isPrime(i)) {
                    result = i;
                    break;
                }
            }
        }
        return result;
    }
    
    private boolean isPrime(long num) {
        boolean result = true;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                result = false;
                break;
            }
        }
        
        return result;
    }
    
}
