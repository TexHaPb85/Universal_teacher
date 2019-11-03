import React, { Component } from 'react';
import header from '../../css/header.css';
import logotype from "../../imgs/logotype.png"
import Login from "./Login"
import Backdrop from "./Backdrop";
import {Link} from "react-router-dom";

class Header extends  Component{


    state ={
        creating:false
    };
    createEventHandler =() =>{
        this.setState({creating:true})
    }
    onExit1  =() =>{
        this.setState({creating:false})
    }
    onExit2 =() =>{
        if(onauxclick == Login){
            this.setState({creating:false})
        }
    }
    render() {
return(


    <header>

        <React.Fragment>
        <img src={logotype} alt="ekekke" className="Logo"/>
     <div class = 'container'>
        <div class ='item1'>

        </div>
       <ul class="item2">
           <li class ='btnh1'><Link to='#'>Учиться </Link></li>
           <li class ='btnh2' ><Link to='#' > Стать автором </Link></li>
           <li class="login"><Link to='#' onClick={this.createEventHandler}>Войти </Link></li>
       </ul>

     </div>

            {this.state.creating && <Backdrop/>}
            {this.state.creating && <Login title="Войти" canCancel canConfirm  onExit1={this.onExit1}>
                <p>Modal content</p></Login>}
        </React.Fragment>
    </header>

)
 }

}


export default Header;