public class GroupSum{
    private int start;
    private int [] nums;
    private int target;
    private static boolean GroupSum(int start, int[] nums, int target)
    {
        if (start>=nums.length) {
            return target == 0;
        }else{
            return GroupSum(start + 1, nums, target - nums[start]) || GroupSum(start+1, nums, target);
        }
    }

    public static boolean GroupSum(int[] nums,int target)
    {
        return GroupSum(0, nums, target);
    }
}