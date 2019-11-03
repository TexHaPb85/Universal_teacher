import React, { Component } from 'react';
import home from "../../css/home.css"
class Home extends  Component{
    render() {

        return(
            <section className="container-home">
                <div className="img">
                    <div className="overlay">
                        <div id="triangle-left"></div>
                        <div id="pentagon"></div>
                        <div className="home-text">
                            <h2>Получите востребованные<br/>знания бесплатно</h2>
                            <p>Онлайн-курсы от ведущих вузов и компаний страны</p>
                            <button  className="home-button1">Посмотреть <br/>каталог</button>
                        </div>
                    </div>


                </div>


            </section>

        )
    }

}



export default Home;