'use strict'

// View Resolved Reimbursements - elements
//let getResR = document.getElementById("getResR");
//Element where user will see all interactions
let resR = document.getElementById("resR");

//View Resolved Reimbursements

//Clicker event by getResR element Id
//getResR.addEventListener("click", (event) => {
//	event.preventDefault();

	fetch("/Project-1-JeffIbarra468/EmployeeResolved")
		.then((response) => {
			console.log(response);
			return response.json();
		}) // end of then (response)
		.then((obj) => {
			// User information backdrop in resR element Id
			resR.innerText = "Resolved Reimbursments:\n";

			for(let x in obj) { // for loops through properties of an object
				console.log(obj);

				// Creating table to show in HTML Page
				let li = document.createElement("li");
				li.innerText =  `${x} : ${obj[x]}`;
				resR.appendChild(li);				
				
			} // end of for each

		}) // end of then (obj)
		.catch((err) => {
			console.log(err);
		});
//});