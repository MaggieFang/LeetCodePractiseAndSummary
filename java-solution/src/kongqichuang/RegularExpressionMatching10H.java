package kongqichuang;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-11-04
 **/
public class RegularExpressionMatching10H {
    /**
     * Clarification:
     * recur
     * </p>
     * Keypoints:
     * if p is empty, return s isemty
     * if p size > 1 and p[1] = '*', there are case that, we skip the p[0] and p[1]. so the result is isMatch(s,p.substring(2)),
     * another case is s[0] match with p[0](equal or '.'), so we begin from s.substring(1) to match p(random match)
     * otherwise, s[0] should match p[0] and isMatch(s.substring(1),p.substring(1))
     * </p>
     * TIME COMPLEXITY:
     * SPACE COMPLEXITY:
     * </p>
     **/
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        boolean firstMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        if (p.length() > 1 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) || firstMatch && isMatch(s.substring(1), p);
        } else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }


    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * totally translate from the recur
     * </p>
     * TIME COMPLEXITY:
     * SPACE COMPLEXITY:
     * </p>
     **/
    public boolean isMatchDP(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[m][n] = true;
        for (int i = m; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                boolean firstMatch = i < m && (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i));
                if (j + 1 < n && p.charAt(j + 1) == '*') {
                    dp[i][j] = dp[i][j + 2] || (firstMatch && dp[i + 1][j]);
                } else {
                    dp[i][j] = firstMatch && dp[i + 1][j + 1];
                }
            }
        }

        return dp[0][0];
    }

}
