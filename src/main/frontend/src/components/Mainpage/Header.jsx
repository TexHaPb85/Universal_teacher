import React, {Component} from 'react';
import header from '../../css/header.css';
import logotype from "../../imgs/logotype.png"
import Login from "./Login"
import Backdrop from "./Backdrop";
import {Link} from "react-router-dom";
import Async from "react-async"
import login from "../../services/login"
import {connect} from "react-redux";

import {bindActionCreators} from 'redux';
import {googleAuth,ModalOpen} from "../../actions/personActions"
import store from "../../index"








class Header extends Component {


        //
        // state = {
        //     // isLogged: false,
        //     creating: false,
        //     // persons: {},
        //     // auth: false
        //
        // }


    // createEventHandler = () => {
    //     this.setState({creating: true})
    // };
    // onExit1 = () => {
    //     this.setState({creating: false})
    // };



    componentWillUpdate(nextProps, nextState, nextContext) {
    }


    render() {

        return (

            <header>

                <React.Fragment>
                    <img src={logotype} alt="ekekke" className="Logo"/>
                    <div class='container'>
                        <div className='item1'>

                        </div>
                        {/*<Async>*/}
                            {(!this.props.isLogged) ? <ul className="item2">
                                {/*{this.state.persons.map(person => <li>{person}</li>)}*/}
                                <li className='btnh1'><Link to='#'>Учиться </Link></li>
                                <li className='btnh2'><Link to='#'> Стать автором </Link></li>
                                <li className="login"><Link to='#' onClick={this.props.createEventHandler}>Войти </Link>
                                </li>
                            </ul> : <ul className="loggedHeader">
                                <li><Link to="/home">Профиль</Link></li>
                                <li><Link to="#">Мои Курсы</Link></li>
                                <li><Link to="#">Помощь</Link></li>
                            </ul>}
                    {/*</Async>*/}

                    </div>

                    {this.props.creating && <Backdrop/>}
                    {this.props.creating &&
                    <Login title="Войти" googleAuth={this.props.googleAuth} canCancel={this.props.canCancel} canConfirm
                           onExit1={this.props.onExit1}>

                    </Login>}
                </React.Fragment>


            </header>

        )


    }

}
const mapDispatchToProps = (dispatch) => {

  return {

      googleAuth: bindActionCreators(googleAuth, dispatch),

      // createEventHandler: bindActionCreators(ModalOpen,dispatch),
      createEventHandler: () => {
          dispatch({type: "CREATE_MOD"})
      },


      onExit1: () => {
          dispatch({type: "EXITMOD"})
      }


  }
};
const mapStateToProps = (state) => {


    return{
        creating : state.creating,
        persons: state.persons,
        isLogged : state.isLogged,
        auth : state.auth

}
};

export default connect(mapStateToProps,mapDispatchToProps)(Header);