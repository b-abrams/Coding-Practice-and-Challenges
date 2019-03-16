import math


def function(arr):
    if(type(arr) is not list):
        return
    if(len(arr) == 0 or len(arr) == 1):
        return 0
    mid = math.floor(len(arr) / 2)
    if((arr[0] < arr[mid] and arr[mid] > arr[len(arr) - 1]) or (arr[0] < arr[mid] and arr[mid] > arr[len(arr) - 1])):
        return recurse(arr, mid, len(arr) - 1)
    elif(arr[0] > arr[mid] and arr[mid] < arr[len(arr) - 1] or (arr[0] > arr[mid] and arr[mid] < arr[len(arr) - 1])):
        return recurse(arr, 0, mid)
    return 0


def recurse(arr, start, end):
    mid = start + math.floor((end - start) / 2)
    if(arr[start] > arr[end]):
        if(mid - start == 1 and arr[start] > arr[mid]):
            return start + 1
        elif(mid - start == 1 and arr[start] < arr[mid]):
            return mid + 1
        else:
            return recurse(arr, 0, mid)
    else:
        if(end - mid == 1 and arr[end] < arr[mid]):
            return end + 1
        elif(end - mid == 1 and arr[end] > arr[mid]):
            return mid + 1
        else:
            return recurse(arr, mid, end)


print("Index: ", function([4, 5, 1, 2, 3]))
