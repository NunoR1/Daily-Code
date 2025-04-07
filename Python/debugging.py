def average_even_numbers(numbers):
    sum = 0
    count = 0
    
    for i in range(0, len(numbers)):
        if numbers[i] % 2 == 0: # =
            sum += numbers[i]
            count += 1
    
    if count == 0:
        return 0.0

    average = sum/count
    
    return round(average, 2)
 
# Test the function with the list: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
result = average_even_numbers([0, 1, 3, 5, 7, 9])
print("The average of even numbers is:", result)