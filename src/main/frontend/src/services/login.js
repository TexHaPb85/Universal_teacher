import axios from 'axios'


// const  WEB_API_URL = 'http://localhost:8081';
// const LOGIN_API_URL = `${WEB_API_URL}/login`;

class Login {





     googleAuth() {


        return axios.get(`${'http://localhost:8081/'}`, {
            headers: {
                'Content-Type': 'application/json',
                // 'withCredentials' : 'true',
                //     'credentials' : 'same-origin',


            },withCredentials:true, credentials: "same-origin"
        });

            }

        }

        export default new Login;
