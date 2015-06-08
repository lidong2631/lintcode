public class Solution {
    /**
     * @param string: An array of Char
     * @param length: The true length of the string
     * @return: The true length of new string
     */
    public int replaceBlank(char[] string, int length) {
        // Write your code here
        int spaceCount = 0, len = 0;
        for(int i=0; i<length; i++) {
            if(string[i]==' ')
                spaceCount++;
        }
        int newLength = length+2*spaceCount-1;
        int newLen = newLength+1;
        for(int i=length-1; i>=0; i--) {
            if(string[i]==' ') {
                string[newLength] = '0';
                string[newLength-1] = '2';
                string[newLength-2] = '%';
                newLength-=3;
            }
            else {
                string[newLength] = string[i];
                newLength--;
            }
        }
        return newLen;
    }
}

简单题 O(2*n) O(1) cc150原题