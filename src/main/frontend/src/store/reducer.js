import login from "../services/login";
import Header from "../components/Mainpage/Header"
import { persistStore, persistReducer } from 'redux-persist'
import storage from 'redux-persist/lib/storage'
const initialState = {
    persons :{},
    isLogged :false,
    auth:false,
    creating:false,
};



const reducer = (state = initialState, action) => {
               // var state = [...initialState];
            if(action.type ==="FETCH_START"){
                return {...state}
            }
            if(action.type ==="loginData"){
                // console.log("BVLYAT")
                state.persons = action.payload;
                console.log(action.payload);
                if(state.persons === null){
                    state.auth = false;state.isLogged = false
                }
                else if(state.persons !== undefined ){
                    state.auth = true; state.isLogged = true
                }

                console.log(state.isLogged);
                console.log(state);
               return {...state};



            }
            if(action.type ==="deadData"){
                // newState.persons = action.error
            }
            // else{ return state;}

            return state;

};

export default reducer;