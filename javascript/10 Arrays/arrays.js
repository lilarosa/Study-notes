// ein array von strings
let fruits=["Apple", "Banana", "Cherry", "Date", "Elderberry"];
console.log(fruits);
// Zugriff auf ein Element im Array über den Index
console.log(fruits[0]); // "Apple"
console.log(fruits[2]); // "Cherry"

fruits[0]="Avocado"; // Ändern des ersten Elements
console.log(fruits[0]); // "Avocado"

// Ein Array von zahlen
let numbers=[1, 2, 3, 4, 5];
console.log(numbers);
 let gemischteArray=["Apple", 42, true, null, undefined, {name: "John"}, [1, 2, 3]];
//  Achtung!! Nicht in anderen Programmiersprachen möglich

numbers[4]=10; // Achtung!! Nur JavaScript
console.log(numbers[4]); // 10

// Wert am Ende des Arrays hinzufügen
fruits.push("Fig");
numbers.push(6); // Hinzufügen einer Zahl
console.log(fruits); // ["Avocado", "Banana", "Cherry", "Date", "Elderberry", "Fig"]
console.log(numbers); // [1, 2, 3, 4, 10, 6]

// Wert am Ende des Arrays entfernen
let letztesElement = fruits.pop(); // Entfernen des letzten Elements und speichern in einer Variable
console.log("Das letzte Element war: " + letztesElement); // "Fig"
console.log('Das letzte Element war: ${letztesElement}'); // "Fig"

// Elemente löschen über den Index
let entferntesElement = numbers.splice(2); // Entfernt das Element ab Index 2 (dritte Position)
console.log(entferntesElement); // [3]

// numbers.splice(1,1); löscht ab position 1 ein Eelement
// the first 1 means from which position to delete, the second 1 means how many elements to delete
// numbers.splice(1, 2); löscht ab position 1 zwei Elemente
console.log(numbers); // [1, 2, 4, 10, 6]

delete numbers[1]; // Löscht das Element an Index 1 (zweite Position)
console.log(numbers); // [1, undefined, 4, 10, 6] (das Element ist jetzt undefined)

// Array durchlaufen mit for-Schleife
for (let i=0; i< numbers.length; i++){
    console.log("Element an Index "+ i + ": " + numbers[i]);
}

// Array durchlaufen mit forEach-Methode
numbers.forEach(function(element, index) {
    console.log("Element an Index " + index + ": " + element);
});

// Array durchlaufen mit for-of-Schleife
for (let element of numbers) {
    console.log("Element: " + element);
}   
// Array Rückwärt ausgeben
for (let i = numbers.length - 1; i >= 0; i--) {
    console.log("Element rückwärts an Index " + i + ": " + numbers[i]);
}