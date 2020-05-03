let header = document.querySelector(".header");
let sit = ["A","B","C","D","E","F","G","H","I","J","K"];
let bookingSelect = document.querySelector(".booking-select");
let count = 1;
let totalCount = 0;
let adultCount = 0;
let teenageCount = 0;
let selectedCount=totalCount;
let str = ["성인","청소년"];
let mBtn = document.querySelectorAll(".m-btn");
let pBtn = document.querySelectorAll(".p-btn");
let cBtn = document.querySelectorAll(".c-btn");
let rc = document.querySelectorAll(".count");
let resultCount = document.querySelector(".booking-result-count");
let sitdiv;
let selectedSit = document.querySelectorAll(".selected-sit");
let f = true;
let refresh = document.querySelector(".booking-refresh")
header.classList.add("header-not-fixed");

refresh.addEventListener("click",e=>{
    location.href = location.href;
})

for(i=0; i<sit.length;i++){
    let div = document.createElement("div");
    div.classList.add("sit-line");
    div.innerHTML=sit[i];
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
                div.classList.add(sit[i]+"-"+count);
                div.innerHTML=count;
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
                div.classList.add(sit[i]+"-"+count);
                div.innerHTML=count;
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
                div.classList.add(sit[i]+"-"+count);
                div.innerHTML=count;
                count++;
                bookingSelect.appendChild(div);
            }
        }
        
        
    }
    count=1;
    if(i==sit.length-1){
        sitdiv = document.querySelectorAll(".sit")
    }
}

for(let i = 0 ; i<mBtn.length; i++){
    mBtn[i].addEventListener("click",e=>{
        let count = parseInt(cBtn[i].innerHTML);
        count--
        totalCount--;
        if(count<0){
            alert("개수가 이상합니다.");
            count++;
            totalCount++;
        }
        cBtn[i].innerHTML=count;
        if(count>0){
            rc[i].innerhtml=count;
        }else if(count == 0){
            rc[i].innerHTML="";
        }
        f=true;
    })
}

for(let i = 0 ; i<pBtn.length; i++){
    pBtn[i].addEventListener("click",e=>{
        let count = parseInt(cBtn[i].innerHTML);
        count++
        totalCount++;
        if(totalCount>8){
            alert("선택 개수 초과");
            count--;
            totalCount--;
        }
        cBtn[i].innerHTML=count;
        if(count>0){
            rc[i].innerHTML=count;
        }else if(count == 0){
            rc[i].innerHTML="";
        }

        f=true;
    })
}



for(let i = 0; i<sitdiv.length; i++){
    sitdiv[i].addEventListener("click",e=>{
        let c = 0;
        for(let i=0; i<sitdiv.length; i++){
            if(sitdiv[i].classList.contains("selected"))c++;
        }
        console.log(c);
        selectedCount=(parseInt(cBtn[0].innerText) +parseInt(cBtn[1].innerText))-c;

        let selectedSitPlace = sitdiv[i].classList.toString().split(" ")[1];
        if(sitdiv[i].classList.contains("selected")){
            for(let i=0; i<selectedSit.length; i++){
                if(selectedSit[i].innerText == selectedSitPlace){
                    selectedSit[i].innerText = "-"
                    selectedSit[i].classList.remove(selectedSitPlace);
                }
            }
            selectedCount++;
            sitdiv[i].classList.remove("selected");
        }else{
            if(selectedCount<=0){
                alert("선택 개수 초과");
                
            }else{
                
                for(let i=0; i<selectedSit.length; i++){
                    if(selectedSit[i].innerText == "-"){
                        selectedSit[i].innerText=selectedSitPlace;
                        selectedSit[i].classList.add(selectedSitPlace);
                        break;
                    }
                }
                selectedCount--;
                sitdiv[i].classList.add("selected");
            }
        }
        console.log("total : "+totalCount);
        console.log("selected : "+selectedCount);
    })
}



