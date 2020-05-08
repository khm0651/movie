let clientHeight = window.innerHeight;
let clientWidth = window.innerWidth;
let nowPosition = 0;
let bodyHieght = document.body.clientHeight;
let loginForm;
let body = document.querySelector("body");
let login = document.querySelector(".sign-in");
let loginClose;
let loginClick = false;
body.classList.add("hiddenY");

console.log(clientHeight);
console.log(clientWidth);

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

const makeLoginForm = () =>{
    let form = document.createElement("form");
    form.classList.add("login-form");
    let loginWrapper = document.createElement("div");
    loginWrapper.classList.add("login-wrapper");
    form.appendChild(loginWrapper);
    let loginHeader = document.createElement("div");
    loginHeader.classList.add("login-header");
    loginWrapper.appendChild(loginHeader);
    let loginTitle = document.createElement("div");
    loginTitle.classList.add("login-title");
    loginTitle.innerText="로그인";
    loginHeader.appendChild(loginTitle);
    let loginClose = document.createElement("div");
    loginClose.classList.add("login-close");
    loginClose.innerText="X";
    loginHeader.appendChild(loginClose);
    let loginContent = document.createElement("div");
    loginContent.classList.add("login-content");
    loginWrapper.appendChild(loginContent);
    let loginLeft = document.createElement("div");
    loginLeft.classList.add("login-left");
    loginContent.appendChild(loginLeft);
    let loginInputWrapper = document.createElement("div");
    loginInputWrapper.classList.add("login-input-wrapper");
    loginLeft.appendChild(loginInputWrapper);
    let inputId = document.createElement("input");
    inputId.type="text";
    inputId.placeholder="아이디";
    inputId.classList.add("login-id");
    loginInputWrapper.appendChild(inputId);
    let inputPw = document.createElement("input");
    inputPw.type="password";
    inputPw.placeholder = "비밀번호";
    inputPw.classList.add("login-pw");
    loginInputWrapper.appendChild(inputPw);
    let loginSubmit = document.createElement("input");
    loginSubmit.type="submit";
    loginSubmit.value="로그인"
    loginSubmit.classList.add("login-submit");
    loginLeft.appendChild(loginSubmit);
    let loginMoreInfo = document.createElement("div");
    loginMoreInfo.classList.add("login-more-info");
    loginLeft.appendChild(loginMoreInfo);
    let loginMoreItem = document.createElement("div");
    loginMoreItem.classList.add("login-more-item");
    loginMoreItem.innerText="ID/PW 찾기";
    loginMoreInfo.appendChild(loginMoreItem);
    loginMoreItem = document.createElement("div");
    loginMoreItem.classList.add("login-more-item");
    loginMoreItem.innerText="회원가입";
    loginMoreInfo.appendChild(loginMoreItem);

    let loginRight = document.createElement("div");
    loginRight.classList.add("login-right");
    loginContent.appendChild(loginRight);
    let loginAdd = document.createElement("div");
    loginAdd.classList.add("login-add");
    loginAdd.innerText="광고 이미지"
    loginRight.appendChild(loginAdd);
    
    body.appendChild(form);

}

const loginCloseEvent = (e) =>{
    loginClick = !loginClick;
    body.lastChild.remove();
    document.addEventListener("wheel",smoothWheel);
    loginClose.removeEventListener("click",loginCloseEvent);
}

document.addEventListener("wheel",smoothWheel);

login.addEventListener("click", (e)=>{
    if(!loginClick){
        makeLoginForm();
        loginForm = document.querySelector(".login-form");
        loginForm.classList.add("select");
        loginClose = document.querySelector(".login-close");
        loginClose.addEventListener("click",loginCloseEvent);
        loginClick = !loginClick;
        document.removeEventListener("wheel",smoothWheel);
    }
})

