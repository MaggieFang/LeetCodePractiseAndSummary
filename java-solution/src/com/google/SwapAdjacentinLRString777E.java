package com.google;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 12/30/18
 * Talk is Cheap,Show me the Code.
 **/
public class SwapAdjacentinLRString777E {
    /**
     * KEYPOINTS:
     * <p>
     * the L can be move backward,to the prior position and the R can be move forward,in the future position.
     * So we use two pointer for string start and string end, to find the non-X letter,when they are not same,return false.
     * (Why? Since when R, L only exchange with X,the relative position of L R cannot change.)
     * So when start[i] == 'L' then end[j] == 'L' and only when i > j, such that the L in start be move back to j position
     * similary, when 'R' only when i < j
     * <p>
     * https://www.cnblogs.com/grandyang/p/9001474.html
     * 我们每次分别找到start和end中非X的字符，如果二者不相同的话，直接返回false，想想问什么？这是因为不论是L还是R，其只能跟X交换位置，
     * L和R之间是不能改变相对顺序的，所以如果分别将start和end中所有的X去掉后的字符串不相等的话，那么就永远无法让start和end相等了。
     * 这个判断完之后，就来验证L只能前移，R只能后移这个限制条件吧，当i指向start中的L时，那么j指向end中的L必须要在前面，所以如果i小于j的话，就不对了，
     * 同理，当i指向start中的R，那么j指向end中的R必须在后面，所以i大于j就是错的
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
    public boolean canTransform(String start, String end) {
        int i = 0, j = 0;
        int n = start.length();
        while (i < n && j < n) { // i for start,j for end
            while (i < n && start.charAt(i) == 'X') {
                i++;
            }
            while (j < n && end.charAt(j) == 'X') {
                j++;
            }
            if ((i < n && j >= n) || (i >= n && j < n)) { // e.g start = "X", end = "R",车辆不匹配情况
                return false;
            }

            if (i < n && j < n) {
                char c1 = start.charAt(i);
                char c2 = end.charAt(j);
                if (c1 != c2 || (c1 == 'L' && i < j) || (c1 == 'R' && i > j)) {
                    return false;
                } else {
                    i++;
                    j++;
                }
            }

        }
        return true;

    }
}
