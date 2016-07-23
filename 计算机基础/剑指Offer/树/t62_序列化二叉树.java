/**
 *	��ʵ�������������ֱ��������л��ͷ����л�������������û�й涨���л��ķ�ʽ
 */

/**
 *	ע�⣺��11�ȶ�λ������string�н���ʱ���Դ���ʹ��,�ָ�
 */

public class Solution {
    int index = 0;
    StringBuilder sb = new StringBuilder();
    
    String Serialize(TreeNode root) {
        SerializeCore(root);
        return sb.toString();
  	}
    
    TreeNode Deserialize(String str) {
       return DeserializeCore(str.split(","));
  	}
    
	void SerializeCore(TreeNode root) {
        if (root == null) {
			sb.append("$,");  
            return;
        }

      	sb.append(""+root.val+",");
        Serialize(root.left);
        Serialize(root.right);
    }
    
    //����$����null
    TreeNode DeserializeCore(String[] s) {
        if (index < s.length && !s[index].equals("$")) {
            TreeNode root = new TreeNode(Integer.valueOf(s[index]));
			index++;
            root.left = DeserializeCore(s);
            root.right = DeserializeCore(s);            
            
            return root;
        } else if (index < s.length && s[index].equals("$")) {
           	index++;
            return null;
        }

        return null;
    }
    
}
