public class isSubsequence_392 {
  public boolean isSubsequence(String s, String t) {
    char[] sc = s.toCharArray();
    char[] tc = t.toCharArray();
    int j = 0;
    for (int i = 0; i < sc.length; i++) {
      for (; j < tc.length; j++) {
        if(sc[i]==tc[j]){
          if(i==sc.length-1){
            return true;
          }
          break;
        }
      }
    }
    return false;
  }
}