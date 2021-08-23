from typing import List

class Solution:
    '''
    @description :多数求和                     
    @param  :     nums       数组
    @param  :     n_in       n个数字
    @param  :     target_in     和的值  
	@Returns  : 
    '''
    def threeSum(self, nums: List[int], n_in: int, target_in: int):
        def nSum(nums: List[int], n: int, target: int):
            res = []
            if len(nums) < n:
                return res
            if n == 2:
                left, right = 0, len(nums) - 1
                while left < right:
                    if nums[left] + nums[right] == target:
                        res.append([nums[left], nums[right]])
                        while left < right and nums[left] == nums[left+1]:
                            left += 1
                        while left < right and nums[right] == nums[right-1]:
                            right -= 1
                        left += 1
                        right -= 1
                    elif nums[left] + nums[right] < target:
                        left += 1
                    else:
                        right -= 1
                return res
            else:
                for i in range(len(nums)-n+1):
                    if i > 0 and nums[i] == nums[i-1]:
                        continue
                    min_sum = sum(nums[i:i+n])
                    if min_sum > target:
                        break
                    max_sum = nums[i] + sum(nums[-n+1:])
                    if max_sum < target:
                        continue
                    sub_res = nSum(nums[i+1:], n-1, target-nums[i])
                    for j in range(len(sub_res)):
                        res.append([nums[i]]+sub_res[j])
                return res
        nums.sort()
        res = nSum(nums, n_in, target_in)
        # res = nSum(nums, 3, 4)
        return res
# 输入
aList = list((0,1,2,3,4,5,6,7,8,9,10,-1,-2))#数组
n_in =3#n个数字
target_in = 6#和的值

solution= Solution()
resultArrays = solution.threeSum(aList,n_in,target_in)
print(resultArrays)
        