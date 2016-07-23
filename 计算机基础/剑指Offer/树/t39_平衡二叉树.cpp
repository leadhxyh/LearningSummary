/*
 *	����һ�ö��������жϸö������Ƿ���ƽ���������ƽ����������������߶�-�����1
 */

class Solution {
public:
    bool IsBalanced_Solution(TreeNode* pRoot) {
        int i;
		return isBalance(pRoot, &i);
    }
    
	//�����Ƿ�ƽ�⣬*depth��������ĸ߶�
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
