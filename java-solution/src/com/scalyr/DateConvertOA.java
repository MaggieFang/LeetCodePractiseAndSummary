package com.scalyr;

import java.util.HashMap;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 11/17/18
 * Talk is Cheap,Show me the Code.
 **/
public class DateConvertOA {
    public static String[] dateConvert(String[] D) {
        if (D == null) {
            return null;
        }
        String[] ans = new String[D.length];
        HashMap<String, String> map = new HashMap<String, String>() {
            {
                put("Jan", "01-");
                put("Feb", "02-");
                put("Mar", "03-");
                put("Apr", "04-");
                put("May", "05-");
                put("Jun", "06-");
                put("Jul", "07-");
                put("Aug", "08-");
                put("Sep", "09-");
                put("Oct", "10-");
                put("Nov", "11-");
                put("Dec", "12-");
            }
        };

        for (int i = 0; i < D.length; i++) {
            String item = D[i];
            String[] sp = item.split(" ");
            StringBuilder day = new StringBuilder(sp[0].substring(0, sp[0].length() - 2));
            if (day.length() == 1) {
                day.insert(0, '0');
            }

            ans[i] = sp[2] + "-" + map.get(sp[1]) + day;

        }
        return ans;

    }

    public static void main(String[] args) {
        String[] s = new String[]{"1st Mar 1980", "12th Jul 2008"};
        String[] a = dateConvert(s);
        for (String i : a) {
            System.out.println(i);
        }

    }
}
