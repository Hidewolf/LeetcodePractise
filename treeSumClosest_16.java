import jdk.nashorn.internal.runtime.Undefined;

class Solution16 {
  public static void main(String[] args) {
    Solution16 t = new Solution16();
    int[] nums = { 0,2,1,-3 };
    
    System.out.println(t.threeSumClosest(nums, 1));
  }

  public int threeSumClosest(int[] nums, int target) {
    if(nums.length==3){
        return nums[0]+nums[1]+nums[2];
    }
    this.orderArray(nums, 0, nums.length - 1);
    //Arrays.sort(nums);
    int res = nums[0]+nums[1]+nums[2];
    int minDiff = Math.abs(res-target);
    for(int j = 0;j<nums.length;j++){
      int s = j+1;
      int e = nums.length-1;
      while(s<e){
          int sum = nums[j]+nums[s]+nums[e];
        if(Math.abs(sum-target)<minDiff){
          res = sum;
          minDiff = Math.abs(res-target);
        }
        if(res==target){
          return res;
        }else
        if(sum<target){
          s++;
        }else
        if(sum>target){
          e--;
        }
      }
    }
    return res;
  }
//快速排序
  private void orderArray(int[] nums, int i_s, int i_e) {
    if (i_s < i_e) {
      int i_p = this.getIndex(nums, i_s, i_e);
      this.orderArray(nums, i_s, i_p-1);
      this.orderArray(nums, i_p+1, i_e);
    }
  }

  private int getIndex(int[] nums, int i_s, int i_e) {
    int p = nums[i_s];
    while (i_s < i_e) {
      while (nums[i_e] >= p && i_s < i_e) {
        i_e--;
      }
      nums[i_s] = nums[i_e];
      while (nums[i_s] <= p && i_s < i_e) {
        i_s++;
      }
      nums[i_e] = nums[i_s];
    }
    nums[i_s] = p;
    return i_s;
  }
}