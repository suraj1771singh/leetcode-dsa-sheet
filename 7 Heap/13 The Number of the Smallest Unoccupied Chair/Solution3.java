import java.util.*;

//same as to solution2 
public class Solution3 {
    public int smallestChair(int[][] times, int targetFriend) {
        // store targetfrnd arrival time as it is unique
        // sort times on basis of arrival time
        int targetArvl = times[targetFriend][0];
        Arrays.sort(times, (a, b) -> a[0] - b[0]);
        // [depart, seat]
        PriorityQueue<int[]> occupied = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        // seat
        PriorityQueue<Integer> avail = new PriorityQueue<>();
        int seatToken = 0;
        for (int i = 0; i < times.length; i++) {
            int arival = times[i][0];
            int depart = times[i][1];

            while (!occupied.isEmpty() && occupied.peek()[0] <= arival)
                avail.add(occupied.poll()[1]);

            int currentSeat;
            if (avail.isEmpty())
                currentSeat = seatToken++;
            else
                currentSeat = avail.poll();

            occupied.add(new int[] { depart, currentSeat });
            if (arival == targetArvl)
                return currentSeat;
        }
        return -1;
    }
}
