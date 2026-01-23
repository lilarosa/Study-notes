


// Aufgabe1

function quad(zahl){
    return zahl*zahl;
}

let num=5;
quad(num);
console.log(quad(num));

// Aufgabe2
// Option1
let fullName= function(firstName,lastName){
    return `${firstName} ${lastName}`;

}
let first= "Tao";
let last= "Wang";

console.log(fullName(first,last));


// option2
// function fullName(firstName,lastName){
//     return `${firstName} ${lastName}`;
// }
// let first=prompt("Geben Sie Ihren Vornamen ein:");
// let last=prompt("Geben Sie Ihren Nachnamen ein:");
// consosle.log(fullName(first,last));


// Aufgabe3

let personAge=(name, year,callback)=>
     callback(name, year);



function printAge(name,year){
    const old= 2025-year;
    const message=`${name} ist ${old} Jahre alt.`;
    return message;

}

let me="Tao";
let Geburtsjahr=1985;
console.log(personAge(me,Geburtsjahr,printAge
));