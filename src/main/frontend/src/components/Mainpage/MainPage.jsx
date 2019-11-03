import React, { Component } from 'react';
import  Header from "./Header";
import  Home from "./Home";
import Footer from "./Footer";
import Reviews from "./Reviews";
import Content from "./Content";

class MainPage extends Component{


    render() {
        return(

            <div>
            <Header />
            <Home/>
           <Content/>
            <Reviews/>
            <Footer/>

            </div>


        )
    }

}


export default MainPage;