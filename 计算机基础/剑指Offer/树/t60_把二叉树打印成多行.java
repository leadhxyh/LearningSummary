/*
 *	���ϵ��°����ӡ��������ͬһ����������������ÿһ�����һ��
 */

/*
 *	˼·���ö��б���ڵ㣬cur���浱ǰ��ʣ��δ��ӡ�Ľڵ�����next������һ�еĽڵ���
 */

public class Solution {
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
    	ArrayList<ArrayList<Integer> > ret = new ArrayList();
        Queue<TreeNode> q = new LinkedList();	//LinkedListʵ����Queue�ӿ�
        if (pRoot == null)
            return ret;
        
        q.offer(pRoot);
        int next = 0;			//��һ�еĽڵ���
        int cur = 1;			//��ǰ��ʣ�µĽڵ���
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
