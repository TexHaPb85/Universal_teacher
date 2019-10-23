import React, { Component } from 'react';
import header from '../css/header.css';
import logotype from "../imgs/logotype.png"
class Header extends  Component{
 render() {

return(
    <header>
        <img src={logotype} alt="ekekke" className="Logo"/>
     <div class = 'container'>
        <div class ='item1'>

        </div>
       <ul class="item2">
           <li class ='btnh1'><a href='#'>Учиться </a></li>
           <li class ='btnh2' ><a href='#' > Стать автором </a></li>
           <li class="login"><a href='#'>Войти </a></li>
       </ul>

     </div>
    </header>
)
 }

}


export default Header;