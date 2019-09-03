package com.fb;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-04-20
 * Talk is cheap,show me the Code.
 **/
public class ReadNCharactersGivenRead4157E {
    /**
     * The read4 API is defined in the parent class Reader4.
     *     int read4(char[] buf);
     */
    public class Solution extends Reader4 {
        /**
         * @param buf Destination buffer
         * @param n   Number of characters to read
         * @return    The number of actual characters read
         */
        public int read(char[] buf, int n) {
            char[] buf4 = new char[4];
            int index = 0;
            while(index < n){
                int curRead = read4(buf4);
                if(curRead == 0) break;
                int j = 0;
                while(index < n && j < curRead){
                    buf[index++] = buf4[j++];
                }
            }
            return index;
        }
    }

    /**
     * just for fun
     */
    public class Reader4{
        public int read4(char[] buf){
            return 4;
        }
    }
}
