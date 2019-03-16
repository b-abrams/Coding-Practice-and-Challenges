function solution(arr) {
  if (arr.length == 0 || arr.length == 1) return 0;
  mid = Math.floor(arr.length / 2);
  if (
    (arr[0] < arr[mid] && arr[mid] > arr[arr.length - 1]) ||
    (arr[0] < arr[mid] && arr[mid] > arr[arr.length - 1])
  )
    return recurse(arr, mid, arr.length - 1);
  else if (
    (arr[0] > arr[mid] && arr[mid] < arr[arr.length - 1]) ||
    (arr[0] > arr[mid] && arr[mid] < arr[arr.length - 1])
  )
    return recurse(arr, 0, mid);
  return 0;
}

function recurse(arr, start, end) {
  mid = start + Math.floor((end - start) / 2);
  if (arr[start] > arr[end])
    if (mid - start == 1 && arr[start] > arr[mid]) return start + 1;
    else if (mid - start == 1 && arr[start] < arr[mid]) return mid + 1;
    else return recurse(arr, 0, mid);
  else if (end - mid == 1 && arr[end] < arr[mid]) return end + 1;
  else if (end - mid == 1 && arr[end] > arr[mid]) return mid + 1;
  else return recurse(arr, mid, end);
}

console.log(`Index: ${solution([2, 3, 4, 5, 1])}`);
