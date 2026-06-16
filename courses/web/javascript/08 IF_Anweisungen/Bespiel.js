const button= document.getElementById("but");
button.onclick = sayHallo;
function sayHallo(){
    const vorname= document.getElementById("name").value;
    if(vorname ==""){
        window.alert("Bitte Namen eingeben!");
    }
    else{
        window.alert("Hallo" + vorname);
    }
}

// button.addEventListener("click", sayHallo);
// button.addEventListener("click", function sayHallo(){
 const vorname= document.getElementById("name").value;
if(vorname ==""){
    window.alert("Bitte Namen eingeben!");
}
else{
    window.alert("Hallo" + vorname);

}
// });       
