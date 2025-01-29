def palindromes():
    og = input("Input a word:\n").lower() # immediately makes the user input format uniform
    new = og.split() # make it a list to remove spaces
    new = "".join(new) # make it a string again
    if new[::-1] == new: # compare the flipped version of the string to the original
        print(f"{og.title()} is a palindrome") # if true
    else:
        print(f"{og.title()} is not a palindrome") # if false


palindromes()