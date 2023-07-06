class Solution {
    public int racecar(int target) {
        return f(0, 1, target, target);
    }

    int f(int pos, int speed, int dist, int target) {
        if (dist == 0)
            return 1;
        int a = 0, b = 0;
        if (dist >= 2 * target) {
            if (speed > 0)
                speed = -1;
            else
                speed = 1;
            return 1 + f(pos, speed, dist, target);
        }
        // acceleratee
        pos += speed;
        a = 1 + f(pos, speed * 2, Math.abs(pos - target), target);
        pos -= speed;
        if (speed > 0)
            speed = -1;
        else
            speed = 1;
        b = 1 + f(pos, speed, Math.abs(pos - target), target);
        return Math.max(a, b);
    }
}