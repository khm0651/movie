let input = document.querySelectorAll("input");
let movieName = document.querySelectorAll(".movieTitle");
let place = document.querySelectorAll(".room");
let sit = document.querySelectorAll(".sit");
let buydate = document.querySelectorAll(".buyDate");
let startTime = document.querySelectorAll(".startTime");
let header = document.querySelector(".header");
header.classList.add("header-not-fixed");

for(let i=0; i<input.length;i++){
	input[i].addEventListener("click",e=>{
		let form = document.createElement("form");
		form.action="./deleteReservation";
		form.acceptCharset="UTF-8";
		form.method="POST";
		let input = document.createElement("input");
		input.type="hidden";
		input.name="movieName";
		input.value=movieName[i].innerText;
		form.append(input);
		
		input = document.createElement("input");
		input.type="hidden";
		input.name="place";
		input.value=place[i].innerText;
		form.append(input);
		
		input = document.createElement("input");
		input.type="hidden";
		input.name="sit";
		input.value=sit[i].innerText;
		form.append(input);
		
		input = document.createElement("input");
		input.type="hidden";
		input.name="buydate";
		input.value=buydate[i].innerText;
		form.append(input);
		
		input = document.createElement("input");
		input.type="hidden";
		input.name="startTime";
		input.value=startTime[i].innerText;
		form.append(input);
		
		e.target.parentElement.append(form);
	})
}
