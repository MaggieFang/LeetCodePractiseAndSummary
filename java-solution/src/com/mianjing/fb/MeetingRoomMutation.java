package com.mianjing.fb;

import com.basicStructure.Interval;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/12/18
 * Talk is Cheap,Show me the Code.
 **/
public class MeetingRoomMutation {

    //        test.time("10:00 am - 10:20 am");
    //        test.time("12:00 am - 12:00 pm");
    //        test.time("12:30 pm - 01:00 pm");
    public Interval getTime(String time) throws ParseException {
        String[] strs = time.split(" - ");
        SimpleDateFormat format = new SimpleDateFormat("hh:mm a");
        SimpleDateFormat date24Format = new SimpleDateFormat("HH:mm");
        String start = date24Format.format(format.parse(strs[0]));
        String end = date24Format.format(format.parse(strs[1]));
        int startT = Integer.parseInt(start.substring(0, 2) + start.substring(3));
        int endT = Integer.parseInt(end.substring(0, 2) + end.substring(3));
        Interval interval = new Interval(startT,endT);
        return interval;
    }


}
