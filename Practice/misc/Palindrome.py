
word = input("Enter a word: \n")

def isPalendrome(word, left, right):
    if(word[left] != word[right]):
        return False
    elif((len(word) % 2 == 0 and left > right) or (len(word) % 2 != 0 and left == right)):
        return True
    left += 1
    right -= 1
    return isPalendrome(word, left, right)

print(isPalendrome(word, 0, len(word)-1))