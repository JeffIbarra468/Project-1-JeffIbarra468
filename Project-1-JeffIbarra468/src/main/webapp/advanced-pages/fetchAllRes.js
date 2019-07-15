'use strict';

// View Personal Information - elements
//let getAllResR = document.getElementById("getAllResR");
//Element where user will see all interactions
let allResR = document.getElementById("allResR");

// View Personal Information

// Clicker event by getAllResR element Id
//getAllResR.addEventListener("click", (event) => {
//	event.preventDefault();

	fetch("/Project-1-JeffIbarra468/AllResolved")
		.then((response) => {
			console.log(response);
			return response.json();
		}) // end of then (response)
		.then((obj) => {
			// User information backdrop in allResR element Id
			allResR.innerText = "Reimbursement Information:\n";

			for(let x in obj) { // for loops through properties of an object
				console.log(obj);

				// Creating table to show in HTML Page
				let li = document.createElement("li");
				li.innerText =  `${x} : ${obj[x]}`;
				allResR.appendChild(li);				
				
			} // end of for each

		}) // end of then (obj)
		.catch((err) => {
			console.log(err);
		});
//});