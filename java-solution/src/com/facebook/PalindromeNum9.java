package com.facebook;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/3/18
 * Talk is Cheap,Show me the Code.
 **/
public class PalindromeNum9 {
    /**
     * KEYPOINTS:
     * <p>
     * first,corner condition, negative nums return false;
     * not only one digit return false. we can know i%10 == 0 will return fasle too.
     * since 10,100,3000...ends with 0 will not palindrome because we do not have number begin by digit 0.
     * And:
     * first mind, change the int to string and use two pointer to do that. but it requires extra space.
     * Second mind, revert the number. but I may be out of range of MAX_VALUE;
     * Last mind, divide it into two half parts.
     * But how we know we reach the half?
     * e.g. 34543, we get the last by mod, to get 3, and left result 3454 and continue.
     * but before we handle the next digit. we can *10 of the new result.
     * e.g when handle the later 4,we *10 of the pre result 3. and we get 34.
     * when handle 5, we 34*10+5 = 345.and 354 > the lefr 34. we can say we reach the half part.
     * Since we divided the number by 10, and multiplied the reversed number by 10,
     * when the original number is less than the reversed number, it means we've processed half
     * of the number digits. 3421？
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY:
     * <p>
     * SPACE COMPLEXITY:
     * <p>
     **/
    public boolean palindrom(int i) {
        if (i < 0) {
            return false;
        }

        if (i < 10) {
            return true;
        }

        String s = String.valueOf(i);
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            ++start;
            ++end;
        }
        return true;
    }

    public boolean parlindromHalpPart(int i) {
        if (i < 0) {
            return false;
        }

        if (i < 10) {
            return true;
        }

        if( i % 10 == 0){ // number end with 0 will return false because no number begin with digit 0.
            return false;
        }

        int reverse = 0;
        while (i > reverse) {
            int tmp = reverse * 10 + i % 10;
            i = i / 10;
            if (tmp > i) {
                break;
            } else {
                reverse = tmp;
            }
        }
        if (reverse == i) {
            return true;
        }
        return false;

    }

    public boolean palindromeElegant(int x){
        if (x<0 || (x!=0 && x%10==0)) return false;
        int rev = 0;
        while (x>rev){
            rev = rev*10 + x%10;
            x = x/10;
        }
        return (x==rev || x==rev/10);
    }

    public static void main(String[] args) {
        PalindromeNum9 test = new PalindromeNum9();
        System.out.println(test.parlindromHalpPart(10));

    }

}
