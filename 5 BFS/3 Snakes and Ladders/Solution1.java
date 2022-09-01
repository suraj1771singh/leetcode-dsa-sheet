import java.util.*;

class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        int left = 0, right = board.length - 1;
        while (left < right) {
            int temp[] = board[left];
            board[left] = board[right];
            board[right] = temp;
            left++;
            right--;
        }
        int moves = 0;
        q.add(1);
        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int num = q.poll();
                for (int i = 1; i < 7; i++) {
                    int nextNum = num + i;
                    int a[] = inToPos(nextNum, n);

                    int r = a[0], c = a[1];
                    if (board[r][c] != -1)
                        nextNum = board[r][c];
                    if (nextNum == n * n)
                        return moves + 1;
                    if (nextNum <= n * n && !set.contains(nextNum)) {
                        set.add(nextNum);
                        q.add(nextNum);
                    }
                }
            }
            moves++;

        }
        return -1;

    }

    public int[] inToPos(int num, int n) {
        int[] a = new int[2];
        int r = (num - 1) / n;
        int c = (num - 1) % n;
        if (r % 2 == 0)
            c = n - 1 - c;
        a[0] = r;
        a[1] = c;
        return a;
    }
}