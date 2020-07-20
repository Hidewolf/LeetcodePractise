import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class intersect_350 {
  public static void main(String[] args) {
    intersect_350 t = new intersect_350();
    int[] a = {4,9,5};
    int[] b = {9,4,9,8,4};
    System.out.println(t.intersect(a,b));
  }
  public int[] intersect(int[] nums1, int[] nums2) {
    List<Integer> res = new ArrayList<>();

    Map<Integer, Integer> m1 = new HashMap<>();

    for (int i = 0; i < nums1.length; i++) {
      if (m1.containsKey(nums1[i])) {
        m1.replace(nums1[i], m1.get(nums1[i]) + 1);
      } else {
        m1.put(nums1[i], 1);
      }
    }

    for (int i = 0; i < nums2.length; i++) {
      int key = nums2[i];
      if (m1.containsKey(key)) {
          res.add(key);
          m1.replace(key, m1.get(key) - 1);
          if(m1.get(key)==0){
            m1.remove(key);
          }
      }
    }

    return  res.stream().mapToInt(Integer::valueOf).toArray();
  }
}