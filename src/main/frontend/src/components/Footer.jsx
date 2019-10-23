import React, { Component } from 'react';
import Phone from "../imgs/footer/phone.png"
import Email from "../imgs/footer/email.png"
import footer from "../css/footer.css";
class  Footer extends  Component{
    render() {

        return(
            <footer >
                <div class="container-footer">
                    <div className="phone_number">
                        <img class="phone-img" src={Phone} alt="phone-alt"/>
                        <p> +(380)664558992</p>
                        <br/>
                        <img class="email-img" src={Email} alt="email-alt"/>
                        <p>Email: ubersobaka@gmail.com </p>
                    </div>

                <ul>
                    <li><h4>Навигация</h4></li>
                    <li><a href="#">Домой</a></li>
                    <li><a href="#">Контакты</a></li>
                    <li><a href="#">Курсы</a></li>
                </ul>
                <ul>
                    <li><h4>Присоединяйся</h4></li>
                    <li><a href="#">Учиться</a></li>
                    <li><a href="#">Стать автором</a></li>

                </ul>
                    <ul>
                        <li><h4>Помощь</h4></li>
                        <li><a href="#">FAQ</a></li>
                        <li><a href="#">Поддержка</a></li>
                        <li><a href="#">Контакты</a></li>

                </ul>




                </div>

                <p class="license"><strong>&copy;2020 Universal Teachers Inc</strong></p>
            </footer>

        )
    }

}


export default Footer;