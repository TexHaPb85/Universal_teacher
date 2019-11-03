import React from 'react';
import Login from "./components/Mainpage/Login";
import  Header from "./components/Mainpage/Header";
import  Home from "./components/Mainpage/Home";
import Footer from "./components/Mainpage/Footer";
import Reviews from "./components/Mainpage/Reviews";
import Content from "./components/Mainpage/Content";
import Mainpage from "./components/Mainpage/MainPage"
import './App.css';

import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link
} from "react-router-dom";

function App() {
  return (
    <Router>
      <div>
        <Mainpage/>
        {/*<Header />*/}
        {/*<Home/>*/}
        {/*<Content/>*/}
        {/*<Reviews/>*/}
        {/*<Footer/>*/}
        {/*/!*<Switch>*!/*/}
        {/*/!*  <Route  path="/heh" exact component={Footer} />*!/*/}
        {/*/!*</Switch>*!/*/}


      </div>


    </Router>
  );
}

export default App;
