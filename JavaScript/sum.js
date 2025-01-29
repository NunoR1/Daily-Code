let numbers = prompt("Enter a string of numbers: "); // prompt user

function sum(numArray) { // make function that take array as an argument (I'll explain why later)
    let total = 0 // immediately set the total to 0
    for (let i = 0; i < numArray.length; i++) { // create for loop that iterates through the list
        total += parseInt(numArray[i]); // covert each item of the list into a integer and then adds it to the total
    }
    return total // return total
}

alert(sum(numbers.split(""))); // split the user input into an array of each character, pass it through the function and alert the user of the total