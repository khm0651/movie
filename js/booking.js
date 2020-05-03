let header = document.querySelector(".header");
let sit = ["A","B","C","D","E","F","G","H","I","J","K"];
let bookingSelect = document.querySelector(".booking-select");
let count = 1;
header.classList.add("header-not-fixed");

for(i=0; i<sit.length;i++){
    let div = document.createElement("div");
    div.classList.add("sit-line");
    div.innerText=sit[i];
    bookingSelect.appendChild(div);
    for(j=1; j<22;j++){
        if(sit[i] == "J" ){
            if(j==1 || j==2 || j==3 || j==5 || j==19 || j==21){
                div = document.createElement("div");
                div.classList.add("blank");
                bookingSelect.appendChild(div);
                if(j==3 || j==21){
                    count++;
                }
            }else{
                div = document.createElement("div");
                div.classList.add("sit");
                div.innerText=count;
                count++;
                bookingSelect.appendChild(div);
            }
        }else if(sit[i]=="K"){
            if(j==1 || j==2 || j==3 || j==4 || j==5 || j==11 || j==12 || j==13 || j==19 || j==20 || j==21){
                div = document.createElement("div");
                div.classList.add("blank");
                bookingSelect.appendChild(div);
                if(j==3 || j==4 || j==11 || j==12 || j==13 || j==20 || j==21){
                    count++;
                }
            }else{
                div = document.createElement("div");
                div.classList.add("sit");
                div.innerText=count;
                count++;
                bookingSelect.appendChild(div);
            }
        }else{
            if(j==1 || j==2 || j==5 ||j==19){
                div = document.createElement("div");
                div.classList.add("blank");
                bookingSelect.appendChild(div);
            }else{
                div = document.createElement("div");
                div.classList.add("sit");
                div.innerText=count;
                count++;
                bookingSelect.appendChild(div);
            }
        }
        
        
    }
    count=1;
}



