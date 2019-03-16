// Porgram to return the number of unique absolute values in a list

function unique(A) {
  let solution = [];
  for (let i = 0; i < A.length; i++) {
    if (A[i] < 0) {
      A[i] *= -1;
    }
    if (solution.indexOf(A[i]) == -1) {
      solution.push(A[i]);
    }
  }
  return solution.length;
}

function unique2(A) {
  let left = 0;
  let right = A.length - 1;
  while (right - left > 0) {
    if (left > 0 && Math.abs(A[left]) == Math.abs(A[left - 1])) {
      A.splice(left, 1);
    }
    if (right < A.length - 1 && Math.abs(A[right]) == Math.abs(A[right + 1])) {
      A.splice(right, 1);
    }
    if (Math.abs(A[left]) == Math.abs(A[right])) {
      A.splice(left, 1);
    }
    if (Math.abs(A[left]) < Math.abs(A[right])) {
      right -= 1;
    } else if (Math.abs(A[left]) > Math.abs(A[right])) {
      left += 1;
    }
  }
  return A.length;
}

const A = [-5, -5, -5, -3, -1, 0, 3, 5, 5, 5, 6];
console.log(unique2(A));
