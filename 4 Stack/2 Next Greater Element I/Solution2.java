import java.util.*;

//--------------------------USING STACK 

/*
Basically the problem says, if in nums1 we are working on 4, 
then in nums2 first find where is 4 and from that index find 
the next number greater than 4 in nums2. We can see that the 
solution is always coming from the reverse side of the list 
nums2. This should tell us to use stack.
*/
class Solution2 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num)
                map.put(stack.pop(), num);
            stack.push(num);
        }
        int ans[] = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++)
            ans[i] = map.getOrDefault(nums1[i], -1);
        return ans;
    }

}
// Time complexity : O(n)
// Space complexity : O(n)
