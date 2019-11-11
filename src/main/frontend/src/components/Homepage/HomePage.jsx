import React, { Component } from 'react';
import Header from "../Mainpage/Header"
import "../../css/content.css"
class HomePage extends  Component{
constructor(props){
    super(props);
    this.state ={
        data  : []
    }
}



   componentDidMount() {

   }
    rofl(){
        this.setState({data: Header.state.persons})
    }

    render() {

        return(
            <React.Fragment>
            {/*<Header data ={this.props.persons}/>*/}

            <section class="container-content">
             <h1>{}</h1>
            </section>
            </React.Fragment>
        )
    }

}


export default HomePage;