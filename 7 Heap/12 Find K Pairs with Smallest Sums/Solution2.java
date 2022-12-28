import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    public static void main(String[] args) {
        List<Integer> arr[] = new ArrayList[2];
        arr[0] = new ArrayList<>(Arrays.asList(0, 1));
        arr[1] = new ArrayList<>(Arrays.asList(0, 2));
        for (List i : arr) {
            System.out.println(i.get(0) + " " + i.get(1));
        }
    } 
}
