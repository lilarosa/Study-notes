// Ausgabe der Zahlen 0 bis 9

for(let i=0; i< 10; i++){

    console.log(i);
    // Ausgabe der Zahlen 0 bis 9
    // i=0,1,2,3,4,5,6,7,8,9
    // i=10
    // Schleife wird abgebrochen
    // i=10 ist nicht kleiner als 10
}

// Ausgabe der Zahle von 5 - 12
console.log("---------------");
for (let i=5; i<13; i++){

    console.log(i);
    // i=5,6,7,8,9,10,11,12
    // i=13
    // Schleife wird abgebrochen
    // i=13 ist nicht kleiner als 13
}
console.log("---------------");
for (let i=20; i>10; i--){
    console.log(i);
    // i=20,19,18,17,16,15,14,13,12,11
    // i=10
    // Schleife wird abgebrochen
    // i=10 ist nicht größer als 10
}
console.log("---------------");
for (let i=2; i<20; i=i+2){
    console.log(i);
    // i=0,2,4,6,8,10,12,14,16,18
    // i=20
    // Schleife wird abgebrochen
    // i=20 ist nicht kleiner als 20
}
console.log("---------------");
let sum = 0;
for (let i=0; i<10; i++){
    sum += i;
    console.log("sum=" + sum); 
    // sum=0,1,3,6,10,15,21,28,36,45
    // sum=55
    // Schleife wird abgebrochen
    // i=10 ist nicht kleiner als 10
}
