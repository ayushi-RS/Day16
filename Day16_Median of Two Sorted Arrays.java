class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        if (totalLength % 2 == 0) {
            return (this.getKth(nums1, nums2, totalLength/2) + this.getKth(nums1, nums2, totalLength/2 + 1)) / 2;
        } else {
            return this.getKth(nums1, nums2, totalLength/2 + 1);
        }
    }
    
    private double getKth(int[] nums1, int[] nums2, int k) {
        int start1 = 0;
        int start2 = 0;
        while (true) {
            if (start1 >= nums1.length) {
                return nums2[start2 + k - 1];
            } else if (start2 >= nums2.length) {
                return nums1[start1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[start1], nums2[start2]);
            }

            int mid1 = Math.max(nums1[nums1.length - 1], nums2[nums2.length - 1]);
            if (start1 + k/2 -1 < nums1.length) {
                mid1 = nums1[start1 + k/2 - 1];
            }
            int mid2 = Math.max(nums1[nums1.length - 1], nums2[nums2.length - 1]);
            if (start2 + k/2 - 1 < nums2.length) {
                mid2 = nums2[start2 + k/2 - 1];
            }
            if (mid1 < mid2) {
                start1 += k/2;
            } else {
                start2 += k/2;
            }
            k -= k/2;
        }
        
    }
}