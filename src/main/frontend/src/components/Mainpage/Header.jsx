import React, {Component} from 'react';
import header from '../../css/header.css';
import logotype from "../../imgs/logotype.png"
import Login from "./Login"
import Backdrop from "./Backdrop";
import {NavLink} from "react-router-dom";

import login from "../../services/login"




// import {Form,FormControl,FormLabel,Button} from "react-bootstrap"

class Header extends Component {
    constructor(props) {
        super(props);
        this.state = {
            creating: false,
            persons: []


        }
    }
    createEventHandler = () => {
        this.setState({creating: true})
    }
    onExit1 = () => {
        this.setState({creating: false})
    }


    componentDidMount() {

    }
    googleXD = () =>{
        let port = (window.location.port ? ':' + window.location.port : '');
        if (port === ':3000') {
            port = ':8081';
        }
        console.log(window.location.hostname);
        window.location.href = '//' + window.location.hostname + port + '/login';
        // login.googleAuth()
        //     .then(res => {
        //
        //             this.setState({persons: res.data}, () => {
        //                 console.log(this.state.persons);
        //             });
        //         }
        //     ).catch(res => console.log(res.message));
        // console.log(this.state.persons)

    };
    GoogleAuth =  () => {
       // const request = require('request');
       //  request('http://localhost:8081/home', function (error, response, body) {
       //      console.log('error:', error); // Print the error if one occurred
       //      console.log('statusCode:', response && response.statusCode); // Print the response status code if a response was received
       //      console.log('body:', body); // Print the HTML for the Google homepage.
       //  });
        login.googleAuth()
            .then(res => {

                this.setState({persons: res.data}, () => {
                    console.log(res);
                });
                }
            ).catch(res => console.log(res.message));
        console.log(this.state.persons)
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
                            {/*{this.state.persons.map(person => <li>{person}</li>)}*/}
                            <li className='btnh1'><NavLink to='#'>Учиться </NavLink></li>
                            <li className='btnh2'><NavLink to='#'> Стать автором </NavLink></li>
                            <li className="login"><NavLink to='#' onClick={this.createEventHandler}>Войти </NavLink>
                            </li>
                        </ul>

                    </div>

                    {this.state.creating && <Backdrop/>}
                    {this.state.creating &&
                        <Login title="Войти" googleAuth={this.GoogleAuth} canCancel={this.googleXD} canConfirm onExit1={this.onExit1}>

                    </Login>}
                </React.Fragment>
            </header>

        )
    }

}

export default Header;