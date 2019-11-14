

const initialState = {
    persons: {},
    isLogged: false,
    auth: false,
    creating: false,
};

const reducer = (state = initialState, action) => {
    // var state = [...initialState];
    if (action.type === "FETCH_START") {
        return {...state}
    }
    if (action.type === "loginData") {
        // console.log("BVLYAT")
        state.persons = action.payload;
        console.log(action.payload);
        if (state.persons === null) {
            state.auth = false;
            state.isLogged = false
        } else if (state.persons !== undefined) {
            state.auth = true;
            state.isLogged = true
        }

        console.log(state.isLogged);
        console.log(state);
        return {...state};
    }
    if (action.type === "deadData") {
        // newState.persons = action.error
    }
    if(action.type ==="START_CREATE_MOD"){
        return {...state}
    }
    if (action.type === "CREATE_MOD") {
        return {...state, creating: true}
    }
    if(action.type ==="STARTEXITMOD"){
        return {...state, creating:true}
    }
    if (action.type === "EXITMOD") {
        return {...state, creating: false}
    }


    return state;

};

export default reducer;