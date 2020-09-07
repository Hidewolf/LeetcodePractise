import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class minPathSum_64 {
  public static void main(String[] args) {
    minPathSum_64 t = new minPathSum_64();
    int[][] a = {{1,3,1},{1,5,1},{4,2,1}};
    System.out.println(t.minPathSum(a));
  }

  private Map<Integer,Map<Integer,Integer>> minLength = new HashMap();

  public int minPathSum(int[][] grid) {
    return computeMin(grid,0,0);
  }

  private int computeMin(int[][] grid,int x,int y){
    if(x==grid.length-1 && y==grid[0].length-1){
      setMinLength(x,y,grid[x][y]);
      return grid[x][y];
    }else{
      if(this.minLength.get(x)!=null&&this.minLength.get(x).get(y)!=null){
        return this.minLength.get(x).get(y);
      }
      Integer minX = null;
      Integer minY = null;
      if(x<grid.length-1){
        minX = computeMin(grid,x+1,y);
      }
      if(y<grid[0].length-1){
        minY = computeMin(grid,x,y+1);
      }
      if(minX == null){
        setMinLength(x,y,minY.intValue()+grid[x][y]);
        return minY.intValue()+grid[x][y];
      }
      if(minY == null){
        setMinLength(x,y,minX.intValue()+grid[x][y]);
        return minX.intValue()+grid[x][y];
      }
      setMinLength(x,y,grid[x][y]+Math.min(minX, minY));
      return grid[x][y]+Math.min(minX, minY);
    }
  }

  private void setMinLength(int x,int y,int l){
    if(this.minLength.get(x) == null){
      Map<Integer,Integer> map = new HashMap();
      this.minLength.put(x,map);
    }
    if(this.minLength.get(x).get(y)==null){
      this.minLength.get(x).put(y,l);
    }
  }
}