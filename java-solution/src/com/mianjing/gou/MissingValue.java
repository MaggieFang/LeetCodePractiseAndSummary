package com.mianjing.gou;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/9/19
 * Talk is Cheap,Show me the Code.
 **/
public class MissingValue {
    // https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=466421&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3088%5D%5Bvalue%5D%3D1%26searchoption%5B3088%5D%5Btype%5D%3Dradio%26searchoption%5B3089%5D%5Bvalue%5D%5B2%5D%3D2%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3090%5D%5Bvalue%5D%3D2%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D1%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline
    public String getMissing(int[] nums){
       if(nums == null || nums.length == 0) return "0-99";

        if(nums.length == 1){
            if(nums[0] == 0){
                return "1-99";
            }
            if(nums[0]== 99){
                return "0-98";
            }
            return "0-"+(nums[0]-1)+","+(nums[0]+1)+"99";
        }
       StringBuilder sb = new StringBuilder();
       for(int i = 1; i < nums.length;i++){//{13,15}?
           if(sb.length() != 0){
               sb.append(",");
           }
           if(nums[i-1]+1 == nums[i]-1){
               sb.append(nums[i-1]+1);
           }else {
               sb.append(nums[i-1]+1).append("-").append(nums[i]-1);
           }
       }

       if(nums[0] == 1){
           sb.insert(0,"0,");
       }else if(nums[0] != 0){
           sb.insert(0,"0-"+(nums[0]-1));
       }

       if(nums[nums.length -1] == 98){
           sb.append(",99");
       }else if(nums[nums.length -1] != 99){
           sb.append(","+(nums[nums.length-1]+1)+"-99");

       }


       return sb.toString();
    }
    public static void main(String[] args){
        MissingValue t = new MissingValue();
        System.out.println(t.getMissing(new int[]{0,13,98}));

    }
}
