import axios from 'axios'


const  WEB_API_URL = 'http://localhost:8081';
const LOGIN_API_URL = `${WEB_API_URL}/login`;

class Login {

 googleAuth(){
     return axios.get(`${LOGIN_API_URL}`,{headers: {"Content-Type": "application/json"}});
 }

}

export default new Login()
