let movieName = document.querySelectorAll("input");
let button = document.querySelectorAll(".reservation");
let nowPosition = 0;
let bodyHieght = document.body.clientHeight;
let iBody = document.querySelector("body");
iBody.classList.add("hiddenY");

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


const smoothWheel = (e) => {
    if(e.deltaY >0){
        if(nowPosition+clientHeight<bodyHieght){
            nowPosition+=clientHeight;
            window.scrollTo({
                left:0,
                top:nowPosition+clientHeight,
            });
        }
        
        
    }else{
        if(nowPosition-clientHeight>=0){
            nowPosition-=clientHeight;
            window.scrollTo({
                left:0,
                top:nowPosition-clientHeight,
            });
        }
    }
}


document.addEventListener("wheel",smoothWheel);


