const fullName= document.getElementById
("name");
fullName.innerText="Peter Pan";

const job= document.getElementById
("job");
job.innerText="Softwareentwickler";

const job = document.getElementById("job");
job.innerText = "Webentwickler";
 
const telephone = document.getElementById("tel");
telephone.innerText = "+49 123 456789";
 
const email = document.getElementById("mail");
email.innerText = "meineemailadresse@emailadresse";

Option1:

// const jobNew=document.createElement("span");
// jobText=document.createTextNode("Softwareentwickler");
// jobNew.appendChild(jobText);
// const container= document.getElementById("job");
// container.appendChild(jobNew);


Option2:

 // Recommand add a span tag directly in the HTML file and use it to add the text.
 
// <p id="job">
//     Beruf: <span id="jobText"></span>
// </p>
// document.getElementById("jobText").innerText = "Softwareentwickler";