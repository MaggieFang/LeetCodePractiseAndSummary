package com.google;

import java.util.HashMap;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-09-06
 **/
public class LoggerRateLimiter359E {
    class Logger {

        /** Initialize your data structure here. */
        HashMap<String,Integer> map;
        public Logger() {
            map = new HashMap<>();

        }

        /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
         If this method returns false, the message will not be printed.
         The timestamp is in seconds granularity. */
        public boolean shouldPrintMessage(int timestamp, String message) {
            Integer t = map.get(message);
            if(t != null && timestamp - t < 10){
                return false;
            }
            map.put(message,timestamp);
            return true;
        }
    }
}
