/**
 * 
 */


document.querySelector("#worksheet").addEventListener("click", () => {
	
	
	if (document.body.style.background != "#1c1c1c" && document.body.style.overflow != "visible" && document.querySelector(".container").style.height != "fit-content" && document.querySelector(".container").style.visibility != "visible") {
		console.log("if");
		
		document.body.style.overflow = "visible";
		document.querySelector(".container").style.height = "fit-content";
		document.querySelector(".container").style.visibility = "visible";
	} else {
		console.log("else");
		
		document.body.style.overflow = "hidden";
		document.querySelector(".container").style.height = "400px";
		document.querySelector(".container").style.visibility = "hidden";
	}

});