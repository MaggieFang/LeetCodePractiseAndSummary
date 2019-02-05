package com.intuit;

import java.util.*;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-02-05
 * Talk is Cheap,Show me the Code.
 **/
public class commonCourse {
    /*** common course
     * input : {{"58", "A"},  {"94", "B"},  {"17", "A"},  {"58", "B"},  {"17", "B"},  {"58", "C"}}
     * output  :[58, 94]: [B]
     *         [58, 17]: [A, B]
     *         [94, 17]: [B]
     */
    public static void main(String[] args){
        commonCourse t = new commonCourse();
        t.getCommon(new String[][]{{"58", "A"},  {"94", "B"},  {"17", "A"},  {"58", "B"},  {"17", "B"},  {"58", "C"}});
    }

    public List<CommonInfo> getCommon(String[][] info){
       CourseInfo totalInfo = new CourseInfo();
       for(String[] s : info){
          totalInfo.addItem(s[0],s[1]);
       }
       List<CommonInfo> ans = new ArrayList<>();
      for(int i = 0; i < totalInfo.ids.size();i++){
          for(int j = i+1;j < totalInfo.ids.size();j++){
              Set<String> intersection = new HashSet<>(totalInfo.courses.get(i));
              intersection.retainAll(totalInfo.courses.get(j));
              ans.add(new CommonInfo(totalInfo.ids.get(i),totalInfo.ids.get(j),intersection));
          }
      }
      return ans;
    }

    class CourseInfo{
        List<String> ids;
        List<HashSet<String>> courses;

        public CourseInfo() {
            this.ids = new ArrayList<>();
            this.courses = new ArrayList<>();
        }

        public void addItem(String id,String course){
            int index = this.ids.indexOf(id);
            if(index == -1){
                this.ids.add(id);
                HashSet<String> set  = new HashSet<>();
                set.add(course);
                this.courses.add(set);
            }else {
                this.courses.get(index).add(course);
            }

        }

    }
    class CommonInfo {
        String id1;
        String id2;
        Set<String> commonCourses;

        public CommonInfo(String id1, String id2, Set<String> commonCourses) {
            this.id1 = id1;
            this.id2 = id2;
            this.commonCourses = commonCourses;
        }
    }
}
