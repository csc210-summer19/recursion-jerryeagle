import java.util.Arrays;

/**
 * Complete the seven methods methods in this file using recursion, no loops.
 * Also complete these three methods inside LinkedList<E>: get(int) removeAll(E)
 * duplicateAll(E)
 * 
 * Also complete one method in ObstacleCourse that uses recursive backtracking.
 * findExit(int, int)
 * 
 * Note: I believe the given unit test tests all methods. We will be using this
 * same for for correctness of code.
 * 
 * We will not be using code coverage for points.
 *
 * @author Rick Mercer and Gerardo Aguilar
 */
public class RecursionFun {

	// Complete recursive method combinations that returns from n choose k.
	// This method is described in 17_SimpleRecursion.pptx.
	public int combinations(int n, int k) {
		if (k == 0 || n == k) {
			return 1;
		}
		return combinations(n - 1, k) + combinations(n - 1, k - 1);
	}

	// Complete recursive method intWithCommas that returns the argument as a
	// String
	// with commas in the correct places.
	//
	// intWithCommas(999) returns "999"
	// intWithCommas(1234) returns "1,234"
	// intWithCommas(1007) returns "1,007"
	// intWithCommas(1023004567) returns "1,023,004,567"
	//
	// Precondition: n >= 0
	public String intWithCommas(int n) {
		return "";
	}

	// Write recursive method reverseArray that reverses the array elements in a
	// filled array of ints. Use recursion; do not use a loop. The following
	// assertions must pass:
	//
	// int[] a = { 2, 4, 6 };
	// rf.reverseArray(a);
	// assertEquals(6, a[0]);
	// assertEquals(4, a[1]);
	// assertEquals(2, a[2]);
	//
	// Precondition: x.length > 0
	public void reverseArray(int[] x) {
		// You need a private helper that needs additional arguments.
		// like x and x.length to keep track of array the indexes
		// with no loop. Here is an example with the private helper
		// immediately below.
		reverseArray(x, 0, x.length-1);
	}

	private void reverseArray(int[] x, int index, int len) {
		// TODO: Complete this method with a recursive algorithm.
		// Do NOT use a loop.
		if(index == len-len/2) {
			return;
		}
		int temp = x[index];
		
		x[index] = x[len-index];
		x[len-index] = temp;
		
		reverseArray(x, index + 1, len);
		
	}

	// Write recursive method arrayRange that returns the maximum
	// integer minus the minimum integer in the filled array of
	// integers, Use recursion; do not use a loop.
	// Precondition: a.length > 0
	public int arrayRange(int[] a) {
		if(a.length < 2) {
			return 0;
		}
		int temp = Integer.min(a[0], a[1]);
		
		a[1] = Integer.max(a[0], a[1]);
		a[0] = temp;
		
		if(a.length == 2){
			return Integer.max(a[0], a[1]) - Integer.min(a[0], a[1]);
		}
		if(a[0] > a[2]) {
			a[0] = a[2];
		}
		if(a[1] < a[2]) {
			a[1] = a[2];
		}
		return arrayRange(Arrays.copyOfRange(a, 0, a.length-1));
	}

	// Return true if nums has all int elements in ascending order.
	// If not isSorted, return false.
	public boolean isSorted(int[] nums) {
		if (nums.length < 2) {
			return true;
		}
		if (nums[0] <= nums[1]) {
			if (nums.length == 2) {
				return true;
			}
			nums = Arrays.copyOfRange(nums, 1, nums.length);
			return isSorted(nums);
		}
		return false;
	}

	// Complete method found to return true if search is found in strs.
	// If not found, return false. Use equals, not ==.
	public boolean found(String search, String[] strs) {
		if (strs.length == 0) {
			return false;
		}
		if (search.equals(strs[0])) {
			return true;
		}
		strs = Arrays.copyOfRange(strs, 1, strs.length);
		return found(search, strs);
	}
}
