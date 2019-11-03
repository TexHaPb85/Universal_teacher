import React, { Component } from 'react';
import Slider from "./Slider";
import "../../css/content.css"
class Content extends  Component{
    render() {

        return(
            <section class="container-content">
                 <h1>Выбери свой путь!</h1>
                <Slider/>
            </section>

        )
    }

}


export default Content;