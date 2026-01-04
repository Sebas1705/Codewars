public class FindTheUniqueNumber {
    public static float findUniq(float[] nums){
        int n = nums.length;
        if (n==0) return 0.0f;
        if (n>=3){
            float common = (nums[0]==nums[1]||nums[0]==nums[2])?nums[0]:nums[1];
            for (float v: nums) if (v!=common) return v;
        } else {
            for (int i=0;i<n;i++){
                int cnt=0; for (int j=0;j<n;j++) if (nums[i]==nums[j]) cnt++;
                if (cnt==1) return nums[i];
            }
        }
        return 0.0f;
    }
    public static void main(String[] args){
        float[] arr = {1f,1f,1f,2f,1f};
        System.out.println("The unique number is: " + findUniq(arr));
    }
}
