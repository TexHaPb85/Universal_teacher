import React from "react";
import "../../css/login.css"
import img from "../../imgs/login/exitIcon.png"
import google from "../../imgs/login/googleAuth.png"

import {Form, Button, Col} from "react-bootstrap"

const Login = props =>
    <div className="login_modal">
        <header className="login_header"><h1>{props.title}</h1>
            <div className="modal_exit"> {props.onExit1 && <img src={img} onClick={props.onExit1} alt="rofl"/>}</div>
        </header>
        <section className="login_content">
            {/*{props.children}*/}

                <Form>
                    <Form.Group controlId="formBasicEmail">
                        <Form.Label column={true} as={Col}>Email address</Form.Label>
                        <Form.Control type="email" placeholder="Enter email"/>
                        <Form.Text className="text-muted">
                            We'll never share your email with anyone else.
                        </Form.Text>
                    </Form.Group>

                    <Form.Group controlId="formBasicPassword">
                        <Form.Label column={true} as={Col}>Password</Form.Label>
                        <Form.Control type="password" placeholder="Password"/>
                    </Form.Group>
                    <Form.Group controlId="formBasicCheckbox">
                        <Form.Check type="checkbox" label="Check me out"/>
                    </Form.Group>
                    <Button variant="primary" type="submit">
                        Submit
                    </Button>
                </Form>


        </section>
        <section className="login_action">
            <div className="google">  {props.googleAuth &&   <img src={google} onClick={props.googleAuth} alt="rofl1"/>}</div>
            {props.canCancel && <button className="btn" onClick={props.canCancel} >Зарегистрироваться</button>}
            {props.canConfirm && <button>Войти</button>}
        </section>
    </div>


export default Login;