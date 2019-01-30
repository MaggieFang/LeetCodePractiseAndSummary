package com.oscar;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/19/19
 * Talk is Cheap,Show me the Code.
 **/
public class AddStrings415E {
    //简洁版本，还有sb.insert(0,a)的性能比用append最后再reverse慢，insert用了system.arraycopy()
    public String addStrings(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        if (n1 == 0) return num2;
        if (n2 == 0) return num1;
        StringBuilder sb = new StringBuilder();
        int i = n1 - 1, j = n2 - 1, carrier = 0;
        while (i >= 0 || j >= 0 || carrier == 1) {
            int c1 = i >= 0 ? num1.charAt(i--) - '0' : 0;
            int c2 = j >= 0 ? num2.charAt(j--) - '0' : 0;
            int tmp = c1 + c2 + carrier;
            sb.append(tmp % 10);
            carrier = tmp / 10;
        }
        return sb.reverse().toString();
    }


    public String addStrings2(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        if (n1 == 0) return num2;
        if (n2 == 0) return num1;
        StringBuilder sb = new StringBuilder();
        int carrier = 0;
        int i = n1 - 1;
        int j = n2 - 1;
        while (i >= 0 && j >= 0) {
            int c1 = num1.charAt(i) - '0';
            int c2 = num2.charAt(j) - '0';
            int tmp = c1 + c2 + carrier;
            carrier = tmp / 10;
            sb.insert(0, tmp % 10);
            i--;
            j--;
        }


        while (i >= 0) {
            int tmp = num1.charAt(i) - '0' + carrier;
            carrier = tmp / 10;
            sb.insert(0, tmp % 10);
            i--;
        }

        while (j >= 0) {
            int tmp = num2.charAt(j) - '0' + carrier;
            carrier = tmp / 10;
            sb.insert(0, tmp % 10);
            j--;
        }
        if (carrier == 1) {
            sb.insert(0, carrier);
        }
        return sb.toString();
    }
}
