'use strict';

// View Pending Reimbursements - elements
let getPenR = document.getElementById("getPenR");
//Element where user will see all interactions
let penR = document.getElementById("penR");

//View Pending Reimbursements

//Clicker event by getPenR element Id
getPenR.addEventListener("click", (event) => {
	event.preventDefault();

	fetch("/EmployeePending")
		.then((response) => {
			console.log(response);
			return response.json();
		}) // end of then (response)
		.then((obj) => {
			// User information backdrop in penR element Id
			penR.innerText = "Pending Reimbursments:\n";

			for(let x in obj) { // for loops through properties of an object
				console.log(obj);

				// Creating table to show in HTML Page
				let li = document.createElement("li");
				li.innerText =  `${x} : ${obj[x]}`;
				penR.appendChild(li);				
				
			} // end of for each

		}) // end of then (obj)
		.catch((err) => {
			console.log(err);
		});
});
