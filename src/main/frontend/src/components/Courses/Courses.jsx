import React, {Component} from 'react';
import {NavLink, Route, withRouter} from "react-router-dom";
import "../../css/courses.css"
import {connect} from "react-redux";

class Courses extends Component {
    constructor (props){
        super(props);
        this.state ={
            bool : false
        }

        this.XD = this.XD.bind(this);

    }
    XD (){
        if(window.location.pathname === "/courses/my-courses"){
          return "replace={true}"
        }
        else {
            return "replace={false}"
            }
        }



    ROFL (){
        this.props.history.push("/courses/my-courses");
        console.log(window.location.pathname)
    }


    // componentWillUpdate(nextProps, nextState, nextContext) {
    //     console.log(this.props.location.pathname)
    // }

    render() {
        // console.log(this.props,"xDXD");
        return (
            <React.Fragment>
            <Route>

                <section className={"courses"}>
                    <h1>Курсы</h1>
                    <ul className={"courses-menu"}>
                        <li><NavLink  onClick={this.XD} replace={window.location.pathname === "/courses"} to={"/courses"}>Все курсы</NavLink></li>
                        <li><NavLink replace={window.location.pathname === "/courses/my-courses"} to={"/courses/my-courses"}>Мои курсы</NavLink></li>


                    </ul>
                </section>



            </Route>
            </React.Fragment>

        )
    }

}

const mapDispatchToProps = (dispatch) => {
    return{}


};
const mapStateToProps = (state) => {


    return {
        persons: state.persons,
        auth: state.isLogged


    }
};

export default withRouter(connect(mapStateToProps, mapDispatchToProps)(Courses));