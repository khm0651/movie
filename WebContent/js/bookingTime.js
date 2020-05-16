let header = document.querySelector(".header");
let movieListItem = document.querySelectorAll(".movieList-item");
let movieTimeItem = document.querySelectorAll(".movieTime-item");
header.classList.add("header-not-fixed");

for(let i=0; i<movieListItem.length; i++){
	movieListItem[i].addEventListener("click",e=>{
		let form = document.createElement("form");
		form.method="POST";
		form.acceptCharset="UTF-8";
		let input = document.createElement("input");
		input.type="hidden";
		input.name="movieName";
		input.value=movieListItem[i].innerText;
		form.append(input);
		movieListItem[i].append(form);
		form.submit();
	})
}

for (let i=0; i<movieTimeItem.length; i++){
	movieTimeItem[i].addEventListener("click",e=>{
		let form = document.createElement("form");
		form.action="./booking";
		form.method="POST";
		form.acceptCharset="UTF-8";
		let input =document.createElement("input");
		input.type="hidden";
		input.name="movieName";
		input.value=movieTimeItem[i].children[1].innerText;
		form.append(input);
		input =document.createElement("input");
		input.type="hidden";
		input.name="startTime";
		input.value=movieTimeItem[i].children[0].children[0].innerText;
		form.append(input);
		input =document.createElement("input");
		input.type="hidden";
		input.name="endTime";
		input.value=movieTimeItem[i].children[0].children[1].innerText;
		form.append(input);
		input =document.createElement("input");
		input.type="hidden";
		input.name="place";
		input.value=movieTimeItem[i].children[2].children[0].innerText;
		form.append(input);
		movieTimeItem[i].append(form);
		form.submit();
	})
}