package com.lyft;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-07-14
 **/
public class TrappingRainWater42H {
    public int trap(int[] h) {
        if (h == null || h.length == 0) {
            return 0;
        }
        int sum = 0;
        int low = 0;
        int peak = 0;
        int i = 1;
        while(i < h.length){
            if (h[low] < h[peak] && h[low] < h[i])  {
                while(i+1 < h.length && h[i]< h[i+1]){
                    i++;
                }
                sum += (i - peak) * (Math.min(h[peak], h[i]) - h[low]);
            }
            if (h[i] >= h[peak]) {
                peak = i;
                low = i;
            } else if(h[low] > h[i]){
                low = i;
            }
            i++;

        }

        return sum / 2;
    }
    public static void main(String[] args){
        TrappingRainWater42H test = new TrappingRainWater42H();
        int r = test.trap(new int[]{5,2,1,2,1,5});
        System.out.println(r);

    }
}
