import React, { useState} from "react";
// import {useDispatch , useSelector} from 'react-redux'
import axios from "axios";
import Error from "../components/Error";
import Loader from "../components/Loader";
import Success from '../components/Success'
export default function Registerscreen() {
  const [username, setusername] = useState("");
  const [email, setemail] = useState("");
  const [password, setpassword] = useState("");
  const [cpassword, setcpassword] = useState("");
  const[loading, setloading]=useState(false)
  const[error, seterror]=useState(false)
  const[success, setsuccess]=useState(false) 
  async function register(){

      if(password!==cpassword)
      {
          alert("passwords not matched")
      }
      else{
        try {
          const result = await (await axios.get(`http://localhost:8683/check/${username}`)).data.response
          if (result === 'valid') {
            seterror(false)
            setloading(true)
            const user={
              username,
              email,
              password
            }
            
            try {
              setloading(true)
              const result = await axios.post('http://localhost:8682/subs',user)
              setloading(false)
              setsuccess(true)
              setemail('')
              setusername('')
              setcpassword('')
              setpassword('')
            } catch (error) {
              seterror(true)
              setloading(false)
              console.log(error);
            }
          } else {
            seterror(true)
            setloading(false)
            console.log(error);
          }
        } catch (error) {

        }
             
      }

  }

  return (
    <div className='register'>
      <div className="row justify-content-center mt-5">
        <div className="col-md-5 mt-5 text-left shadow-lg p-3 mb-5 bg-white rounded">

          {loading && (<Loader/>)}
          {success && (<Success success='User Registered Successfully' />)}
          {error && (<Error error='Username already registered' />)}

          <h2 className="text-center m-2" style={{ fontSize: "35px" }}>
            Register
          </h2>
          <div>
            <input required type="text" placeholder="username" className="form-control mt-1" value={username} onChange={(e)=>{setusername(e.target.value)}} />
            <input required type="text" placeholder="email" className="form-control mt-1" value={email} onChange={(e)=>{setemail(e.target.value)}} />
            <input
              type="password"
              placeholder="password"
              className="form-control mt-1"
              value={password}
              required
              onChange={(e)=>{setpassword(e.target.value)}}
            />
            <input
              type="password"
              placeholder="confirm password"
              className="form-control mt-1"
              value={cpassword}
              required
              onChange={(e)=>{setcpassword(e.target.value)}}
            />
            <button onClick={register} className="btn btn-primary rounded-pill mt-3 mb-3">REGISTER</button>
            <br/>
            <a style={{color:'black'}} href="/login">Click Here To Login</a>
          </div>
        </div>
      </div>
    </div>
  );
}