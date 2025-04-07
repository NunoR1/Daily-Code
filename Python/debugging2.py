def simple_calculator(expression):
    """
    Evaluates basic math expressions with order of operations.
    Only handles +, -, *, / and non-negative integers.
    Example: simple_calculator("2+3*4") should return 14
    """
    # Remove spaces
    expression = expression.replace(" ", "") # remove spaces
    
    # First handle multiplication and division (left to right)
    i = 0
    while i < len(expression):
        if expression[i] in "*/":
            # Find left number
            left_end = i - 1
            left_start = left_end
            while left_start > 0 and expression[left_start-1].isdigit():
                left_start -= 1
            left_num = int(expression[left_start:left_end+1])

            
            # Find right number
            right_start = i + 1
            right_end = right_start
            while right_end < len(expression) - 1 and expression[right_end+1].isdigit():
                right_end += 1
            right_num = int(expression[right_start:right_end+1])

            
            # Calculate result
            if expression[i] == "*":
                result = left_num * right_num

            else:
                result = left_num / right_num
                print(result)
                
            # Replace in expression
            expression = expression[:left_start] + str(result) + expression[right_end+1:]
            print(expression)
            i = 0  # Start over with the new expression
        else:
            i += 1
    
    # Then handle addition and subtraction
    result = 0
    i = 0
    current_num = 0
    operation = "+"
    
    while i < len(expression):
        if expression[i].isdigit():
            current_num = current_num * 10 + int(expression[i])
        elif expression[i] in "+-":
            # Apply previous operation
            if operation == "+":
                result += current_num
            else:
                result -= current_num
            
            # Reset for next operation
            current_num = 0
            operation = expression[i]
        
        i += 1
    
    # Apply the last operation
    if operation == "+":
        result += current_num
    else:
        result -= current_num
        
    return result
 
# Test cases
tests = ["2+3*4", "10-5+2", "8/4+1", "5*2-3/3"]
for test in tests:
    print(f"{test} = {simple_calculator(test)}")