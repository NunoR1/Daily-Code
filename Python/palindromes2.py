def palindromes():
    og = input("Input a word:\n").lower()
    new = og.split()
    new = "".join(new)
    if new[::-1] == new:
        print(f"{og.title()} is a palindrome")
    else:
        print(f"{og.title()} is not a palindrome")


palindromes()