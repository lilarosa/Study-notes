
// Aufgabe 1:
Wochentage=["Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag", "Samstag", "Sonntag"];
console.log(Wochentage[2]); // Ausgabe: Mittwoch
Wochentage.push("Dienstag"); // Fügt "Dienstag" am Ende des Arrays hinzu
console.log(Wochentage); 
Wochentage.pop(); // Entfernt das letzte Element des Arrays
console.log(Wochentage); 

// delete Wochentage[Wochentage.length-1]; // Entfernt den Wert von das Letzte Element des Arrays
// console.log(Wochentage); // Ausgabe: Montag, Dienstag, Donnerstag, Freitag, Samstag, Sonntag



for(let i=0; i<Wochentage.length; i++){
    console.log("Element " + (i+1) + ": " + Wochentage[i]);
}


console.log("Aufgabe3");
// Aufgabe 3:
    let  zahlen= [1, 3, 48, 56, 78, 90, 100, 45.87,120, 150, 200];
    let summe=0;
    for( let i = 0; i<zahlen.length; i++){
        summe+= zahlen[i];}
        console.log("Summe: " + summe);
        let drchschnitt= summe/ zahlen.length;
        console.log("Durchschnitt: " + drchschnitt.toFixed(2)); // toFixed(2) rundet auf 2 Dezimalstellen

    


