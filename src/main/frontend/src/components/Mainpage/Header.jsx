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
import {googleAuth,onRefresh} from "../../actions/personActions"
import store from "../../index"








class Header extends Component {



        state = {
            // isLogged: false,
            creating: false,
            // persons: {},
            // auth: false

        }


    createEventHandler = () => {
        this.setState({creating: true})
    };
    onExit1 = () => {
        this.setState({creating: false})
    };





    componentDidMount() {

        // this.props.onRefresh
        // When state will be updated(in our case, when items will be fetched),
            // we will update local component state and force component to rerender
            // with new data.



    }

      // mapDispatchToProps();
      //   mapStateToProps();
        // console.log(this.props)
    //     login.googleAuth()
    //         .then(res => {
    //
    //                 this.setState({persons: res.data.profile}, () => {
    //                     if (this.state.persons === null) {
    //                         this.setState({auth: false, isLogged: false}, () => {
    //                             console.log(this.state.auth)
    //                             console.log(this.state.persons)
    //                         })
    //                     } else if (!this.state.persons !== undefined) {
    //                         this.setState({auth: true, isLogged: true}, () => {
    //                             console.log(this.state.persons);
    //                             console.log(this.state.auth)
    //                         });
    //                     }
    //
    //                 });
    //             }
    //         ).catch(res => console.log(res.message));
    // }


    googleXD = () => {
        // console.log(this.state.persons)

    };
    // GoogleAuth = async () => {
    //     // window.open("http://localhost:8081/login", "_self");
    //
    //
    // };

    render() {

        return (

            <header>

                <React.Fragment>
                    <img src={logotype} alt="ekekke" className="Logo"/>
                    <div class='container'>
                        <div className='item1'>

                        </div>
                        <Async>
                            {(!this.props.isLogged) ? <ul className="item2">
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
                    <Login title="Войти" googleAuth={this.props.googleAuth} canCancel={this.googleXD} canConfirm
                           onExit1={this.onExit1}>

                    </Login>}
                </React.Fragment>


            </header>

        )


    }

}
const mapDispatchToProps = (dispatch) => {

  return {

      googleAuth : bindActionCreators(googleAuth,dispatch)

  }


};
const mapStateToProps = (state) => {


    return{
        persons: state.persons,
        isLogged : state.isLogged,
        auth : state.auth

}
};

export default connect(mapStateToProps,mapDispatchToProps)(Header);