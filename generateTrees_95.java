import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class generateTrees_95 {
  public static void main(String[] args) {
    generateTrees_95 t = new generateTrees_95();
    System.out.println(t.generateTrees(3));
  }

  public List<TreeNode> generateTrees(int n) {
    if (n == 0) {
      return new ArrayList<TreeNode>();
    }
    return generateTrees(1, n);
  }

  private List<TreeNode> generateTrees(int s, int e) {
    List<TreeNode> res = new LinkedList<TreeNode>();
    if (s > e) {
      res.add(null);
      return res;
    }
    for (int i = s; i <= e; i++) {
      List<TreeNode> lTrees = generateTrees(s, i - 1);
      List<TreeNode> rTrees = generateTrees(i + 1, e);
      for (int li = 0; li < lTrees.size(); li++) {
        for (int ri = 0; ri < rTrees.size(); ri++) {
          TreeNode tree = new TreeNode(i,lTrees.get(li),rTrees.get(ri));
          res.add(tree);
        }
      }
    }

    return res;
  }

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}