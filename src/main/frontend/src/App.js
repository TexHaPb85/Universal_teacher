import React from 'react';
import Login from "./components/Login";
import  Header from "./components/Header";
import  Home from "./components/Home";
import Footer from "./components/Footer";
import Reviews from "./components/Reviews";
import './App.css';

import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link
} from "react-router-dom";
import Content from "./components/Content";
function App() {
  return (
    <Router>
      <div>
        <Header />
        {/*<Route  path="/heh" exact component={Login} />*/}
        <Home/>

        <Content/>
        <Reviews/>
        <Footer/>
      </div>


    </Router>
  );
}

export default App;
