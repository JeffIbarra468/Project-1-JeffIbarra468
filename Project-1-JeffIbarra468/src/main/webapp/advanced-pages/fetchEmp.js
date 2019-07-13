'use strict';

// View Personal Information - elements
let getInfo = document.getElementById("getInfo");
//Element where user will see all interactions
let perInfo = document.getElementById("perInfo");

// View Personal Information

// Clicker event by getInfo element Id
getInfo.addEventListener("click", (event) => {
	event.preventDefault();

	fetch("/Project-1-JeffIbarra468/login")
		.then((response) => {
			console.log(response);
			return response.json();
		}) // end of then (response)
		.then((obj) => {
			// User information backdrop in perInfo element Id
			perInfo.innerText = "User's Information:\n";

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
});
