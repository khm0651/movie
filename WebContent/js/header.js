let clientHeight = window.innerHeight;
let clientWidth = window.innerWidth;
let loginForm;
let body = document.querySelector("body");
let login;
let loginClose;
let loginClick = false;
let random = document.querySelector(".random");


var mobilecheck = function() {
	var check = false;
	(function(a, b) {
		if (/(android|bb\d+|meego).+mobile|avantgo|bada\/|blackberry|blazer|compal|elaine|fennec|hiptop|iemobile|ip(hone|od)|iris|kindle|lge |maemo|midp|mmp|mobile.+firefox|netfront|opera m(ob|in)i|palm( os)?|phone|p(ixi|re)\/|plucker|pocket|psp|series(4|6)0|symbian|treo|up\.(browser|link)|vodafone|wap|windows ce|xda|xiino/i
				.test(a)
				|| /1207|6310|6590|3gso|4thp|50[1-6]i|770s|802s|a wa|abac|ac(er|oo|s\-)|ai(ko|rn)|al(av|ca|co)|amoi|an(ex|ny|yw)|aptu|ar(ch|go)|as(te|us)|attw|au(di|\-m|r |s )|avan|be(ck|ll|nq)|bi(lb|rd)|bl(ac|az)|br(e|v)w|bumb|bw\-(n|u)|c55\/|capi|ccwa|cdm\-|cell|chtm|cldc|cmd\-|co(mp|nd)|craw|da(it|ll|ng)|dbte|dc\-s|devi|dica|dmob|do(c|p)o|ds(12|\-d)|el(49|ai)|em(l2|ul)|er(ic|k0)|esl8|ez([4-7]0|os|wa|ze)|fetc|fly(\-|_)|g1 u|g560|gene|gf\-5|g\-mo|go(\.w|od)|gr(ad|un)|haie|hcit|hd\-(m|p|t)|hei\-|hi(pt|ta)|hp( i|ip)|hs\-c|ht(c(\-| |_|a|g|p|s|t)|tp)|hu(aw|tc)|i\-(20|go|ma)|i230|iac( |\-|\/)|ibro|idea|ig01|ikom|im1k|inno|ipaq|iris|ja(t|v)a|jbro|jemu|jigs|kddi|keji|kgt( |\/)|klon|kpt |kwc\-|kyo(c|k)|le(no|xi)|lg( g|\/(k|l|u)|50|54|\-[a-w])|libw|lynx|m1\-w|m3ga|m50\/|ma(te|ui|xo)|mc(01|21|ca)|m\-cr|me(rc|ri)|mi(o8|oa|ts)|mmef|mo(01|02|bi|de|do|t(\-| |o|v)|zz)|mt(50|p1|v )|mwbp|mywa|n10[0-2]|n20[2-3]|n30(0|2)|n50(0|2|5)|n7(0(0|1)|10)|ne((c|m)\-|on|tf|wf|wg|wt)|nok(6|i)|nzph|o2im|op(ti|wv)|oran|owg1|p800|pan(a|d|t)|pdxg|pg(13|\-([1-8]|c))|phil|pire|pl(ay|uc)|pn\-2|po(ck|rt|se)|prox|psio|pt\-g|qa\-a|qc(07|12|21|32|60|\-[2-7]|i\-)|qtek|r380|r600|raks|rim9|ro(ve|zo)|s55\/|sa(ge|ma|mm|ms|ny|va)|sc(01|h\-|oo|p\-)|sdk\/|se(c(\-|0|1)|47|mc|nd|ri)|sgh\-|shar|sie(\-|m)|sk\-0|sl(45|id)|sm(al|ar|b3|it|t5)|so(ft|ny)|sp(01|h\-|v\-|v )|sy(01|mb)|t2(18|50)|t6(00|10|18)|ta(gt|lk)|tcl\-|tdg\-|tel(i|m)|tim\-|t\-mo|to(pl|sh)|ts(70|m\-|m3|m5)|tx\-9|up(\.b|g1|si)|utst|v400|v750|veri|vi(rg|te)|vk(40|5[0-3]|\-v)|vm40|voda|vulc|vx(52|53|60|61|70|80|81|83|85|98)|w3c(\-| )|webc|whit|wi(g |nc|nw)|wmlb|wonu|x700|yas\-|your|zeto|zte\-/i
						.test(a.substr(0, 4)))
			check = true
	})(navigator.userAgent || navigator.vendor || window.opera);
	return check;
}


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

random.addEventListener("click",e=>{
	if (mobilecheck()) {
		// 작업
		$("#recoMovie").load(
				"./recoMoviePopupTest1.jsp");
		//모바일로 접속시 이동 경로
	} else {
		var popUrl = "./recoMoviePopup.jsp";
		var popOption = "width=680px, height=380px, resizable=no, location=no, top=300px, left=300px;"

		window.open(popUrl, "추천영화", popOption);
		//PC로 접속시 이동 경로
	}
})