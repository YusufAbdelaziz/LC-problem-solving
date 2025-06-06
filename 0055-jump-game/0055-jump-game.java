class Solution {
    public boolean canJump(int[] nums) {

        int n = nums.length;

        if (n == 0)
            return false;

        if (n == 1)
            return true;

        int i = 0;
        int curSteps = -1;
        while (i < n - 1 && curSteps != 0) {
            curSteps = nums[i];

            int bestReach = -1;
            int maxStepsIndex = i;

            for (int j = 1; j <= curSteps && j + i < n; j++) {
                int reach = (i + j) + nums[i + j];
                if (reach > bestReach) {
                    bestReach = reach;
                    maxStepsIndex = i + j;
                }
            }

            if (maxStepsIndex == i)
                return false;

            i = maxStepsIndex;
        }

        return i >= n - 1;
    }
}