package recursion;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 11/14/18
 * Talk is Cheap,Show me the Code.
 **/
public class Combination {
    /**
     * Begin with an empty output string
     * <p>
     * For each letter from input start position to end of input string
     *      Append the letter to the output string
     *      Print letters in output string
     *      If the current letter isn't the last in the input string
     *          Generate remaining combinations starting at next position with
     *          iteration starting at next letter beyond the letter just selected
     *      Delete the last character of the output string
     */
    private StringBuilder out = new StringBuilder();
    private String in;

    public Combination(String in) {
        this.in = in;
    }

    public void combind() {
        combind(0);
    }

    public void combind(int start) {
        for (int i = start; i < in.length(); i++) {
            out.append(in.charAt(i));
            System.out.println(out);
            if (i < in.length()) {
                combind(i + 1);
            }
            out.setLength(out.length() - 1);
        }

    }

    public static void main(String[] args) {
        Combination test = new Combination("wxyz");
        test.combind();
    }

}
