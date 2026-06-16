// Varianten um Events  zu registrieren
// 1. Variante: Inline Event Handler

function logGeladen(){
    console.log("Das Dokument wurde geladen.");
}
window.onload = logGeladen;
 // wenn das fesnter fertig geladen ist, wird die
// Funktion logGeladen() aufgerufen

// 2. Variante: DOMContentLoaded Event

window.addEventListener("load", logGeladen);




