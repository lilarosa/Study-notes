

// Aufgabe1

      let sum = 0;
      window.onload= function(){
        sum=2+2;
        console.log(sum);
    }

    
        // 'zu beobachten : Auch wenn der Variablen innerhalb der Funktion ein neuer Wert zugewiesen wird:
        // Außerhalb der Funktion ändert sich der Wert der Variablen nicht. Die Ausgabe in der Konsole ist
        // 0 und danach 4
        // Grund: an Zeile 21 kommt das Programm vor Zeile 18 an. Zeile 21 wird abgearbeitet bevor
        // die ganze Seite geladen ist. Zeile 18 wird erst aufgerufen, wenn die Seite vollständig geladen
        // wurde. Daher wird auch für Zeile 21 der Wert 0 ausgegeben und für Zeile 18 der Wert 4'
        

 option2
    window.addEventListener("load",function(){
        sum=2+2;
        console.log(sum);
    }
 )

//  Aufgabe2
 function logGeladen(){
    const forM = document.getElementById("formular");
    forM.addEventListener("load",function (){ 
        const loaded="Formular geladen";
        console.log(loaded);
    } );

 }

   