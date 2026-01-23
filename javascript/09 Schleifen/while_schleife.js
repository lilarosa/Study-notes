let i=0;
while(i<5){
    console.log(i);
    i++;
}
console.log("---------------");
let x=0;
while(x<5){
    x++;
    // i=1,2,3,4,5
    console.log(x);
}
// Summe aller Zahlen bilden (1+2+3+4+5+....) aber nur Bis die Summe den Wert 36 erreicht
console.log("---------------");
let sum=0;
let y=0;
while (sum<36){
    sum += y;
    y++;
    console.log("für y =" + y + " ist die Summe:" + sum);
}
console.log("---------------");
let sumX=0;
let j=1;
while (sumX<=36){
    console.log("für j =" + j + " ist die Summe:" + sumX);
    sumX += j;
    j++;
    
}