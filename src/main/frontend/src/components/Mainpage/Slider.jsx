import React from 'react';
import Flickity from 'react-flickity-component/src/index'
import Image1 from '../../imgs/content-carousel/englishImg.jpg';
import Image2 from '../../imgs/content-carousel/javaImg.jpg';
import Image3 from '../../imgs/content-carousel/mathImg.jpg';
import {Link,Route} from "react-router-dom";
import "../../css/content.css"

const flicopt = {
    initialIndex: 1,
    wrapAround: true,
    // imagesLoaded:true,
    lazyLoad: true,
    // fade:true,
    groupCell:3,
    pageDots:false,

};

function Slider ()
{
        return(
    <Flickity
        className='carousel' // default ''
        elementType={'div'} // default 'div'
        options={flicopt} // takes flickity options {}
        disableImagesLoaded={false} // default false
        reloadOnUpdate // default false
        static // default false
    >
        <div className="carousel-cell"><img src={Image1}/>

              <Link className={"link-cell"} to={"/"}>
                  <h2> Английский</h2>
                  <p>В этом курсе вам раскажут как прожить и многое другое</p>
              </Link>

        </div>
        <div className="carousel-cell"><img src={Image2}/>

                <Link className={"link-cell"} to={"/"}><h2>Программирование</h2></Link>

        </div>
        <div className="carousel-cell"><img src={Image3}/>

                <Link className={"link-cell"} to={"/"}><h2>Математика</h2></Link>
            </div>




    </Flickity>);
}
export default Slider;