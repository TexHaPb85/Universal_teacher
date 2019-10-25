import React from "react";
import "../css/login.css"
import img from "../imgs/login/exitIcon.png"

const Login = props =>(
    <div className="login_modal">
            <header className="login_header"><h1>{props.title}</h1>
                <div className="modal_exit"> {props.onExit1  &&  <img src={img} onClick={props.onExit1}   alt="rofl" />}</div>
            </header>
        <section className="login_content">
            {props.children}

        </section>
        <section className="login_action">
            {props.canCancel && <button className="btn" >Зарегистрироваться</button>}
            {props.canConfirm &&<button>Войти</button>}
        </section>
    </div>
)

export default Login;