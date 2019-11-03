import React from 'react';
import Flickity from 'react-flickity-component/src/index'
import Image1 from '../../imgs/content-carousel/kirito.jpg';
import Image2 from '../../imgs/content-carousel/jabato.jpg';
import Image3 from '../../imgs/content-carousel/tobato.jpg';
import Image4 from '../../imgs/content-carousel/kirito.jpg';
import Image5 from '../../imgs/content-carousel/kirito.jpg';
import "../../css/content.css"

const flicopt = {
    initialIndex: 1,
    freeScroll: true,
    wrapAround: true,
    imagesLoaded:true,
    // lazyLoad: 2,
    fade:true,
    groupCell:3,
    pageDots:false
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
        <div className="carousel-cell"><img src={Image1}/></div>
        <div className="carousel-cell"><img src={Image2}/></div>
        <div className="carousel-cell"><img src={Image3}/></div>
        <div className="carousel-cell"><img src={Image1}/></div>
        <div className="carousel-cell"><img src={Image2}/></div>
        <div className="carousel-cell"><img src={Image3}/></div>


    </Flickity>);
}
export default Slider;