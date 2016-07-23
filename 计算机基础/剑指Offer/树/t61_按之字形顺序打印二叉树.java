/*
 *	请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */

/*
 *	思路：使用两个栈分别保存一层的元素
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

		//终止条件:两个栈都为空
        while (!level1.isEmpty() || !level2.isEmpty()) {
            //先打印当前栈，然后将子元素放入另一个栈中，主要添加顺序
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
