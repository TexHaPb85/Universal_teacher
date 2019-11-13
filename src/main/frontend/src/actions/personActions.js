import axios from "axios"
import login from "../services/login"

export const googleAuth = () => {
    return function (dispatch) {
        dispatch({type:"FETCH_START"});
        login.googleAuth().then((res) => dispatch({
            type: "loginData",
            payload: res.data.profile
        })).catch((response) => dispatch({
            type: "deadData",
            error: response.error
        }))

    }


};
export const onRefresh = () => {
    return function (dispatch) {

        login.googleAuth().then((res) => dispatch({
            type: "refresh",
            payload: res.data.profile
        })).catch((response) => dispatch({
            type: "deadData",
            error: response.error
        }))

    }


};