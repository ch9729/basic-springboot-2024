import React from "react";

import { Link, useNavigate } from "react-router-dom";

const Header = () => {

    const navigate = useNavigate(); // Hook 함수는 직접 사용불가

    function gotoLogin() {
        navigate('/login')    
    }

    function logOut() {
        localStorage.setItem("username", "");
        localStorage.setItem("email", "");
        localStorage.setItem("mid", "");
        localStorage.setItem("role", "");
        localStorage.setItem("loginDt", "");
        window.location.replace("http://localhost:3000/home")    // Url 재시작
    }

    // return은 화면은 화면을 그리겠다.
    return (
        <div className="container header">
            <header className="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
                <div id="logo-area" className="col-md-1 mb-2 mb-md-0">
                    <a href="/home" className="d-inline-flex link-body-emphasis text-decoration-none">
                        <img src={require('../logo.png')} alt="logo" width={40}></img>
                    </a>
                    
                </div>
                <ul className="nav col-12 col-md-6 mb-2 justify-content-center">
                    <li><Link to="/home" className="nav-link px-2 link-secondary">홈</Link></li>
                    <li><Link to="/boardList" className="nav-link px-2 link-secondary">게시판</Link></li>
                    <li><Link to="/qnaList" className="nav-link px-2 link-secondary">질문응답</Link></li>
                </ul>

                <div className="col-md-3 text-end me-3">
                    {localStorage.getItem("username") != "" ? (
                        <button type="button" className="btn btn-outline-primary" onClick={logOut}>로그아웃</button>
                    ) : (
                        <>
                        <button type="button" className="btn btn-outline-primary me-2" onClick={gotoLogin}>로그인</button>
                        <button type="button" className="btn btn-outline-primary">회원가입</button>
                        </>
                    )}
                </div>
            </header>
        </div>
    );
}

export default Header;