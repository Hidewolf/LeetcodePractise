import java.util.ArrayList;
import java.util.List;

public class minimumTotal_120 {
  public static void main(String[] args) {
    minimumTotal_120 t = new minimumTotal_120();
    List<Integer> tIntegers = new ArrayList();
    //System.out.println(t.minimumTotal(nums, 8));
  }

  public int minimumTotal(List<List<Integer>> triangle) {
    for(int i = triangle.size()-1;i>0;i--){
        for(int j = 0;j<triangle.get(i).size()-1;j++){
            int t = triangle.get(i-1).get(j);
            int t1 = triangle.get(i).get(j);
            int t2 = triangle.get(i).get(j+1);
            if(t1<t2){
                triangle.get(i-1).set(j, t+t1);
            }else{
              triangle.get(i-1).set(j, t+t2);
            }
        }
    }
    return triangle.get(0).get(0);
    }
    
}
/* 
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
//dps?
//dp 按层遍历利用动态规划优化，按照层dp[i][],类似于从左上到右下的矩阵

// 特判
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

int [][] dp =new int[triangle.size()][triangle.get(triangle.size()-1).size()];
dp[0][0] = triangle.get(0).get(0);
for(int i =1 ;i <triangle.size();i++){
    for(int j =0; j<=i; j++){
        if(j == 0){
            dp[i][j] = dp[i-1][j]+triangle.get(i).get(j);
        }
        else if(j == i){
            dp[i][j] = dp[i-1][j-1]+triangle.get(i).get(j);
        }
        else{
        dp[i][j] = Math.min(dp[i-1][j-1],dp[i-1][j])+triangle.get(i).get(j);
        }
    }
}

int res = Integer.MAX_VALUE;
// dp最后一行记录了最小路径
        for (int i = 0; i < triangle.get(triangle.size()-1).size(); i++) {
            res = Math.min(res, dp[triangle.size() - 1][i]);
        }
        return res;

    } 
}*/