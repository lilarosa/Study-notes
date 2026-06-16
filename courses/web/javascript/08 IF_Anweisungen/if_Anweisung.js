const number= 2;

if (number > 5){
console.log("Die Zahl ist größer als 5");
}

else if (number < 5){
    console.log("Die Zahl ist kleiner als 5");
}
else {
    console.log("Die zahl ist gleich als 5");

}

// veraltete Methode
const nachricht= number > 5 ? "Die Zahl ist größer als 5" : "Die Zahl ist kleiner oder gleich 5";
console.log(nachricht);
 