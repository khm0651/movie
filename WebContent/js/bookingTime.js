let header = document.querySelector(".header");
let movieListItem = document.querySelectorAll(".movieList-item");

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
