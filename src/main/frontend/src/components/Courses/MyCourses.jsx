import React, {Component} from 'react';
import "../../css/courses.css"
import {connect} from "react-redux";
import {NavLink, withRouter} from "react-router-dom";

class MyCourses extends Component {

    render() {

        return (
            <section className={"all-courses"}>
                <h1>Курсы</h1>
                    <ul className={"courses-menu"}>
                        <li><NavLink to={"/courses"}>Все курсы</NavLink></li>
                        <li><NavLink replace={window.location.pathname === "/courses/my-courses"}  to={"/courses/my-courses"}>Мои курсы</NavLink></li>


                    </ul>
                <h1>LULULLULUL</h1>
            </section>
        )
    }

}

const mapDispatchToProps = (dispatch) => {

    return {}

};
const mapStateToProps = (state) => {


    return {
        persons: state.persons,
        auth: state.isLogged


    }
};

export default withRouter(connect(mapStateToProps, mapDispatchToProps)(MyCourses));