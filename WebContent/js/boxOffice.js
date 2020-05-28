let header = document.querySelector(".header");
let button = document.querySelectorAll(".reservation");
let movieName = document.querySelectorAll("input");
let card = document.querySelectorAll(".card");
header.classList.add("header-not-fixed");

for(let i=0; i<button.length ; i++){
	button[i].addEventListener("click",e=>{
		let form = document.createElement("form");
		form.action = "./bookingTime";
		form.acceptCharset="UTF-8";
		form.method="POST";
		let input = document.createElement("input");
		input.type="hidden";
		input.name="movieName";
		input.value=movieName[i].value;
		form.append(input);
		button[i].append(form);
		form.submit();
	})
}

var timeout = [];

for(let i = 0 ; i<card.length; i++){
	timeout.push(setTimeout(()=>{
		card[i].classList.add("card-show");
	}, 100*i));
}

window.onbeforeunload = function(e){
	for(let i=0; i<card.length; i++){
		clearTimeout(timeout[i]);
	}
    
}
