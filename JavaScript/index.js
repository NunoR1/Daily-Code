let numbers = prompt("Enter a string of numbers: ");

function sum(numArray) {
    let total = 0
    for (let i = 0; i < numArray.length; i++) {
        total += parseInt(numArray[i]);
    }
    return total
}

alert(sum(numbers.split("")));