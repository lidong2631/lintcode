public class Solution {
    /**
     * @param matrix an integer matrix
     * @return the coordinate of the left-up and right-down number
     */
    public int[][] submatrixSum(int[][] matrix) {
        // Write your code here
        int[][] res = {{-1,-1}, {-1,-1}};
        for(int left=0; left<matrix[0].length; left++) {
            int[] tmp = new int[matrix.length];
            for(int right=left; right<matrix[0].length; right++) {
                for(int i=0; i<matrix.length; i++)
                    tmp[i]+=matrix[i][right];
                Map<Integer, Integer> map = new HashMap<Integer, Integer>();
                int sum = 0;
                for(int i=0; i<matrix.length; i++) {
                    sum+=tmp[i];
                    if(sum==0) {    //三种情况下找到结果 1 累加到现在的和为0 2 当前元素的值为0 3 如果map中有这个sum则说明前面的数累加起来是0
                        res[0][0] = 0;
                        res[0][1] = left;
                        res[1][0] = i;
                        res[1][1] = right;
                        return res;
                    }
                    else if(tmp[i]==0){
                        res[0][0] = i;
                        res[0][1] = left;
                        res[1][0] = i;
                        res[1][1] = right;
                        return res;
                    }
                    else if(map.containsKey(sum)) {
                        res[0][0] = map.get(sum)+1;
                        res[0][1] = left;
                        res[1][0] = i;
                        res[1][1] = right;
                        return res;
                    }
                    map.put(sum, i);
                }
            }
        }
        return res;
    }
}

O(n^3) O(m) m是行数

参考geeksforgeeks上两道很好的题 一个求数组是否有子数组和为0 另一个求二维数组中子矩阵的最大和
http://www.geeksforgeeks.org/find-if-there-is-a-subarray-with-0-sum/
http://www.geeksforgeeks.org/dynamic-programming-set-27-max-sum-rectangle-in-a-2d-matrix/