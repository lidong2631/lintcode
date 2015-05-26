class Solution {
    /**
     * @param A: An integer matrix
     * @return: The index of the peak
     */
    public List<Integer> findPeakII(int[][] A) {
        // write your code here
        List<Integer> res = new ArrayList<Integer>();
        int i=1, j=1;
        while(i<A.length-1 && j<A[0].length-1) {
            if(isValid(A, i, j)) {  //从第二行第二列开始走
                res.add(i);
                res.add(j);
                return res;
            }
            else {        //如果不是peak点 则必然右或下有一个点比当前点大 因为题设已说For all i < m, A[0][i] < A[1][i] && A[n - 2][i] > A[n - 1][i].
                if(A[i+1][j]>A[i][j])   //For all j < n, A[j][0] < A[j][1] && A[j][m - 2] > A[j][m - 1] 所以就是右或下选一个比当前大的走
                    i++;
                else j++;
            }
        }
        return res;
    }
    
    private boolean isValid(int[][] A, int i, int j) {  //判断peak
        if(i<1 || j<1 || i>A.length-1 || j>A[0].length)
            return false;
        return A[i][j]>A[i-1][j] && A[i][j]>A[i][j-1] 
            && A[i][j]>A[i+1][j] && A[i][j]>A[i][j+1];
    }
}

蛮有意思的一题 O(m+n)

这题跟杨氏矩阵有点像，可以使用杨氏矩阵的思想，因为题目已经说时了第二行第二列倒数第二行倒数第二列肯定比第一行第一列倒数第一行倒数第一列的元素大，

那么我们只需从第二行第二列开始寻找，因为要找peek element，所以要跟四周元素比较，如果发现有比它大的元素，那么就移动到比它大的元素的坐标。

如果有右侧与下侧都比它大，那么就移到更大的那一个元素那儿，这样就可以保证下一个比当前元素大的元素只可能出现在右侧或下侧。因为我们只会向右或向下移动，

所以最坏的情况就是移动到右下角，但时间复杂度还是O(N+M)。

http://www.cnblogs.com/easonliu/p/4509505.html

[
  [1 ,2 ,3 ,6 ,5],
  [16,41,23,22,6],
  [15,17,24,21,7],
  [14,18,19,20,10],
  [13,14,11,10,9]
]