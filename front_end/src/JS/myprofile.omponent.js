import axios from "axios";
import React, { useEffect, useState } from "react";
import { Button } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import "../CSS/userform.css";
import UserForm from "./userform";

export default function UserList() {
  const [users, setUsers] = useState([]);
  const navigate = useNavigate();

  const handleAddAnime = () => {
    navigate("/addanime");
  };

  const handleDeleteUser = (id) => {
    if (window.confirm("Are you sure you want to delete this data?")) {
      axios
        .delete("http://localhost:8080/deleteUserById/" + `${id}`)
        .then((response) => {
          console.log("Delete Successful");
          toast.success("Deleted Successfully");
        })
        .catch((error) => console.log(error));
    }
  };

  const rows = users.map((user) => {
    
    return (
      <tr key={user.userId}>
        <td style={{ padding: "15px" }}>{user.userId}</td>
        <td style={{ padding: "15px" }}>{user.userName}</td>
        <td style={{ padding: "15px" }}>{user.password}</td>
        <td style={{ padding: "15px" }}>{user.emailId}</td>
        <td style={{ padding: "15px" }}>{user.role}</td>
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
            {user.role === "ADMIN" && (
              <button
                type="button"
                className="btn btn-danger"
                style={{ borderRadius: "4px" }}
                onClick={() => {
                  // handleDeleteUser(user.userId);
                  console.log(user.userId);
                  <AddAnime />;
                  handleAddAnime();
                }}
              >
                Add Anime
              </button>
            )}
          </div>
        </td>
      </tr>
    );
  });

  useEffect(() => {
    // let isActive = true;
    axios
      .get("http://localhost:8080/getAllUsers")
      .then((response) => {
        setUsers(response.data);
      })
      .catch((error) => console.log(error));
  }, [users]);

  return (
    
    <div>
      <div class="container" style={{ alignContent: "center" }}>
        <div class="row">
          <div class="col-md-6">
            <div class="userformcard">
              <div class="text-center">
                <h1>SignUp</h1>
                <h6>Register yourself</h6>
              </div>
              <div>
                <table style={{ borderSpacing: "20px" }}>
                  <thead style={{ fontWeight: "bold" }}>
                    <tr>
                      <td style={{ padding: "15px" }}>User ID</td>
                      <td style={{ padding: "15px" }}>User Name</td>
                      <td style={{ padding: "15px" }}>Password</td>
                      <td style={{ padding: "15px" }}>Email Id</td>
                      <td style={{ padding: "15px" }}>Role</td>
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
                  Add New User
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
  );
}
