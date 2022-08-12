import java.util.*;

interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a
    // nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a
    // single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested
    // list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

class NestedIterator implements Iterator<Integer> {
    Queue<Integer> q;

    public NestedIterator(List<NestedInteger> nestedList) {
        q = new LinkedList<>();
        dfs(nestedList);
        System.out.println(q);
    }

    @Override
    public Integer next() {
        return q.poll();
    }

    @Override
    public boolean hasNext() {
        return !q.isEmpty();
    }

    public void dfs(List<NestedInteger> nestedList) {
        for (int i = 0; i < nestedList.size(); i++) {
            if (nestedList.get(i).isInteger())
                q.add(nestedList.get(i).getInteger());
            else
                dfs(nestedList.get(i).getList());
        }
    }
}
// Time complexity : O(n)
// Space complexity : O(n)