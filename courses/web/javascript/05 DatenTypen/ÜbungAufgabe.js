let zahl1=3;
let zahl2=5;
const addition= zahl1+zahl2;
console.log("Addition: " + addition);

zahl1=28;
zahl2=12;
const subtraktion= zahl1-zahl2;
console.log("subtraktion:"+ subtraktion);

let produkt= addition*subtraktion;
console.log("produkt:" + produkt);

let division= produkt/4;
console.log("division:" + division);

// Aufgabe2:

let digit= 12.54321;
let rund= digit.toFixed(3);
console.log("gerundet auf 3 Nachkommastellen: " + rund);

// Aufgabe 3:

let text="code";
let test=isNaN(text);
console.log("ist NaN: " + test);
console.log(isNaN(text));