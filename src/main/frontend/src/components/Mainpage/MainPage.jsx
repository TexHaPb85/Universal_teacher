import React, { Component } from 'react';
import  Header from "./Header";
import  Home from "./Home";
import Footer from "./Footer";
import Reviews from "./Reviews";
import Content from "./Content";
import HomePage from "../Homepage/HomePage";

import {
    Redirect,
    BrowserRouter,
   Router as Router,
    Switch,
    Route,
    Link
} from "react-router-dom";




class MainPage extends Component{


    render() {
        return(

            <div>

            <Home />

           <Content/>
            <Reviews/>


            </div>


        )
    }

}


export default MainPage;