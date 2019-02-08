package com.mianjing.google;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-02-07
 * Talk is cheap,show me the Code.
 **/
public class VowelCombind {
    /***
     * K值的定义：一个字符串中，连续的两个相同的元音字母为一对，K为该字符串中这样的组合数，如“aabbbbb”:K=1,  "aaoouupppp":K=3, 注意“aaa”:K=2, "aaaa":K=3
     * 写一个函数  f(n,k), 返回满足 【长度为n, K值为k】 的要求的字符串一共有多少种不同的可能数量。如f(2,1)=5,分别为'aa', ''ee', ''ii', 'oo', 'uu'.
     * DP,
     * C[i][j]: end with consonant, i indicate  length,j indicate the k value,
     * V[i][j]: end with vowel, i indicate length,j indicate the k value,
     * C[i][j] = 21C[i-1][j] + V[i-1][j]；  对应最后一位不是元音，不会对j造成影响，前面的字符随便取
     * V[j][j] = 5C[i-1][j]+4V[i-1][j]+ V[i-1][j-1];   V[i][j] 对应cases:
     *  1)前一位不是元音，则最后一位不受约束，可以在五个元音字母中任取一个
     *  2) 前一位不是元音，则最后一位不受约束，可以在五个元音字母中任取一个
     *  3)与前一位相同,当前位确定后，最后一位也确定了
     *  base: V[1][0] = 5, C[1][0] = 21
     *
     */
    public int count(int n, int k) {
        return 0;
    }
}
