'use strict';


//// View Personal Information - elements
//let getAllPenR = document.getElementById("getAllPenR");

//Element where user will see all interactions
let allPenR = document.getElementById("allPenR");

// View Personal Information

// Clicker event by getAllPenR element Id
//getAllPenR.addEventListener("click", (event) => {
//	event.preventDefault();

	fetch("/Project-1-JeffIbarra468/AllPending")
		.then((response) => {
			console.log(response);
			return response.json();
		}) // end of then (response)
		.then((obj) => {
			// User information backdrop in allPenR element Id
			allPenR.innerText = "Reimbursement Information:\n";

			for(let x in obj) { // for loops through properties of an object
				console.log(obj);

				// Creating table to show in HTML Page
				let li = document.createElement("li");
				li.innerText =  `${x} : ${obj[x]}`;
				allPenR.appendChild(li);				
				
			} // end of for each

		}) // end of then (obj)
		.catch((err) => {
			console.log(err);
		});
//});