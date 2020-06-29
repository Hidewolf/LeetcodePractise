import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class findKthLargest_215 {
  public static void main(String[] args) {
    findKthLargest_215 t = new findKthLargest_215();
    int[] nums = { 3,3,3,3,3,3,3,3,3 };
    System.out.println(t.findKthLargest(nums, 8));
  }

  public int findKthLargest(int[] nums, int k) {
    return this.findKey(nums, k);
  }

  private int findKey(int[] nums, int k) {
    int key = nums[0];
    List<Integer> nums_less = new ArrayList();
    List<Integer> nums_large = new ArrayList();
    List<Integer> nums_same = new ArrayList();
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] < key) {
        nums_less.add(nums[i]);
      } else if (nums[i] > key) {
        nums_large.add(nums[i]);
      } else if (nums[i] == key) {
        nums_same.add(nums[i]);
      }
    }

    int less_length = nums_less.size();
    int large_length = nums_large.size();
    int same_length = nums_same.size();

    if (large_length == k - 1 || large_length + same_length == k - 1) {
      return key;
    } else if (large_length > k - 1) {
      return this.findKey(nums_large.stream().mapToInt(Integer::valueOf).toArray(), k);
    } else if (large_length < k - 1) {
      nums_same.add(key);
      nums_less.addAll(nums_same);
      return this.findKey(nums_less.stream().mapToInt(Integer::valueOf).toArray(), k - large_length);
    } else if (large_length + same_length > k - 1) {
      nums_large.addAll(nums_same);
      nums_same.add(key);
      return this.findKey(nums_large.stream().mapToInt(Integer::valueOf).toArray(), k);
    } else if (large_length + same_length < k - 1) {
      return this.findKey(nums_large.stream().mapToInt(Integer::valueOf).toArray(), k - large_length - same_length);
    } else {
      nums_less.addAll(nums_same);
      nums_less.add(key);
      nums_less.addAll(nums_large);
      nums_less.sort(Comparator.comparingInt(Integer::intValue).reversed());
      return nums_less.get(k);
    }
  }
}