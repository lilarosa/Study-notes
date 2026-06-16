// Funktiondefinition
function hallo(){
    console.log("Hallo");
}

hallo();


// Funktion mit Parameter


function halloPersonal(name, gender){
 console.log(`${name} ${gender} Wie geht es dir?`);
}

halloPersonal("Herr", "Peter");


// Rücjkgabe von Werten

function berechneProdukt(zahl1, zahl2){
    const produkt= zahl1 * zahl2;
    return produkt;
}
 const ergebnis= berechneProdukt(5, 3);
    console.log(ergebnis);
    console.log(berechneProdukt(5, 3));

// Funktion mit Rückgabewert und Parameter
function berechneSumme(zahl1, zahl2){
    const summe= zahl1 + zahl2;
    return summe;
}
const ergebnis2= berechneSumme(5, 3);
console.log(ergebnis);
console.log(berechneSumme(5, 3));

// anonyme Funktion (function speichern in einer Variable)
let produkt= function(x,y){
    return x*y;
}
console.log(produkt(5,3));

// Arrow Funktion (kurze Schreibweise für kurze Funktionen sehr praktisch für Callback-Funktionen)

let produkt2=(x,y)=> x*y;
console.log(produkt2(5,3));

// Arrow Funktion mit mehreren Zeilen
let produkt3=(x,y)=>{
    let ergebnis= x*y;
    return ergebnis;
}
console.log(produkt3(5,3));
// callback-Funktion (Funktion als Parameter übergeben)
function sageHallo(text, myCallback){
    console.log(text);
    myCallback();
}
sageHallo("Hallo", hallo);

