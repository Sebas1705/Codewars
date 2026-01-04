package p6_kyu_findtheuniquenumber

fun findUniq(nums: FloatArray): Float {
    val n = nums.size
    if (n == 0) return 0.0f

    if (n >= 3) {
        val common = if (nums[0] == nums[1] || nums[0] == nums[2]) nums[0] else nums[1]
        for (i in nums) if (i != common) return i
    } else {
        for (i in 0 until n) {
            var cnt = 0
            for (j in 0 until n) if (nums[i] == nums[j]) cnt++
            if (cnt == 1) return nums[i]
        }
    }
    return 0.0f
}

fun main() {
    val arr = floatArrayOf(1.0f, 1.0f, 1.0f, 2.0f, 1.0f)
    println("The unique number is: ${findUniq(arr)}")
}
