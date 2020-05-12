let clientHeight = window.innerHeight;
let clientWidth = window.innerWidth;
let loginForm;
let body = document.querySelector("body");
let login;
let loginClose;
let loginClick = false;

const loginCloseEvent = (e) =>{
    loginClick = !loginClick;
    body.lastChild.remove();
    document.addEventListener("wheel",smoothWheel);
    loginClose.removeEventListener("click",loginCloseEvent);
}

const makeLoginForm = () =>{
    let form = document.createElement("form");
    form.classList.add("login-form");
    form.action="./sign-in";
    form.acceptCharset="UTF-8";
    form.method = "POST";
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
    inputId.name="id";
    loginInputWrapper.appendChild(inputId);
    let inputPw = document.createElement("input");
    inputPw.type="password";
    inputPw.placeholder = "비밀번호";
    inputPw.classList.add("login-pw");
    inputPw.name="pw"
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


if(document.querySelector(".sign-in")!=null){
	login = document.querySelector(".sign-in"); 

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

}