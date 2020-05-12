
let nowPosition = 0;
let bodyHieght = document.body.clientHeight;
let iBody = document.querySelector("body");
iBody.classList.add("hiddenY");




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


