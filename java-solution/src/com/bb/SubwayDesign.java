package com.bb;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-10-20
 **/
public class SubwayDesign {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * checkin(int userId, int stationId, int timestamp);
     * checkout(int userId,int stationId, int timestamp);
     * computeAverage(int stationA,int stationB)
     * Solution:
     *  Two maps:
     *  map1 for checkin information: Map<UserId,[2]{stationId,startTime}>
     *  map2 for checkout but tricks here, Map<stationA-StationB,[2]{total,freq}>
     * so when checkIn,put the information into map1,
     * when checkout, check if the userId is in map1, if not, not valid; otherwise, get the information of this user from map1.
     * at this time, construct the key for map2 with startStation-endStation, and compute the endtime - startTime,
     * add it to total, increase 1 to freq meanwhile. then delete this userInfo from map1.
     *
     * </p>
     * TIME COMPLEXITY:
     * SPACE COMPLEXITY:
     * </p>
     **/
}
