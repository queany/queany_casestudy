import React, { useEffect } from "react";
// import moment from "moment"
import AOS from 'aos';
import 'aos/dist/aos.css';
import { Link } from "react-router-dom";
// import generateUniqueId from 'generate-unique-id';
AOS.init({
    duration:'2000'
});
function Landingscreen() {
  // useEffect(() => {
  //   console.log(generateUniqueId({
  //     length: 12,
  //     useLetters: false
  //   }));
  // }, [])
  return (
    <div className="">
      <div className="landing row justify-content-center text-center">
        <div className="col-md-9 my-auto" style={{borderRight:'8px solid white'}}>
          <h2 style={{ color: "white", fontSize: "130px" }} data-aos='zoom-in'>SheyRooms</h2>
          <h1 style={{ color: "white"}} data-aos='zoom-out' >“There is only one boss. The Guest.</h1>
          <Link to="/home">
             <button className='btn btn-primary'>Get Started</button>
          </Link>
        </div>

        
        
      </div>
     
    </div>
  );
}

export default Landingscreen;
