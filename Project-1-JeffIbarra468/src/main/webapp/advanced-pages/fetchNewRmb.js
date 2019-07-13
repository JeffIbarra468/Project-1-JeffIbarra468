'use strict'

// Submitting reimbursement request - elements
//let newRmb = document.getElementById("newRmb");

//Submitting reimbursement request
/*
newRmb.addEventListener("click", (event) => {
	event.preventDefault();

	let Description = window.prompt("Description of Remibursement:");
	perInfo.document.write("Desciption: " + Description);
});
*/
/*
fetch("/advanced-pages/ReimbursementView")
.then((response) => {
	console.log(response);
	return response.json();
}) // end of then (response)
.then((obj) => {
	// User information backdrop in perInfo element Id
	perInfo.innerText = "Reimbursements:\n";

	for(let x in obj) { // for loops through properties of an object
		console.log(obj);

		// Creating table to show in HTML Page
		let li = document.createElement("li");
		li.innerText =  `${x} : ${obj[x]}`;
		perInfo.appendChild(li);				
		
	} // end of for each

}) // end of then (obj)
.catch((err) => {
	console.log(err);
});
*/