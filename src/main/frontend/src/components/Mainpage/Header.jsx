import React, {Component} from 'react';
import header from '../../css/header.css';
import logotype from "../../imgs/logotype.png"
import Login from "./Login"
import Backdrop from "./Backdrop";
import {NavLink, Route, withRouter} from "react-router-dom";
import {connect} from "react-redux";
import {bindActionCreators} from 'redux';
import {googleAuth, loginData} from "../../actions/personActions"
import StickyHeader from 'react-sticky-header';
import 'react-sticky-header/styles.css';
class Header extends Component {






    componentWillMount() {

        this.props.loginData(loginData());
    }

    render() {

        return (

            <StickyHeader header={

                <React.Fragment>
                    {/*<NavLink to={"/"}>*/}
                    <img src={logotype} alt="ekekke" className="Logo" useMap={"#Logo"} />
                    <map name={"Logo"}>
                        <NavLink replace={this.props.location.pathname === "/"} to={"/"} >
                            <area shape={"rect"}  coords={"110,47,320,72"} />
                            <area shape={"poly"}  coords={"20,0,0,50,50,103.5,100,50,45,0"} />
                        </NavLink>
                    </map>
                    {/*</NavLink>*/}
                    <div class='container'>
                        <div className='item1'>

                        </div>

                        {/*<Async>*/}

                            {(!this.props.isLogged) ? <ul className="item2">
                                {/*{this.state.persons.map(person => <li>{person}</li>)}*/}

                                <li className='btnh1'><NavLink to='#'>Учиться </NavLink></li>
                                <li className='btnh2'><NavLink to='#'> Стать автором </NavLink></li>
                                <li className="login"><NavLink to='#'
                                                               onClick={this.props.createEventHandler}>Войти </NavLink>
                                </li>
                            </ul> : <ul className="loggedHeader">


                                <li><NavLink replace={this.props.location.pathname === "/home"}
                                             to="/home">Профиль</NavLink></li>
                                <li><NavLink  replace={this.props.location.pathname === "/courses"} to="/courses">Курсы</NavLink></li>
                                <li><NavLink to="#">Помощь</NavLink></li>
                                <li><NavLink to="/" onClick={this.props.onLogout}>Выход</NavLink></li>

                            </ul>}

                        {/*</Async>*/}

                    </div>

                    {this.props.creating && <Backdrop closeModal={this.props.closeModal}/>}
                    {this.props.creating &&
                    <Login title="Войти" googleAuth={this.props.googleAuth} onRegister={this.props.onRegister}
                           canConfirm
                           onExit1={this.props.onExit1}>

                    </Login>}
                </React.Fragment>}>
                <React.Fragment>
                    <img src={logotype} alt="ekekke" className="Logo"/>
                    <div class='container'>
                        <div className='item1'>

                        </div>

                        {/*<Async>*/}
                        <Route>
                            {(!this.props.isLogged) ? <ul className="item2">
                                {/*{this.state.persons.map(person => <li>{person}</li>)}*/}

                                <li className='btnh1'><NavLink to='#'>Учиться </NavLink></li>
                                <li className='btnh2'><NavLink to='#'> Стать автором </NavLink></li>
                                <li className="login"><NavLink to='#'
                                                               onClick={this.props.createEventHandler}>Войти </NavLink>
                                </li>
                            </ul> : <ul className="loggedHeader">


                                <li><NavLink replace={this.props.location.pathname === "/home"}
                                             to="/home">Профиль</NavLink></li>
                                <li><NavLink to="#">Курсы</NavLink></li>
                                <li><NavLink to="#">Помощь</NavLink></li>
                                <li><NavLink to="/" onClick={this.props.onLogout}>Выход</NavLink></li>

                            </ul>}
                        </Route>
                        {/*</Async>*/}

                    </div>

                    {this.props.creating && <Backdrop closeModal={this.props.closeModal}/>}
                    {this.props.creating &&
                    <Login title="Войти" googleAuth={this.props.googleAuth} onRegister={this.props.onRegister}
                           canConfirm
                           onExit1={this.props.onExit1}>

                    </Login>}
                </React.Fragment>

            </StickyHeader>

        )


    }

}

const mapDispatchToProps = (dispatch) => {

    return {

        loginData: bindActionCreators(loginData, dispatch),
        onLogout: () => dispatch({type: "ON_LOGOUT"}),

        onRegister: () => dispatch({type: "LOGIN_WINDOW"}),

        googleAuth: bindActionCreators(googleAuth, dispatch),

        // createEventHandler: bindActionCreators(ModalOpen,dispatch),
        closeModal: () => {
            dispatch({type: "EXIT_MOD"})
        },

        createEventHandler: () => {
            dispatch({type: "CREATE_MOD"})
        },


        onExit1: () => {
            dispatch({type: "EXIT_MOD"})
        }


    }
};
const mapStateToProps = (state) => {


    return {
        creating: state.creating,
        persons: state.persons,
        isLogged: state.isLogged,

    }
};

export default withRouter(connect(mapStateToProps, mapDispatchToProps)(Header));