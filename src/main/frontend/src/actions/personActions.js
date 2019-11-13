import axios from "axios"
import login from "../services/login"

export const googleAuth = () => {
    return function (dispatch) {

        login.googleAuth().then((res) => dispatch({
            type: "loginData",
            payload: res
        })).catch((response) => dispatch({
            type: "deadData",
            error: response.error
        }))

    }


};