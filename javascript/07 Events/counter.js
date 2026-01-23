let count = 0;

function incrementCount() {
    count= Number(localStorage.getItem("zaehler"));
    document.getElementById("ausgabe").innerText = count;
    localStorage.setItem("zaehler", count + 1);

}

window.onload = incrementCount();

// window.addEventListener("load", incrementCount);
// localStorage.clear();

const butReset= document.getElementById("butReset");
butReset.onclick= resetCounter;
function resetCounter(){
    localStorage.clear();
    count=0;
    incrementCount();
}

butReset.addEventListener("click", resetCounter);
// butReset.addEventListener("click", function(){
