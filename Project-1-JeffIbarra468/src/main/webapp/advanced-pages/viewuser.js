'use strict'

let info = document.getElementById("perInfo");


// we can use fetch API, including our own
// we'll grab the current use info from /apiguy/login

// fetch sends a GET and returns a Promise
// we act on the result of the Promise by calling .then:
fetch("/Project-1-JeffIbarra468/login")
    .then((response) => {
    	console.log(response);
    	return response.json})
    .then((obj) => {
        // here we have our object thanks to the prior response.json()
        // let's modify the DOM
        // loop through props of our object:

        for(let x in obj) {
        	console.log(obj);
            // we'll produce a list item for each property
            let li = document.createElement("li");
            // add info to the li:
            li.innerText = `${x} : ${obj[x]}`;
            // to add elements to the DOM we must append them to existing
            // elements:
            info.appendChild(li);
        }
    })
    .catch((err) => {
        console.log(err);
    });
