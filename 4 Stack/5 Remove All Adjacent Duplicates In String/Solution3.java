class Solution3 {
    public String removeDuplicates(String s) {
        int end = -1;
        char ch[] = s.toCharArray();
        for (char c : ch) {
            if (end > -1 && ch[end] == c)
                end--;
            else
                ch[++end] = c;
        }
        return String.valueOf(ch, 0, end + 1);
    }

}
// Time complexity :O(n)
// Space complexity : O(n)