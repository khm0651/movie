let header = document.querySelector(".header");
let sit = ["A","B","C","D","E","F","G","H","I","J","K"];
let bookingSelect = document.querySelector(".booking-select");
let count = 1;
let totalCount = 0;
let adultCount = 0;
let teenageCount = 0;
let selectedCount=totalCount;
let str = ["성인","청소년"];
let price = [10000,7000];
let mBtn = document.querySelectorAll(".m-btn");
let pBtn = document.querySelectorAll(".p-btn");
let cBtn = document.querySelectorAll(".c-btn");
let rc = document.querySelectorAll(".count");
let resultCount = document.querySelector(".booking-result-count");
let sitdiv;
let selectedSit = document.querySelectorAll(".selected-sit");
let f = true;
let refresh = document.querySelector(".booking-refresh")
let resultprice = document.querySelector(".result-price");
let finish = document.querySelector(".finish");
let movieName = document.querySelector(".booking-info-title").innerText;
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
        if(i==0){
        	adultCount--;
        }else{
        	teenageCount--;
        }
        if(count<0){
            alert("개수가 이상합니다.");
            count++;
            totalCount++;
            if(i==0){
            	adultCount++;
            }else{
            	teenageCount++;
            }
        }
        cBtn[i].innerHTML=count;
        resultprice.innerText = (adultCount * price[0]) + (teenageCount * price[1]);
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
        if(i==0){
        	adultCount++;
        }else{
        	teenageCount++;
        }
        if(totalCount>8){
            alert("선택 개수 초과");
            count--;
            totalCount--;
            if(i==0){
            	adultCount--;
            }else{
            	teenageCount--;
            }
        }
        cBtn[i].innerHTML=count;
        resultprice.innerText = (adultCount * price[0]) + (teenageCount * price[1]);
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
        if(sitdiv[i].classList.contains("selected") && !sitdiv[i].classList.contains("reservationSit")){
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
                
            }else if(sitdiv[i].classList.contains("reservationSit")){
        		alert("예매완료된 좌석입니다.");
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

finish.addEventListener("click",e=>{
	
	let room = document.querySelector(".movie-place").innerText;
	let date = document.querySelector(".movie-day").innerText;
	let startTime = document.querySelector(".movie-time").innerText.split("~")[0];
	let endTime = document.querySelector(".movie-time").innerText.split("~")[1];
	let sit = [];
	let price = resultprice.innerText;
	for(let i =0; i<selectedSit.length ; i++){
		if(selectedSit[i].innerText != "-"){
			sit.push(selectedSit[i].innerText);
		}
	}
	if(sit.length != totalCount){
		alert("좌석 수를 확인해주세요");
	}else{
		let form = document.createElement("form");
		form.action = "./reservation";
		form.method = "POST";
		form.acceptCharset = "UTF-8";
		let input = document.createElement("input");
		input.type="hidden";
		input.name="movieName";
		input.value=movieName;
		form.append(input);
		
		input = document.createElement("input");
		input.type="hidden";
		input.name="movieName";
		input.value=movieName;
		form.append(input);
		
		input = document.createElement("input");
		input.type="hidden";
		input.name="room";
		input.value=room;
		form.append(input);
		
		input = document.createElement("input");
		input.type="hidden";
		input.name="date";
		input.value=date;
		form.append(input);
		
		input = document.createElement("input");
		input.type="hidden";
		input.name="startTime";
		input.value=startTime;
		form.append(input);
		
		input = document.createElement("input");
		input.type="hidden";
		input.name="endTime";
		input.value=endTime;
		form.append(input);
		
		input = document.createElement("input");
		input.type="hidden";
		input.name="sit";
		input.value=sit;
		form.append(input);
		
		input = document.createElement("input");
		input.type="hidden";
		input.name="price";
		input.value=price;
		form.append(input);
		
		input = document.createElement("input");
		input.type="hidden";
		input.name="adult";
		input.value=adultCount;
		form.append(input);
		
		input = document.createElement("input");
		input.type="hidden";
		input.name="teenage";
		input.value=teenageCount;
		form.append(input);
		
		finish.append(form);
		form.submit();
		
		
	}
	
	
	
})

var xmlHttp = new XMLHttpRequest();       // XMLHttpRequest 객체를 생성함.
let sitList;
xmlHttp.onreadystatechange = function() { // onreadystatechange 이벤트 핸들러를 작성함.

    // 서버상에 문서가 존재하고 요청한 데이터의 처리가 완료되어 응답할 준비가 완료되었을 때

    if(this.status == 200 && this.readyState == this.DONE) {

        // 요청한 데이터를 문자열로 반환함.

    	sitList = xmlHttp.responseText;
    	sitList = sitList.split(",");
    	sitList.pop(0);
    	sitList.sort();
        for(let i=0; i<sitdiv.length;i++){
        	for(let j=0; j<sitList.length;j++){
        		if(sitdiv[i].classList[1] == sitList[j]){
        			sitdiv[i].classList.add("reservationSit");
        			sitdiv[i].style.backgroundColor="#413c3cbd";
        			sitdiv[i].style.color="#fffff0ab";
        			sitdiv[i].style.fontWeight="#bold";
        			sitdiv[i].style.fontSize="20px";
        			sitdiv[i].innerText="X";
        			console.log("find");
        		}
        	}
        }

    }

};

xmlHttp.open("GET", `./sitList?movieName=${movieName}`, true);

xmlHttp.send();
