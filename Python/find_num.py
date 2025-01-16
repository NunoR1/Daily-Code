# •Generate a list of random size between 1 and 15, inclusive
# •Populate that list with all numbers in the list size included (not including 0)
# •Example: if the list is size 5, the list should be [1, 2, 3, 4, 5]
# •Remove a random number from that list
# •Print the list with the random number removed
# •Write a function that will iterate through the list, determine the missing number, and add it back to the list
# •Your code MUST determine which number is missing without using whatever mechanism you used to remove the number
# •Print the list with the number added back in
# •The list must be in order

import random as r

list_size = r.randint(1, 15)

num_list = []

for i in range(list_size):
    num_list.append(i + 1)

num_list.remove(r.randint(1, len(num_list)))

print(num_list)

def whatsThatNum(the_list):
    found_check = False
    for i in range(len(the_list)):
        if (the_list[i] == i + 1):
            continue
        else:
            the_list.insert(i, i + 1)
            found_check = True

    if found_check != True:
        the_list.append(len(the_list) + 1)
    
    return the_list

print(whatsThatNum(num_list))
