/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        // Write your code here
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<Integer>();
        Set<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>();
        for(UndirectedGraphNode curr : nodes) {
            if(!set.contains(curr)) {
                dfs(set, curr, tmp);
                Collections.sort(tmp);
                res.add(new ArrayList<Integer>(tmp));   //这里要new一个新的tmp 因为后面就tmp.clear()了 如果不new新的 res里存的tmp会被改变
                tmp.clear();
            }
        }
        return res;
    }
    
    private void dfs(Set<UndirectedGraphNode> set, UndirectedGraphNode curr, List<Integer> tmp) {
        set.add(curr);
        tmp.add(curr.label);
        for(UndirectedGraphNode node : curr.neighbors) {
            if(!set.contains(node))
                dfs(set, node, tmp);
        }
    }
}

dfs O(n)




/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        // Write your code here
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<Integer>();
        Set<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>();
        for(UndirectedGraphNode curr : nodes) {
            if(!set.contains(curr)) {
                Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
                queue.add(curr);
                set.add(curr);
                tmp.add(curr.label);
                while(!queue.isEmpty()) {
                    UndirectedGraphNode node = queue.poll();
                    for(UndirectedGraphNode n : node.neighbors) {
                        if(!set.contains(n)) {
                            set.add(n);
                            queue.offer(n);
                            tmp.add(n.label);
                        }
                    }
                }
                Collections.sort(tmp);
                res.add(new ArrayList<Integer>(tmp));
                tmp.clear();
            }
        }
        return res;
    }
}

bfs