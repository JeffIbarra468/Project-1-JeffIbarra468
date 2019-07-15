'use strict';

//Element where user will see all interactions
let oneEmp = document.getElementById("oneEmp");

// View Personal Information


	// /Project-1-JeffIbarra468/login
	fetch("/Project-1-JeffIbarra468/OneEmployee")
		.then((response) => {
			console.log(response);
			return response.json();
		}) // end of then (response)
		.then((obj) => {
			// User information backdrop in perInfo element Id
			oneEmp.innerText = "User's Reimbursement:\n";

			for(let x in obj) { // for loops through properties of an object
				console.log(obj);

				// Creating table to show in HTML Page
				let li = document.createElement("li");
				li.innerText =  `${x} : ${obj[x]}`;
				oneEmp.appendChild(li);				
				
			} // end of for each

		}) // end of then (obj)
		.catch((err) => {
			console.log(err);
		});