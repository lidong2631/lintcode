public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: As described
     * @return: The majority number
     */
    public int majorityNumber(ArrayList<Integer> nums, int k) {
        // write your code
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int count = 0;
        int i = 0;
        while(count<k && i<nums.size()) {
            int curr = nums.get(i);
            if(map.containsKey(curr)) {
                map.put(curr, map.get(curr)+1);
            }
            else {
                map.put(curr, 1);
                count++;
            }
            i++;
        }
        
        while(i<nums.size()) {
            int curr = nums.get(i);
            if(map.containsKey(curr)) {
                map.put(curr, map.get(curr)+1);
            } else {
                if(map.values().contains(0)) {
                    Integer zeroKey = null;
                    map.put(curr, 1);
                    for(Map.Entry entry : map.entrySet()) {
                        if(entry.getValue().equals(0)) {
                            zeroKey = (Integer)entry.getKey();
                            break;
                        }
                    }
                    map.remove(zeroKey);
                }
                else {
                    for(Map.Entry entry : map.entrySet()) {
                        map.put((Integer)entry.getKey(), (Integer)entry.getValue()-1);
                    }
                }
            }
            i++;
        }
        
        Map<Integer, Integer> newMap = new HashMap<Integer, Integer>();
        int maxCount = 0, maxNum = 0;
        for(int j=0; j<nums.size(); j++) {
            int curr = nums.get(j);
            if(map.containsKey(curr)) {
                newMap.put(curr, newMap.containsKey(curr)?newMap.get(curr)+1:1);
                if(newMap.get(curr)>maxCount) {
                    maxCount = newMap.get(curr);
                    maxNum = curr;
                }
            }
        }
        return maxNum;
    }
}

O(n) O(k)

http://blog.csdn.net/nicaishibiantai/article/details/43636799