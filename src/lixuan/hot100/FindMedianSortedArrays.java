package lixuan.hot100;

public class FindMedianSortedArrays {
    /**
     * 每次去掉k/2个元素
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;
        return (findK(nums1, 0, nums2, 0, left) + findK(nums1, 0, nums2, 0, right)) * 0.5;
    }

    private double findK(int[] nums1, int i, int[] nums2, int j, int k) {
        if (i >= nums1.length) return nums2[j + k - 1];
        if (j >= nums2.length) return nums1[i + k - 1];
        if (k == 1) {
            return Math.min(nums1[0], nums2[0]);
        }

        int mid1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int mid2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
        if (mid1 < mid2) {
            return findK(nums1, i + k / 2, nums2, j, k - k / 2);
        } else {
            return findK(nums1, i, nums2, j + k / 2, k - k / 2);
        }
    }
}
