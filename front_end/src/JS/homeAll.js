import axios from "axios";
import React, { useEffect, useState } from "react";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import "../CSS/userform.css";
import Layout from "./layout";

export default function UserList() {
  const [user, setUsers] = useState([]);
  const [att,setAtt]=useState();

  const handleAttendance =  () => {
  user.attendance++
    setAtt(user.attendance)
    axios.put("http://localhost:8080/updateUserById/"+
    `${user.userId}`+
    '/'+
    `${user.attendance}`
  )
  .then((response) => {
    console.log(response.data)
    user.attendance=response.data
    console.log("changed Successful");
    toast.success("Attendance marked Successfully");
  })
  .catch((error) => console.log(error));
  };

  useEffect(() => {
    axios.get("http://localhost:8080/getUserById/"+
    `${localStorage.getItem("id")}`)
      .then((response) => {
        setAtt(response.data.attendance)
        setUsers(response.data);
      })
      .catch((error) => console.log(error));
      
  },[]);

  return (
  <Layout>
    <div>
      <div class="container" style={{ alignContent: "center" }}>
        <div class="row">
          <div class="col-md-6">
            <div class="userformcard">
              <div class="text-center">
                <h1>My Details</h1>
              </div>
              <div>
                <table style={{ borderSpacing: "20px" }}>
                  <thead style={{ fontWeight: "bold" }}>
                    <tr>
                      <td style={{ padding: "15px" }}>ID</td>
                      <td style={{ padding: "15px" }}>Name</td>
                      <td style={{ padding: "15px" }}>Password</td>
                      <td style={{ padding: "15px" }}>Email Id</td>
                      <td style={{ padding: "15px" }}>Role</td>
                      <td style={{ padding: "15px" }}>Attendance</td>
                      <td style={{ padding: "15px" }}>Action</td>
                    </tr>
                  </thead>
                  <tbody>
                    <tr key={user.userId}>
                      <td style={{ padding: "15px" }}>{user.userId}</td>
                      <td style={{ padding: "15px" }}>{user.userName}</td>
                      <td style={{ padding: "15px" }}>{user.password}</td>
                      <td style={{ padding: "15px" }}>{user.emailId}</td>
                      <td style={{ padding: "15px" }}>{user.role}</td>
                      <td style={{ padding: "15px" }}>{att}</td>
                      <td>
                          <div className="btn-group gap-4" role="group">
                            <button
                              type="button"
                              className="btn btn-success"
                              style={{ borderRadius: "4px" }}                          
                              onClick={handleAttendance}
                            >
                              Attendance
                            </button>
                          </div>
                      </td>
                    </tr>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </div>
      </div>
      <ToastContainer />
    </div>
  </Layout>
  );
}
