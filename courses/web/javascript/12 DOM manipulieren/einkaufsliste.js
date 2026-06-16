// Einkaufsliste mit DOM-Manipulation
const inputItem= document.getElementById("inputItem");
const btnAdd= document.getElementById("addItem");
const listItem= document.getElementById("itemList");

btnAdd.onclick = addItem;
function addItem(){
    let li= document.createElement("li");
    li.innerText=inputItem.value;
    listItem.appendChild(li);
    // ListItem duurchstreichbar machen
    li. style. cursor = "pointer";
    li.onclick = function() {
    
        // li.style.textDecoration = "line-through";
        // li.style.color = "red";

        li.classList.toggle("checked"); 

    }
  
    inputItem.value = ""; // Eingabe-Feld leeren
    };

    // Eingabe-Feld leeren
    inputItem.value = "";

    // Eingabe-Feld fokussieren
    inputItem.focus();   

inputItem.onkeydown = addItemEnter;
function addItemEnter(event){

    if(event.key=="Enter"){
        addItem();
    }   
    
    }

    const btnDelete= document.getElementById("clearList");
    btnDelete.onclick = clearListAll;
    function clearListAll(){
        listItem.innerHTML = "";
        
       
    }



