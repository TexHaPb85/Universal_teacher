import React, {Component} from 'react';
import header from '../../css/header.css';
import logotype from "../../imgs/logotype.png"
import Login from "./Login"
import Backdrop from "./Backdrop";
import {Link} from "react-router-dom";
import Async from "react-async"
import login from "../../services/login"

class Header extends Component {
    constructor(props) {
        super(props);
        this.state = {
            isLogged: false,
            creating: false,
            persons: {},
            auth: false

        }
    }

    someFn = () => {

    };

    createEventHandler = () => {
        this.setState({creating: true})
    }
    onExit1 = () => {
        this.setState({creating: false})
    }

    componentWillMount() {
        login.googleAuth()
            .then(res => {

                    this.setState({persons: res.data.profile}, () => {
                        if (this.state.persons === null) {
                            this.setState({auth: false, isLogged: false}, () => {
                                console.log(this.state.auth)
                                console.log(this.state.persons)
                            })
                        } else if (!this.state.persons !== undefined) {
                            this.setState({auth: true, isLogged: true}, () => {
                                console.log(this.state.persons);
                                console.log(this.state.auth)
                            });
                        }

                    });
                }
            ).catch(res => console.log(res.message));
    }

    componentDidMount() {

    }

    googleXD = () => {
        console.log(this.state.persons)

    };
    GoogleAuth = async () => {
        // window.open("http://localhost:8081/login");
        login.googleAuth()
            .then(res => {

                    this.setState({persons: res.data.profile}, () => {
                        if (this.state.persons === null) {
                            this.setState({auth: false, isLogged: false}, () => {

                                console.log(this.state.persons)
                                this.setState({creating: false})
                            })
                        } else if (!this.state.persons !== undefined) {
                            this.setState({auth: true, isLogged: true}, () => {
                                console.log(this.state.persons);

                                this.setState({creating: false})
                            });
                        }

                    });

                }
            ).catch(res => console.log(res.message));

    };

    render() {
        return (

            <header>

                <React.Fragment>
                    <img src={logotype} alt="ekekke" className="Logo"/>
                    <div class='container'>
                        <div class='item1'>

                        </div>
                        <Async>
                            {(!this.state.isLogged) ? <ul className="item2">
                                {/*{this.state.persons.map(person => <li>{person}</li>)}*/}
                                <li className='btnh1'><Link to='#'>Учиться </Link></li>
                                <li className='btnh2'><Link to='#'> Стать автором </Link></li>
                                <li className="login"><Link to='#' onClick={this.createEventHandler}>Войти </Link>
                                </li>
                            </ul> : <ul className="loggedHeader">
                                <li><Link to="/home">Профиль</Link></li>
                                <li><Link to="#">Мои Курсы</Link></li>
                                <li><Link to="#">Помощь</Link></li>
                            </ul>}</Async>

                    </div>

                    {this.state.creating && <Backdrop/>}
                    {this.state.creating &&
                    <Login title="Войти" googleAuth={this.GoogleAuth} canCancel={this.googleXD} canConfirm
                           onExit1={this.onExit1}>

                    </Login>}
                </React.Fragment>
            </header>

        )
    }

}

export default Header;