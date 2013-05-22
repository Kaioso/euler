/**
* Class Details: Largest palindrome from the product of three digit numbers
*
*
**/
package OneTen;

import Main.Solvable;
import java.util.*;

/**
 *
 * @author Rory "Howl" Howe
 */
public class Four implements Solvable {
    // Range is 100-999
    // Answers ranging from 10,000 to 998,001

    // I could attempt every single product until I reach a palindrome.
    // This would be slow

    // I can find the first palindrome within the range of possible products
    // and then make sure the factors are within range

    // So find the first palindrome
    int DIGITS = 3;
    
    long topLevel = (long)Math.pow(10, DIGITS) - 1;
    long bottomLevel = (long)Math.pow(10, DIGITS - 1);

    long top = (long)Math.pow(topLevel, 2);
    long bot = (long)Math.pow(bottomLevel, 2);

    @Override
    public Object solve() {
        
        for (long i = top; i >= bot; i--) {
            if (isPalindrome(i)) {
                List<Long> factors = getFactors(i);
                if (checkRangeOfFactors(factors, i)) {
                    return (Long)i;
                }
            }
        }
        return (Long)0L;
    }
    
    private boolean isPalindrome(final long num) {
        return reverse(num) == num;
    }
    
    private List<Long> getFactors(final long num) {
        List<Long> factors = new ArrayList<Long>();
        for (long i = bottomLevel; i <= topLevel; i++) {
            if (num % i == 0) {
                factors.add(i);
            }
        }
        return factors;
    }
    
    private boolean checkRangeOfFactors(final List<Long> factors, long palindrome) {
        for (Long numerator : factors) {
            for (Long denominator : factors) {
                if (numerator * denominator == palindrome) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private long reverse(long num) {
        long reversed = 0;
        while (num > 0) {
            reversed = 10 * reversed + num % 10;
            num = num / 10;
        }
        return reversed;
    }
    
}
