/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
class Solution {
    /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // write your code here
        StringBuffer res = new StringBuffer();
        if (root == null) return res.toString();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        res.append(root.val);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left != null)   queue.offer(cur.left); //add children to the queue
            if (cur.right != null)  queue.offer(cur.right);
            res.append(",");
            if (cur.left != null) {
                res.append(cur.left.val);
            }
            else res.append("#");
            res.append(",");
            if (cur.right != null) {
                res.append(cur.right.val);
            }
            else res.append("#");
        }
        int i = res.length()-1;
        while (i>=0 && res.charAt(i)=='#') {    //delete end '#'
            res.deleteCharAt(i);
            res.deleteCharAt(i-1);
            i -= 2;
        }
        return res.toString();
    }
    
    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        if (data==null || data.length()==0) return null;
        String[] arr = data.split(",");
        int len = arr.length;
        int count = 0;
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        count++;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            String left="", right="";
            if (count < len) {
                left = arr[count];
                count++;
                if (!left.equals("#")) {
                    cur.left = new TreeNode(Integer.parseInt(left));
                    queue.offer(cur.left);
                }
                else cur.left = null;
            }
            else cur.left = null;
            
            if (count < len) {
                right = arr[count];
                count++;
                if (!right.equals("#")) {
                    cur.right = new TreeNode(Integer.parseInt(right));
                    queue.offer(cur.right);
                }
                else cur.right = null;
            }
            else cur.right = null;
        }
        return root;
    }
}

BFS
http://www.geeksforgeeks.org/serialize-deserialize-binary-tree/
http://articles.leetcode.com/2010/09/serializationdeserialization-of-binary.html
Binary Search Tree Serialization 直接用pre order存储 deserialization时利用bst的特性判断数值的范围 左小右大
http://articles.leetcode.com/2010/09/saving-binary-search-tree-to-file.html









有问题的解法

class Solution {
    /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // write your code here
        StringBuffer res = new StringBuffer();
        if (root == null) return res.toString();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        res.append(root.val);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left != null)   queue.offer(cur.left); //add children to the queue
            if (cur.right != null)  queue.offer(cur.right);
            res.append(",");
            if (cur.left != null) {
                res.append(cur.left.val);
            }
            else res.append("#");
            res.append(",");
            if (cur.right != null) {
                res.append(cur.right.val);
            }
            else res.append("#");
        }
        int i = res.length()-1;
        while (i>=0 && res.charAt(i)=='#') {
            res.deleteCharAt(i);
            res.deleteCharAt(i-1);
            i -= 2;
        }
        return res.toString();
    }
    
    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        if (data==null || data.length()==0) return null;
        String[] arr = data.split(",");
        int len = arr.length;
        int count = 0;
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        count++;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            String left="", right="";
            if (count < len) {
                left = arr[count];
                count++;
                if (!left.equals("#")) {
                    cur.left = new TreeNode(Integer.parseInt(left));
                    queue.offer(cur.left);
                }
                else cur.left = null;
            }
            else cur.left = null;
            
            if (count < len) {
                right = arr[count];
                count++;
                if (!right.equals("#")) {
                    cur.right = new TreeNode(Integer.parseInt(right));
                    queue.offer(cur.right);
                }
                else cur.right = null;
            }
            else cur.right = null;
        }
        return root;
    }
}