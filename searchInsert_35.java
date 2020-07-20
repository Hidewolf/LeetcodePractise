class searchInsert_35 {
  public static void main(String[] args) {
    searchInsert_35 t = new searchInsert_35();
    int[] a = {1,3,5,6};
    System.out.println(t.searchInsert(a,7));
  }
  public int searchInsert(int[] nums, int target) {
      int l = nums.length;
      int kl=0;
      int kr=l-1;
      while(1==1){
          int k = (int) (kl+kr)/2;
          if(nums[k]==target){
              return k;
          }else if(kl == kr){
              return k;
          }else{
              if(nums[k]>target){
                  kr = k;
              }else{
                  kl = k;
              }
          }
      }
  }
}