/*
 *	��ʵ��һ����������֮���δ�ӡ������������һ�а��մ����ҵ�˳���ӡ���ڶ��㰴�մ��������˳���ӡ�������а��մ����ҵ�˳���ӡ���������Դ����ơ�
 */

/*
 *	˼·��ʹ������ջ�ֱ𱣴�һ���Ԫ��
 */

public class Solution {
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer> > ret = new ArrayList();
		if (pRoot == null)
            return ret;
        
        Stack<TreeNode> level1 = new Stack();
        Stack<TreeNode> level2 = new Stack();
        int cur = 0;
        level1.push(pRoot);

		//��ֹ����:����ջ��Ϊ��
        while (!level1.isEmpty() || !level2.isEmpty()) {
            //�ȴ�ӡ��ǰջ��Ȼ����Ԫ�ط�����һ��ջ�У���Ҫ���˳��
            if (cur == 0) {
                ArrayList<Integer> list = new ArrayList();
                while (!level1.isEmpty()) {
                    TreeNode node = level1.pop();
                    list.add(node.val);
                    if (node.left != null) {
                        level2.push(node.left);
                    }
                    if (node.right != null) {
                        level2.push(node.right);
                    }
                }
                ret.add(list);
            } else {
				ArrayList<Integer> list = new ArrayList();
                while (!level2.isEmpty()) {
                    TreeNode node = level2.pop();
                    list.add(node.val);
					if (node.right != null) {
                        level1.push(node.right);
                    }
                    if (node.left != null) {
                        level1.push(node.left);
                    }

                }
                ret.add(list);
            }
            cur = 1 - cur;
        }
        return ret;
    }

}
