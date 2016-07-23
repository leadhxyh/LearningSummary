/*
 *	从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行
 */

/*
 *	思路：用队列保存节点，cur保存当前行剩下未打印的节点数，next保存下一行的节点数
 */

public class Solution {
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
    	ArrayList<ArrayList<Integer> > ret = new ArrayList();
        Queue<TreeNode> q = new LinkedList();	//LinkedList实现了Queue接口
        if (pRoot == null)
            return ret;
        
        q.offer(pRoot);
        int next = 0;			//下一行的节点数
        int cur = 1;			//当前行剩下的节点数
        ArrayList<Integer> list = new ArrayList();
        while (!q.isEmpty()) {
            
            TreeNode node = q.poll();
            list.add(node.val);
            if (node.left != null) {
                q.offer(node.left);
                next++;
            }
            	
            if (node.right != null) {
                q.offer(node.right);
                next++;
            }
                
            cur--;
            if (cur == 0) {
                ret.add(list);
                list = new ArrayList();
                
                cur = next;
                next = 0;
                
            }
        }
        return ret;
    }
    
}
