import React, { useEffect , useState } from 'react'
import axios from "axios";
import Swal from 'sweetalert2'
import Error from "../components/Error";
import Loader from "../components/Loader";
import Success from '../components/Success';
import StripeCheckout from 'react-stripe-checkout';
import generateUniqueId from 'generate-unique-id';

import moment from "moment"
import AOS from 'aos';
import 'aos/dist/aos.css';
AOS.init();
AOS.refresh()
function Bookingscreen({match}) {
    console.log(match)
    const[loading, setloading]=useState(true);
    const[error, seterror]=useState(false)
    const[success, setsuccess]=useState(false)   
    const[room , setroom]=useState()
    const roomid=match.params.roomid
    const fromdate=moment(match.params.fromdate , 'DD-MM-YYYY')
    const todate=moment(match.params.todate,'DD-MM-YYYY')
    const totalDays = moment.duration(todate.diff(fromdate)).asDays()+1
    console.log(totalDays)
    const [totalAmount , settotalAmount]=useState()
    const [transactionId, settransactionId] = useState("")
    useEffect(async() => {
        settransactionId(() => generateUniqueId({
            length: 8,
            useLetters: false
          }))
        try {
            setloading(true);
            const data = await (await axios.get(`http://localhost:8685/rooms/${roomid}`)).data;
            setroom(() => data);
            setloading(false);
            settotalAmount(() => data.rentperday * totalDays)
          } catch (error) {
            console.log(error);
            setloading(false);
          } finally {
              console.log(totalAmount)
          }
          
    }, [])


    async function tokenHander(token) {
        const bookingDetails ={
            transactionid: token.id,
            username : JSON.parse(localStorage.getItem('currentUser')),
            roomid: room.id,
            name: room.name,
            fromdate: fromdate,
            todate: todate,
            totaldays: totalDays,
            totalamount: totalAmount,
            status: "confirmed"
        }
        console.log(bookingDetails)

        try {
            setloading(true);
            const result = await axios.post(`http://localhost:8684/booking` , bookingDetails)
            setloading(false)
            Swal.fire('Congrats' , 'Your Room has booked succeessfully' , 'success').then(result=>{
                window.location.href='/profile'
            })
        } catch (error) {
            console.log(error);
            setloading(false)
            Swal.fire('Oops' , 'Something went wrong , please try later' , 'error')
        }
        
    }

    return (
        <div className='m-5'>
            
            {loading ? (<Loader/>) : error ? (<Error/>) : (

                <div className="row p-3 mb-5 bs" data-aos='flip-right' duration='2000'>

                      <div className="col-md-6 my-auto">
                        
                         <div>
                         <h1> {room.name}</h1>
                           <img src={room.imageurls[0]} style={{height:'400px'}} />
                         </div>

                      </div>
                      <div className="col-md-6 text-right">
                           <div>
                           <h1><b>Booking Details</b></h1>
                           <hr />

                           <p><b>Name</b> : {JSON.parse(localStorage.getItem('currentUser'))}</p>
                           <p><b>From Date</b> : {match.params.fromdate}</p>
                           <p><b>To Date</b> : {match.params.todate}</p>
                           <p><b>Max Count </b>: {room.maxcount}</p>
                           </div>
                           
                           <div className='mt-5'>
                           <h1><b>Amount</b></h1>
                           <hr />
                           <p>Total Days : <b>{totalDays}</b></p>
                           <p>Rent Per Day : <b>{room.rentperday}</b></p>
                           <h1><b>Total Amount : {totalAmount} /-</b></h1>

                           <StripeCheckout
            amount={totalAmount*100}
            shippingAddress
            token={tokenHander}
            stripeKey='pk_test_51IYnC0SIR2AbPxU0TMStZwFUoaDZle9yXVygpVIzg36LdpO8aSG8B9j2C0AikiQw2YyCI8n4faFYQI5uG3Nk5EGQ00lCfjXYvZ'
            currency='INR'
            >

                  
                  <button className='btn btn-primary'>Pay Now</button>

            </StripeCheckout>
                           </div>
                          

                           
                      </div>

                </div>

            )}
        
        </div>
    )
}

export default Bookingscreen
