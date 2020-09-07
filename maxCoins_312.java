import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*未完成 */
public class maxCoins_312 {
  public static void main(String[] args) {
    maxCoins_312 t = new maxCoins_312();
    int[] a = {3,1,5,8};
    System.out.println(t.maxCoins(a));
  }

  public int maxCoins(int[] nums) {
    List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
    int res = 0;
    while (numList.size() > 0) {
      res = res + this.compute(numList);
    }
    return 0;
  }

  private int compute(List<Integer> numList) {
    int max = 0;
    int maxIndex = 0;
    if (numList.get(1) > numList.get(numList.size() - 2)) {
      max = numList.get(0);
      maxIndex = 0;
    } else {
      max = numList.get(numList.size() - 1);
      maxIndex = numList.size() - 1;
    }
    for (int i = 1; i < numList.size() - 1; i++) {
      int l = numList.get(i - 1);
      int r = numList.get(i + 1);
      if (l * r > max) {
        max = l * r;
        maxIndex = i;
      }
    }
    max = numList.get(maxIndex)*max;
    numList.remove(maxIndex);
    return max;
  }
}