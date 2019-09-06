/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-09-06
 **/
public class BinaryTemplete {
    public int binary(int[] nums,int target){
        int left = 0;
        int right = nums.length;
        while (left < right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target) return mid;
            if(nums[mid] < target) left = mid + 1;
            else  right = mid;
        }
        return -1;
    }
}
