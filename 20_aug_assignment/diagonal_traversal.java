import java.util.*;

class Tree
{
     public ArrayList<Integer> diagonal(TreeNode root)
      {
           //add your code here.
           ArrayList<Integer> ans = new ArrayList<>();
           Queue<TreeNode> q = new LinkedList<>();
           q.add(root);
           while(q.size()>0){
               TreeNode curr = q.remove();
               while(curr !=null){
                   ans.add(curr.val);
                    if(curr.left !=null){
                        q.add(curr.left);
                    }
                    curr = curr.right;
               }
           }
           return ans;
      }
}
