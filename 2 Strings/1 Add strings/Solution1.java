class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder ans = new StringBuilder();
        int n1 = num1.length(), n2 = num2.length(), carry = 0;
        for (int i = n1 - 1, j = n2 - 1; i >= 0 || j >= 0 || carry == 1; i--, j--) {
            int a = i < 0 ? 0 : num1.charAt(i) - '0';
            int b = j < 0 ? 0 : num2.charAt(j) - '0';
            ans.insert(0, (a + b + carry) % 10);
            carry = (a + b + carry) / 10;
        }
        return ans.toString();
    }
}
// Time complexity : O(n)
// Space complexity : O(1)