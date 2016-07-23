/**
 *	请实现两个函数，分别用来序列化和反序列化二叉树。这里没有规定序列化的方式
 */

/**
 *	注意：将11等多位数加入string中解析时难以处理，使用,分隔
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
    
    //遇到$返回null
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
