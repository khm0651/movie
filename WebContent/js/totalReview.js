let vidio = document.querySelectorAll(".review-vidio");
let videoPlayerSrc = document.getElementsByName("videoPlayerSrc");
let modal = document.querySelector(".review-vidio-modal");
let close = document.querySelector(".vidio-close");
let header = document.querySelector(".header");
let movieListItem = document.querySelectorAll(".movieList-item");
if(document.querySelector(".click-vidio")!= null){
let frame = document.querySelector(".click-vidio");
	frame.addEventListener("click",e=>{
		console.log("ho");
	})
}
let frameVidio = document.querySelector("iframe");
header.classList.add("header-not-fixed");

if(document.querySelector(".sub-title") != null){
	let subTitle = document.querySelector(".sub-title");
	const videoSize = subTitle.getAttribute("data-set-size");
	subTitle.innerHTML = `예고편 (${videoSize})`;
}
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


close.addEventListener("click",e=>{
	modal.classList.remove("review-vidio-modal-show");
	frameVidio.src="";
})


for(let i=0; i<vidio.length; i++){
	vidio[i].addEventListener("click",e=>{
		console.log(videoPlayerSrc[i].value);
		modal.classList.add("review-vidio-modal-show");
		frameVidio.src = videoPlayerSrc[i].value;
		
	})
}