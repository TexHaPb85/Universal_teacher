import React from "react";
import "../../css/backdrop.css"

const backdrop = (props) => <div>{props.closeModal && <div className="backdrop" onClick={props.closeModal}></div>}</div>

export default backdrop;