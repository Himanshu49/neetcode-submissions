/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort((a,b) -> a.start-b.start);
        PriorityQueue<Integer> endTimings = new PriorityQueue<>();
        int rooms = 0;
        for(Interval currMeeting: intervals){
            while(endTimings.size() > 0 && endTimings.peek() <= currMeeting.start){
                endTimings.remove();
            }
            endTimings.add(currMeeting.end);
            rooms = Math.max(rooms, endTimings.size());
        }
        return rooms;
    }
}
