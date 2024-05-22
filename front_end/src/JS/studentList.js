import axios from "axios";
import React, { useEffect, useState } from "react";
import { Button } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import "../CSS/userform.css";
import UserForm from "./userform";
import Layout from "./layout";
export default function UserList() {
  const handleDeleteUser = (id) => {
    if (window.confirm("Are you sure you want to delete this data?")) {
      axios
        .delete("http://localhost:8080/deleteUserById/" +
         `${id}`)
        .then((response) => {
          console.log("Delete Successful");
          toast.success("Deleted Successfully");
        })
        .catch((error) => console.log(error));
    }
  };
    const [users, setUsers] = useState([]);
    const navigate = useNavigate();
    const rows = users.map((user) => {
      if(String(user.role)==="Student"){
    return (
    <tr key={user.userId}>
      <td style={{ padding: "15px" }}>{user.userId}</td>
      <td style={{ padding: "15px" }}>{user.userName}</td>
      <td style={{ padding: "15px" }}>{user.password}</td>
      <td style={{ padding: "15px" }}>{user.emailId}</td>
      <td style={{ padding: "15px" }}>{user.role}</td>
      <td style={{ padding: "15px" }}>{user.attendance}</td>
      <td>
          <div className="btn-group gap-4" role="group">
            <button
              type="button"
              className="btn btn-danger"
              style={{ borderRadius: "4px" }}
              onClick={() => {
                handleDeleteUser(user.userId);
              }}
            >
              Delete
              </button>
          </div>
        </td>
    </tr>
  );
}
});

  useEffect(() => {
    axios
      .get("http://localhost:8080/getAllUsers")
      .then((response) => {
        if(response.data)
        setUsers(response.data);
      })
      .catch((error) => console.log(error));
  }, [users]);
  return (
    <Layout>

    <div>
      
      <div class="container" style={{ alignContent: "center" }}>
        <div class="row">
          <div class="col-md-6">
            <div class="userformcard">
              <div class="text-center">
                <h1>Student Details</h1>
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
                  <tbody>{rows}</tbody>
                </table>
              </div>
              <div className="btn-group gap-4" role="group">
                <Button
                  className="btn btn-primary"
                  onClick={() => {
                    navigate("/userForm");
                    <UserForm></UserForm>;
                  }}
                >
                  Add New Student
                </Button>
                <button
                  type="button"
                  className="btn btn-primary"
                  style={{ borderRadius: "4px" }}
                  onClick={() => {
                    navigate("/userupdate")
                  }}
                >
                  Edit
                </button>
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
