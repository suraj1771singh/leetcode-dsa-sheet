//GREEDY APPROACH

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq= new int[27];
        int max_freq=0;
        for(char c : tasks){
            freq[c-'A']++;
            max_freq=Math.max(max_freq,freq[c-'A']);
        }
        int maxCnt=0;
        for(int i=0; i<27; i++){
            if(freq[i]==max_freq) maxCnt++;
        }
        int part=max_freq-1;
        int partLen=n-(maxCnt-1);
        int emptySpc= part*partLen;
        int availTask = tasks.length-(max_freq*maxCnt);
        int idle= Math.max(0, emptySpc - availTask);
        return tasks.length+idle;
    }
}
//Time complexity : O(n+k), where k=27, n=length of task
//Space complexity : O(k)