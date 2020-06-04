let vidio = document.querySelectorAll(".review-vidio");
let videoPlayerSrc = document.getElementsByName("videoPlayerSrc");
let modal = document.querySelector(".review-vidio-modal");
let close = document.querySelector(".vidio-close");
let header = document.querySelector(".header");
let subTitle = document.getElementsByClassName("sub-title");
let iframe = document.querySelector("iframe");

header.classList.add("header-not-fixed");


const videoSize = subTitle[0].getAttribute("data-set-size");
subTitle[0].innerHTML = `예고편 (${videoSize})`;

close.addEventListener("click",e=>{
	modal.classList.remove("review-vidio-modal-show");
	iframe.src="";
})


for(let i=0; i<vidio.length; i++){
	vidio[i].addEventListener("click",e=>{
		modal.classList.add("review-vidio-modal-show");
		iframe.src = videoPlayerSrc[i].value;
		
	})
}