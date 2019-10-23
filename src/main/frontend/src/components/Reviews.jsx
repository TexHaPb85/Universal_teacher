import React, { Component } from 'react';
import content from "../css/content.css"
class Reviews extends  Component{
    render() {

        return(
            <section class="container-content">
                <h1>Выбери свой путь!</h1>
                <div class="showcase-container">
                    <div class="content-img">

                        <div class ="hidden">
                            <h3>Твой курс</h3>
                            <p>Описание курса</p>
                            <button>Перейти</button>
                        </div>
                    </div>

                    <div class="content-img">
                        <div class ="hidden">
                            <h3>Твой курс</h3>
                            <p>Описание курса</p>
                            <button>Перейти</button>
                        </div>
                    </div>
                    <div class="content-img">
                        <div class ="hidden">
                            <h3>Твой курс</h3>
                            <p>Описание курса</p>
                            <button>Перейти</button>
                        </div>
                    </div>


                </div>
            </section>

        )
    }

}


export default Reviews;