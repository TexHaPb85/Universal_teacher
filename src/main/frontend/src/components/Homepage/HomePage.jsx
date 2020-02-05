import React, {Component} from 'react';

import "../../css/homePage.css"
import {connect} from "react-redux";


class HomePage extends Component {




    render() {

        return (
            <React.Fragment>
                <section className={"profile"}>

                    <div className="profile-section">

                        <div className={"profile-photo"}>
                            <img className="profile-img" src={this.props.persons.profile.photoURL} alt="Profile photo"/>
                            <span>Загрузить фото</span><button type="file">Обзор</button>
                        </div>
                        <div className={"profile-info"}>
                            <p>{this.props.persons.profile.login}</p>
                            <p>Статус : </p>
                            <p>Опыт :</p>
                            <p>Уровень :  </p>
                        </div>
                        <div className={"profile-menu"}>
                            <ul >
                                <li>Меню</li>
                                <li>Меню</li>
                                <li>Меню</li>
                            </ul>
                        </div>

                    </div>

                    <div className={"achiv-heading"}><h2>Ваши достижения</h2></div>

                    <div  className={"achievments"}>
                        <div className={"triangle-achiev"}> </div>
                        <ul className={"achiv-img"}>
                        <ul >
                            <li><h3>Ачивка</h3></li>
                            <li><img  src={this.props.persons.profile.photoURL} alt="1"/></li>
                        </ul>
                        <ul >
                            <li><h3>Ачивка</h3></li>
                            <li><img  src={this.props.persons.profile.photoURL} alt="1"/></li>
                        </ul>
                        <ul className={"center-achieve"}>
                            <li><h3>Ачивка</h3></li>
                            <li><img  src={this.props.persons.profile.photoURL} alt="1"/></li>
                        </ul>
                        <ul >
                            <li><h3>Ачивка</h3></li>
                            <li><img  src={this.props.persons.profile.photoURL} alt="1"/></li>
                        </ul>
                        <ul>
                            <li><h3>Ачивка</h3></li>
                            <li><img  src={this.props.persons.profile.photoURL} alt="1"/></li>
                        </ul>
                        </ul>
                        <div className={"triangle-achiev-after"}> </div>
                    </div>
                </section>
            </React.Fragment>
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

export default connect(mapStateToProps, mapDispatchToProps)(HomePage);