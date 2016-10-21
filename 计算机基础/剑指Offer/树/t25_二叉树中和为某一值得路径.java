/**
 *	����һ�Ŷ�������һ����������ӡ���������н��ֵ�ĺ�Ϊ��������������·����·������Ϊ�����ĸ���㿪ʼ����һֱ��Ҷ����������Ľ���γ�һ��·����
 */

/*
 *	˼·���������
 */

public class Solution {
    ArrayList<ArrayList<Integer>> ret = new ArrayList();
    int sum = 0;
    ArrayList<Integer> path = new ArrayList();
    
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null)
            return ret;
        findPathCore(root, target);
        return ret;
    }
    
    //��֤root�ǿ�,�����������
	void findPathCore(TreeNode root, int target) {
		sum += root.val;
        path.add(root.val);
        //Ҷ�ӽڵ���ֵ���
        if (sum == target && root.left == null && root.right == null) {
 
			ArrayList<Integer> tem = (ArrayList<Integer>)path.clone();
            ret.add(tem);	   
        }
        
        if (root.left != null)
        	findPathCore(root.left, target);
        
        if (root.right != null)
        	findPathCore(root.right, target);            
        
        sum -= root.val;
        path.remove(path.size() - 1);
        
    }
}
