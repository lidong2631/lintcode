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
            //len++;
        }
        int newLength = length+2*spaceCount-1;
        int newLen = newLength;
        for(int i=length-1; i>=0; i--) {
            System.out.println("before: " + newLength);
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
            System.out.println("after: " + newLength);
        }
        return newLen;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        char[] str = new char[20];
        str[0] = 'h';
        str[1] = 'e';
        str[2] = 'l';
        str[3] = 'l';
        str[4] = 'o';
        str[5] = ' ';
        str[6] = 'w';
        str[7] = 'o';
        str[8] = 'r';
        str[9] = 'l';
        str[10] = 'd';
        s.replaceBlank(str, 11);
        System.out.println(String.valueOf(str));
    }
}
