
class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Integer, char[]> map = new HashMap<>();
        map.put(2, new char[] { 'a', 'b', 'c' });
        map.put(3, new char[] { 'd', 'e', 'f' });
        map.put(4, new char[] { 'g', 'h', 'i' });
        map.put(5, new char[] { 'j', 'k', 'l' });
        map.put(6, new char[] { 'm', 'n', 'o' });
        map.put(7, new char[] { 'p', 'q', 'r', 's' });
        map.put(8, new char[] { 't', 'u', 'v' });
        map.put(9, new char[] { 'w', 'x', 'y', 'z' });
        List<String> ans = new ArrayList<>();
        char[] ch = digits.toCharArray();
        for (char c : ch) {
            int num = Character.getNumericValue(c);
            if (ans.size() == 0) {
                for (char t : map.get(num))
                    ans.add(String.valueOf(t));

            } else {
                List<String> temp = new ArrayList<>();
                for (String s : ans)
                    for (char t : map.get(num))
                        temp.add(s + t);

                ans = temp;
            }
        }
        return ans;

    }
}