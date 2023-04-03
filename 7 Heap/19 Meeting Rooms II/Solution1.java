import java.util.*;
// ---USING PRIORITY QUEUE
//-ALGO
/*
 * 1) take a var token will  generate room number 
 * 2) mantain a set of available Rooms
 * 3) maintain min heap (accord to end time), on every interval check if any previous meetings has been ended or not
 * 4) if previous meets had been ended , add corresponding assigned room no. to available rooms set
 * 5) if rooms are availble then poll() any room else generate new room id using token
 */

//Definition of Interval:
class Interval {
    int start, end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

 class Main {
    public int getMinRooms(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        TreeSet<Integer> availRoom = new TreeSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int token = 0;
        for (Interval interval : intervals) {
            // check if any meeting is going to be end
            while (!pq.isEmpty() && pq.peek()[0] <= interval.start) availRoom.add(pq.poll()[1]);
            if (availRoom.isEmpty()) pq.add(new int[] { interval.end, token++ });
            else pq.add(new int[] { interval.end, availRoom.pollFirst() });
        }
        return token;

    }
}
//Time complexity : O(n*logn)