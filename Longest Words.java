class Solution {
    /**
     * @param dictionary: an array of strings
     * @return: an arraylist of strings
     */
    ArrayList<String> longestWords(String[] dictionary) {
        // write your code here
        int maxLen = 0;
        ArrayList<String> res = new ArrayList<String>();
        for(String s : dictionary) {
            maxLen = Math.max(maxLen, s.length());
        }
        for(String s : dictionary) {
            if(s.length()==maxLen)
                res.add(s);
        }
        return res;
    }
};

O(2*n) O(1)

扫两遍第一遍确定最大值 第二遍找出结果