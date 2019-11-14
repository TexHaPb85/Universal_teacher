import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import * as serviceWorker from './serviceWorker';
import {createStore,applyMiddleware} from "redux";
import {Provider} from "react-redux"
import reducer from './store/reducer'
import thunk from "redux-thunk";
import {createLogger,logger} from "redux-logger"
import {saveState,loadState} from "./localStorage";
const persistedState = loadState();
const store = createStore(reducer,persistedState,applyMiddleware(thunk,createLogger()));
// store.dispatch((dispatch) =>{
//     dispatch({type:"loginData"})`
//
// })
store.subscribe( () =>{
    localStorage.setItem('reduxState', JSON.stringify(store.getState()))
    // localStorage.getItem("reduxState");

    // console.log(store.state)
});

ReactDOM.render(<Provider store={store}><App /></Provider>, document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();

export default store;