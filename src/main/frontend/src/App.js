import React from 'react';
import Login from "./components/Mainpage/Login";
import  Header from "./components/Mainpage/Header";
import  Home from "./components/Mainpage/Home";
import Footer from "./components/Mainpage/Footer";
import Reviews from "./components/Mainpage/Reviews";
import Content from "./components/Mainpage/Content";
import Mainpage from "./components/Mainpage/MainPage"

import Homepage from "./components/Homepage/HomePage"
import './App.css';


import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link,
    Redirect
} from "react-router-dom";


class App extends React.Component{

render() {


    return (

      <Router>
          <div></div>
          <Header persons=""/>
          <Switch>
              <Redirect from="htpp://localhost:8081/" to={"main"}/>
              <Redirect from="/" to="main" exact/>
              <Route path="/main" component={Mainpage}/>
              <Route path="/home" component={Homepage}/>
          </Switch>
          <Footer/>
      </Router>

  );



}
}

export default App ;
