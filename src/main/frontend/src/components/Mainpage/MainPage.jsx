import React, {Component} from 'react';
import Home from "./Home";
import Reviews from "./Reviews";
import Content from "./Content";


class MainPage extends Component {


    render() {
        return (
            <div>
                <Home/>
                <Content/>
                <Reviews/>
            </div>


        )
    }

}


export default MainPage;