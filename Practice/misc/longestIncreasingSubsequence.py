# Program to find the Longest Increasing Subsequence in a list
def longestIncreasingSubsequence(arr):
    longest = []
    for i in range(len(arr)):
        if(arr[i] not in longest):
            temp = getSubsequence(arr, i)
        if(len(temp) > len(longest)):
            longest = temp
    return longest


def getSubsequence(arr, i):
    sub = [arr[i]]
    indexSub = 0
    for j in range(i + 1, len(arr)):
        if(arr[j] > sub[indexSub]):
            sub.append(arr[j])
            indexSub = indexSub + 1
    return sub


arr = [9, 21, 8, 32, 20, 49, 40, 60, 70]

print(longestIncreasingSubsequence(arr))
