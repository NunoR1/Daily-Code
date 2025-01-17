let num = document.getElementById("num");
let check = document.getElementById("check");

function findPrime(number) {
    if (number < 2) {
        alert(`${number} is not a prime number`)
    } else if (number == 2 || number == 3) {
        alert(`${number} is prime`)
    } else if ((number - 1) % 6 == 0 || (number + 1) % 6 == 0) {
        alert(`${number} is prime`)
    } else {
        alert(`${number} is not a prime number`)
    }
}

check.addEventListener("click", function() {
    findPrime(parseInt(num.value))
});