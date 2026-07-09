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
    public boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));
        int prevEnd = -1;
        for(Interval currMeeting: intervals){
            if(currMeeting.start < prevEnd){
                return false;
            }

            prevEnd = currMeeting.end;
        }

        return true;
    }
}
