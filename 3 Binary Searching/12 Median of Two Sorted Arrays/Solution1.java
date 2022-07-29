

// Time complexity : O(n+m)
// Space complexity :O(1)

class Solution1 {
    public double findMedianSortedArrays(int[] a, int[] b) {
        int i = 0, j = 0, m1 = 0, m2 = 0,n=a.length,m=b.length;
        double median = 0;
        for (int count = 1; count <= (n + m) / 2 + 1; count++) {
            if (i < n && j < m) {
                if (a[i] < b[j]) {
                    m1 = m2;
                    m2 = a[i++];
                } else if (a[i] > b[j]) {
                    m1 = m2;
                    m2 = b[j++];
                }else{
                    m1=m2;
                    m2=a[i++];
                    
                    if(count<(n + m) / 2 + 1){
                        m1=m2;
                        m2=b[j++];
                        count++;
                    }
                    
                }
            } else if (i < n) {
                m1 = m2;
                m2 = a[i++];
            } else if (j < m) {
                m1 = m2;
                m2 = b[j++];
            }
        }

        // two case : even or odd

        if ((m + n) % 2 == 0) // even
            median = (m1 + m2) / (double) 2;
        else // odd
            median = m2;
        return median;
    }
}

// Time complexity : O(n+m)
// Space complexity :O(1)