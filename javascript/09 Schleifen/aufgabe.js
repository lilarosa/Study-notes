Aufgabe 1:

 const age =30;

 function checkAge(){
    if (age >= 18){

        window.alert("Du bist volljährig");
    }
    else{
        window.alert("Du bist minderjägrig");
    }
 }

 Aufgabe 2:

 const ampelFarbre = "green";
  function checkAmpel(){
    if(ampelFarbre == "rot"){
        console.log("Stopp");
    }
    else if(ampelFarbre == "gelb"){
        console.log("Vorsicht");
    }
    else if(ampelFarbre == "grün"){
        console.log("Gute Fahrt");
    }
    else{
        console.log("Die Ampel ist ausgeschaltet");
    }
  }