/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int maxi = 0;
    
    int maxDepth(TreeNode* root){
        if(root == NULL) return 0;
        
        int ld = maxDepth(root->left);
        int rd = maxDepth(root->right);
        maxi = max(maxi, ld+rd);
        return max(ld, rd) + 1;
    }
    
    int diameterOfBinaryTree(TreeNode* root) {
        maxDepth(root);
        return maxi;
        
    }
};
// T : O(N)
//S : O(1)
