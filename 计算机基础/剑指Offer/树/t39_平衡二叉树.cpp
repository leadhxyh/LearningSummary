/*
 *	输入一棵二叉树，判断该二叉树是否是平衡二叉树。平衡二叉树左右子树高度-差不超过1
 */

class Solution {
public:
    bool IsBalanced_Solution(TreeNode* pRoot) {
        int i;
		return isBalance(pRoot, &i);
    }
    
	//返回是否平衡，*depth保存该树的高度
	bool isBalance(TreeNode* pRoot , int* depth) {
        if (pRoot == NULL) {
            *depth = 0;
            return true;
        }
        
        int left, right;
        if (isBalance(pRoot->left, &left) && isBalance(pRoot->right, &right)) {
            int diff = left - right;
            if (diff <= 1 && diff >= -1) {
                *depth = 1 + (left > right ? left : right);
                return true;
            }
        }      
        return false;
    }
};
