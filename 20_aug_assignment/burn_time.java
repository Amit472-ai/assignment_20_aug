class Solution {
    int maxtime=0;
    public int amountOfTime(TreeNode root, int start) {
        find(root,start);
        return maxtime;
    }
    private int find(TreeNode root,int start){
        if(root==null) return -1;

        if(root.val==start){
            dfs(root,0);
            return 1;
        }
        int left=find(root.left,start);
        if(left>0){
            dfs(root.right,left+1);
            maxtime=Math.max(maxtime,left);
            return left+1;
        }
        int right = find(root.right, start);
        if (right > 0) {
            dfs(root.left, right+1);
            maxtime = Math.max(maxtime, right); 
            return right + 1;
        }
        return -1;

    }
    private void dfs(TreeNode root,int time){
        if(root ==null) return ;

        maxtime=Math.max(maxtime,time);
        dfs(root.left,time+1);
        dfs(root.right,time+1);
    }
}