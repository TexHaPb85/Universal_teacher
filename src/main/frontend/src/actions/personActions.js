import axios from "axios"
import login from "../services/login"

export const googleAuth = () => {
    return function (dispatch) {
        dispatch({type: "FETCH_START"});
        login.googleAuth().then((res) => dispatch({
            type: "loginData",
            payload: res.data.profile
        })).catch((response) => dispatch({
            type: "deadData",
            error: response.error
        }))

    }
};
export const loginData = () => {
    return function (dispatch) {
        dispatch({type: "FETCH_START1"});
        login.googleAuth().then((res) => dispatch({
            type: "loginData",
            payload: res.data.profile
        })).catch((response) => dispatch({
            type: "deadData",
            error: response.error
        }))

    }
};

export const ModalOpen = () => {
    return function (dispatch) {
        // dispatch({type:"START_CREATE_MOD"});
        setTimeout(() => {
            dispatch({type: "CREATE_MOD"})
        }, 2000)


    }


};