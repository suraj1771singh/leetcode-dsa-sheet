

class Solution1 {
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        for (String i : s.split(" ")) {
            if (i.trim().length() != 0) {
                ans.insert(0, i);
                ans.insert(0, " ");
            }
        }
        return ans.toString().trim();
    }
}
// Time complexity : O(n)