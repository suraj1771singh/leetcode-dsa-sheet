import java.util.*;

class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        // Sorting will lose the position of the targetFriend. SO either add the
        // position
        // before sorting, so every data has [arival, departure, position]
        // or just remeber target friend's arrival time (arrival times are distinct)
        int targetFriendsArrival = times[targetFriend][0];

        // Sort the times
        Arrays.sort(times, (t1, t2) -> t1[0] - t2[0]);
        // has [depature, seatNumber]
        Queue<int[]> occupiedSeats = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        // has seatNumbers
        Queue<Integer> avaialableSeats = new PriorityQueue<>();

        int result = 0;
        // seatToken keeps increasing the seat numbers monotonically from 0 till n
        int seatToken = 0;
        for (int i = 0; i < times.length; i++) {
            int arrival = times[i][0];
            int depature = times[i][1];

            // empty all the seats in occupiedSeats that crossed arrival time
            while (!occupiedSeats.isEmpty() && occupiedSeats.peek()[0] <= arrival) {
                // collect in another pq so we can pick from begining
                avaialableSeats.add(occupiedSeats.poll()[1]);
            }

            int currentSeat;
            // Now pick a seat
            if (!avaialableSeats.isEmpty()) {
                // which means we can pick from this
                currentSeat = avaialableSeats.poll();
            } else {
                // which means no empty seats found, take the height seat
                currentSeat = seatToken;
                seatToken++;
            }

            occupiedSeats.add(new int[] { depature, currentSeat });
            if (arrival == targetFriendsArrival) { // We can't use index since we sorted them
                result = currentSeat;
                break;
            }
        }

        return result;
    }
}