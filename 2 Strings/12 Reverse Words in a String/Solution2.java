
//-----------OPTMISED VERSION

class Solution {

    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        reverse(arr, 0, arr.length - 1);
        int idx = 0, end = 0;
        for (int start = 0; start < s.length(); ++start) {
            if (arr[start] != ' ') {
                if (idx != 0)
                    arr[idx++] = ' ';
                end = start;
                while (end < arr.length && arr[end] != ' ')
                    arr[idx++] = arr[end++];
                reverse(arr, idx - (end - start), idx - 1);
                start = end;
            }
        }
        return String.valueOf(arr).substring(0, idx);
    }

    private void reverse(char[] arr, int i, int j) {
        int lo = i, hi = j;
        while (lo < hi) {
            char t = arr[lo];
            arr[lo] = arr[hi];
            arr[hi] = t;
            ++lo;
            --hi;
        }
    }
}
// Time complexity : O(n)