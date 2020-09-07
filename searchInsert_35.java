class searchInsert_35 {
  public static void main(String[] args) {
    searchInsert_35 t = new searchInsert_35();
    int[] a = {1,3};
    System.out.println(t.searchInsert(a,3));
  }
  
  public int searchInsert(int[] nums, int target) {
    int l = nums.length;
    int kl=0;
    int kr=l-1;
    if(nums[0]>=target){
      return 0;
    }else if(nums[nums.length-1]<=target){
      return nums.length;
    }
    while(1==1){
        int k = (int) (kl+kr)/2;
        if(nums[k]==target){
            return k;
        }else if(k-1>=0&&nums[k-1]<target&&nums[k]>target){
            return k;
        }else if(k+1<nums.length&&nums[k]<target&&nums[k+1]>target){
            return k+1;
        }else{
            if(nums[k]>target){
                kr = k==kr?k--:k;
            }else{
                kl = k==kl?k++:k;
            }
        }
    }
}
}