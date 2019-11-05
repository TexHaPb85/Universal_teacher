import React, {Component} from 'react';
import header from '../../css/header.css';
import logotype from "../../imgs/logotype.png"
import Login from "./Login"
import Backdrop from "./Backdrop";
import {NavLink} from "react-router-dom";
import login from "../../services/login"
import axios from "axios";

// import {Form,FormControl,FormLabel,Button} from "react-bootstrap"

class Header extends Component {
    state = {
        creating: false,
        persons: []

    };
    createEventHandler = () => {
        this.setState({creating: true})
    }
    onExit1 = () => {
        this.setState({creating: false})
    }
    onExit2 = () => {
        if (onauxclick == Login) {
            this.setState({creating: false})
        }
    }

    componentDidMount() {
        login.googleAuth()
            .then(res => {
                    console.log(res);
                    this.setState({persons: res.data})
                    console.log(res)
                }
            )
    }

    onGoogleAuth = () => {
        login.googleAuth()
            .then(res => {
                    console.log(res);
                    this.setState({persons: res.data})
                console.log(res)
                }
            )
    }

    render() {
        return (

            <header>

                <React.Fragment>
                    <img src={logotype} alt="ekekke" className="Logo"/>
                    <div class='container'>
                        <div class='item1'>

                        </div>
                        <ul class="item2">
                            {this.state.persons.map(person => <li>{person.id}</li>)}
                            <li className='btnh1'><NavLink to='#'>Учиться </NavLink></li>
                            <li className='btnh2'><NavLink to='#'> Стать автором </NavLink></li>
                            <li className="login"><NavLink to='/heh' onClick={this.createEventHandler}>Войти </NavLink>
                            </li>
                        </ul>

                    </div>

                    {this.state.creating && <Backdrop/>}
                    {this.state.creating &&
                    <Login title="Войти" googleAuth={this.onGoogleAuth} canCancel canConfirm onExit1={this.onExit1}>

                    </Login>}
                </React.Fragment>
            </header>

        )
    }

}

export default Header;