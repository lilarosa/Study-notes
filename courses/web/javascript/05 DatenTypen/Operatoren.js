let zahl1 = 5;
let zahl2 = 3;
 
let addition = zahl1 + zahl2;
console.log("5 + 3 = " + addition);
 
let subtraktion = zahl1 - zahl2;
console.log("5 - 3 = " + subtraktion);
 
let multiplikation = zahl1 * zahl2;
console.log("5 * 3 = " + multiplikation);
 
let division = zahl1 / zahl2;
console.log("5 / 3 = " + division);
 
//modulo
let modulo = zahl1 % zahl2;
console.log("5 % 3 = " + modulo);
// logische Operatoren

console.log(zahl1 == zahl2); // false
console.log(zahl1 != zahl2); // true
console.log(6+4==7+3); // true
 //false
console.log(zahl1 != zahl2);  //true

// && und || Operatoren
let ausdrck1= true;
let ausdrck2= false;

console.log("logische Operatoren");
console.log(ausdrck1 || ausdrck2); // true
console.log(ausdrck1 && ausdrck2); // false

// Spread Operator
function split(x){
    console.log(...x);
}
split('hallo');

// Array kopieren
let arr1 = [1,2,3];
let arr2 = [4,5,6]; 
let arr3 = [...arr1, ...arr2];
console.log(arr3); // [1,2,3,4,5,6]

// Objekt kopieren
let obj1 = {name: 'Max', alter: 22};
let obj2 = {...obj1};
console.log(obj2); // {name: 'Max', alter: 22}
obj2.name = 'Moritz';
console.log(obj1); // {name: 'Max', alter: 22}
console.log(obj2); // {name: 'Moritz', alter: 22}

// Objekt zusammenfügen
let obj3 = {job: 'Entwickler'};
let obj4 = {...obj1, ...obj3};
console.log(obj4); // {name: 'Max', alter: 22, job: 'Entwickler'}   

// Exponentiation
let basis = 2;  
let exponent = 3;
let ergebnis = basis ** exponent; // 2^3 = 8
console.log(ergebnis); // 8

// Kurzschreibweise für Addition
let zahl = 5;   
zahl += 3; // zahl = zahl + 3
console.log(zahl); // 8