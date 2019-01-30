package com.amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 11/27/18
 * Talk is Cheap,Show me the Code.
 **/
public class RestoreIPAddresses93M {
    public List<String> restoreIpAddresses(String s) {
        List<String> results = new ArrayList<>();
        for (int a = 1; a <= 3; a++)
            for (int b = 1; b <= 3; b++)
                for (int c = 1; c <= 3; c++)
                    for (int d = 1; d <= 3; d++) {
                        if (a + b + c + d == s.length()) {
                            String aString = s.substring(0, a);
                            if (Integer.parseInt(aString) > 255 || (aString.length() > 1 && aString.charAt(0) == '0'))
                                continue;
                            String bString = s.substring(a, a + b);
                            if (Integer.parseInt(bString) > 255 || (bString.length() > 1 && bString.charAt(0) == '0'))
                                continue;
                            String cString = s.substring(a + b, a+b+c);
                            if (Integer.parseInt(cString) > 255 || (cString.length() > 1 && cString.charAt(0) == '0'))
                                continue;
                            String dString = s.substring(a+b+c, s.length());
                            if (Integer.parseInt(dString) > 255 || (dString.length() > 1 && dString.charAt(0) == '0'))
                                continue;

                            StringBuilder sb = new StringBuilder(aString + "." + bString + "." + cString + "." + dString);
                            results.add(sb.toString());
                        }
                    }

        return results;
    }
}
