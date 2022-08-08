//----------------------------NAIVE SOLUTION

class Solution1 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int ans[] = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    int ele = -1;
                    for (int k = j + 1; k < nums2.length; k++) {
                        if (nums2[k] > nums2[j]) {
                            ele = nums2[k];
                            break;
                        }
                    }
                    ans[i] = ele;
                }
            }
        }
        return ans;

    }
}
// Time complexity : O(n^3)
