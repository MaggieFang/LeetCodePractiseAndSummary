package recursion;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 11/14/18
 * Talk is Cheap,Show me the Code.
 **/
public class Permutations {
    /**
     * to find all permutations starting at position n, successively place all allowable letters
     * in position n, and for each new letter in position n find all permutations starting at position n + 1
     * (the recursive case). When n is greater than the number of characters in the input string, a permutation
     * has been completed; print it and return to changing letters at positions less than n (the base
     * case)
     */
    String in;
    StringBuilder out = new StringBuilder();
    boolean[] used;

    public void permute(String s) {
        used = new boolean[s.length()];
        this.in = s;

    }

    public void recur() {
        if (out.length() == in.length()) {
            System.out.println(out);
            return;
        }
        for (int i = 0; i < in.length(); i++) {
            if (used[i]) continue;
            out.append(in.charAt(i));
            used[i] = true;
            recur();
            used[i] = false;
            out.setLength(out.length() - 1);
        }
    }
}
