import React from "react";
import "../../css/login.css"
import img from "../../imgs/login/exitIcon.png"
import google from "../../imgs/login/googleAuth.png"



const Login = props =>
    <div className="login_modal">
        <header className="login_header"><h1>{props.title}</h1>
            <div className="modal_exit"> {props.onExit1 && <img src={img} onClick={props.onExit1} alt="rofl"/>}</div>
        </header>
        <section className="login_content">

            <form className="login-form">
                {/*<lable for="email">Введите почту</lable>*/}
                <input className="login-input" type="email" placeholder="Почта"/>
                {/*<label for="password">Введте пароль</label>*/}
                <input className="login-input" type="password" placeholder="Пароль"/>
                <label>
                    <input className="login-checkbox" type="checkbox"/>Check me out
                </label>
                <button className="login-submit" >
                    Войти
                </button>
                <section className="login_action">
                    <div className="google">  {props.googleAuth &&
                    <div onClick={props.googleAuth} className="google-button"><img className="google-img" src={google}
                                                                                   alt="rofl1"/><span
                        className="google-text">Войти с помощью Google</span></div>}</div>
                    {props.canCancel &&
                    <button className="register-button" onClick={props.canCancel}>Зарегистрироваться</button>}
                    {/*{props.canConfirm && <button className="register-button">Войти</button>}*/}
                </section>
            </form>


        </section>
    </div>


export default Login;