import java.util.ArrayList;

class Solution1 {
    final double eps = 0.001;

    public boolean judgePoint24(int[] nums) {
        ArrayList<Double> list = new ArrayList<>();
        for (int i : nums)
            list.add((double) i);
        return f(list);
    }

    public boolean f(ArrayList<Double> list) {
        int n = list.size();
        if (n == 1) {
            return Math.abs(24.0 - list.get(0)) <= eps;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;
                Double firstNum = list.get(i);
                Double secondNum = list.get(j);
                ArrayList<Double> validOp = validOperations(firstNum, secondNum);
                ArrayList<Double> nextArray = new ArrayList<>();
                for (Double res : validOp) {
                    nextArray.clear();
                    nextArray.add(res);

                    for (int k = 0; k < n; k++) {
                        if (k == i || k == j)
                            continue;
                        nextArray.add(list.get(k));
                    }
                    if (f(nextArray))
                        return true;
                }

            }
        }
        return false;
    }

    public ArrayList<Double> validOperations(Double a, Double b) {
        ArrayList<Double> validOp = new ArrayList<>();
        validOp.add(a + b);
        validOp.add(a * b);
        validOp.add(a - b);
        validOp.add(b - a);
        if (Math.abs(b) > eps)
            validOp.add(a / b);
        if (Math.abs(a) > eps)
            validOp.add(b / a);
        return validOp;

    }
}