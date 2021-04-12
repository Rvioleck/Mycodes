package LeetCode_JAVA.Sort_Algorithm;

public class MinNumber {

    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < strs.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
//        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        quickSort(strs, 0, strs.length - 1);
        StringBuilder res = new StringBuilder();
        for (String str : strs) {
            res.append(str);
        }
        return res.toString();
    }

    private void quickSort(String[] strs, int left, int right) {
        if (left >= right) return;
        String pivot = strs[left];
        int i = left, j = right;
        while (i < j) {
            while (i < j && (strs[j] + pivot).compareTo(pivot + strs[j]) >= 0) {
                j--;
            }
            strs[i] = strs[j];
            while (i < j && (strs[i] + pivot).compareTo(pivot + strs[i]) <= 0) {
                i++;
            }
            strs[j] = strs[i];
        }
        strs[i] = pivot;
        quickSort(strs, left, i - 1);
        quickSort(strs, i + 1, right);
    }


}
