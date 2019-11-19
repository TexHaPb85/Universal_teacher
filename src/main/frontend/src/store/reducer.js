const initialState = {
    persons: {},
    isLogged: false,
    creating: false,
};

const reducer = (state = initialState, action) => {

    if (action.type === "FETCH_START") {
        window.open("http://localhost:8081/login");
        return {...state}
    }
    if (action.type === "FETCH_START1") {

        return {...state}
    }
    if (action.type === "loginData") {
        state.persons = action.payload;
        console.log(action.payload);
        if (state.persons === null) {

            state.isLogged = false
        } else if (state.persons !== undefined) {

            state.isLogged = true;
                state.creating = false;
        }

        console.log(state.isLogged);
        console.log(state);
        return {...state};
    }
    if (action.type === "deadData") {
        // newState.persons = action.error
    }
    if (action.type === "ON_LOGOUT") {
        return {initialState}
    }
    if (action.type === "CREATE_MOD") {
        return {...state, creating: true}
    }

    if (action.type === "EXIT_MOD") {
        return {...state, creating: false}
    }
    if (action.type === "LOGIN_WINDOW") {
        return {...state, creating: false}
    }


    return state;

};

export default reducer;