let vidio = document.querySelectorAll(".review-vidio");
let modal = document.querySelector(".review-vidio-modal");
let close = document.querySelector(".vidio-close");
let header = document.querySelector(".header");
header.classList.add("header-not-fixed");

close.addEventListener("click",e=>{
	modal.classList.remove("review-vidio-modal-show");
})

for(let i=0; i<vidio.length; i++){
	vidio[i].addEventListener("click",e=>{
		modal.classList.add("review-vidio-modal-show");
		
	})
}