import login from "../services/login";
import Header from "../components/Mainpage/Header"


const initialState = {
    persons : {},
    isLogged :false,
    auth:false

};

const reducer = (state = initialState, action) => {

            if(action.type ==="loginData"){
                // console.log("BVLYAT")

                // console.log(action.payload);
                // if(state.persons === null){
                //     state.auth = false;state.isLogged = false
                // }
                // if(!this.state.persons !== undefined ){
                //     state.auth = true; state.isLogged = true
                // }
                console.log(action.payload);


               return[...state, action.payload ];



            }
            if(action.type ==="deadData"){
                // newState.persons = action.error
            }

            return state;

};

export default reducer;