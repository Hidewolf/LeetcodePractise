class Solution {
  public static void main(String[] args) {
    Solution t = new Solution();
    System.out.println(t.addBinary("111","1"));
  }
  public String addBinary(String a, String b) {
      StringBuilder str = new StringBuilder();
      int l = a.length();
      if(b.length()>l){
          l=b.length();
      }
      int d=0;
      int a_i = 0;
      int b_i = 0;
      for(int i = 1;i<=l;i++){
          if(i<=a.length()){
              a_i = (int) a.charAt(a.length()-i) - 48;
          }else{
              a_i = 0;
          }
          if(i<=b.length()){
              b_i = (int) b.charAt(b.length()-i) - 48;
          }else{
              b_i = 0;
          }
          int sum = a_i+b_i+d;
          switch(sum){
              case 0:
              str.insert(0,'0');
              d=0;
              break;
              case 1:
              str.insert(0,'1');
              d=0;
              break;
              case 2:
              str.insert(0,'0');
              d=1;
              break;
              case 3:
              str.insert(0,'1');
              d=1;
              break;
          }
      }
      if(d==1){
          str.insert(0,'1');
      }
      return str.toString();
  }
}