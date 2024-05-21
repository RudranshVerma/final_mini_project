import axios from "axios";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { toast } from "react-toastify";

const UserForm = ({ onClose }) => {
  const [username, setusername] = useState();
  const [useremail, setuseremail] = useState();
  const [userpassword, setuserpassword] = useState();
  
  const [userrole, setuserrole] = useState();
  const navigate = useNavigate();

  const handlesignup = async (e) => {
    e.preventDefault();

    await axios
      .post("http://localhost:8080/createUser", {
        userName: username,
        emailId: useremail,
        password: userpassword,
        userRole:userrole
      })
      .then((res) => {console.log(res.data);
        toast.success("user created succesfully")
      navigate("/myprofile")});
    // console.log(username);
    // console.log(useremail);
    // console.log(password);
  };
  const handlecancel=()=>{
    navigate("/myprofile")
  }

  return (
    <div>
      <div class="container">
        <div class="row">
          <div class="col-md-6">
            <div class="signupcard">
              <div class="text-center">
                <h1>Create User</h1>
                <h6>Enter Details of User</h6>
              </div>

              <form onSubmit={handlesignup}>
                <div class="mb-3">
                  <label class="form-label">Full Name</label>
                  <input
                    type="text"
                    class="form-control"
                    value={username}
                    onChange={(e) => {
                      setusername(e.target.value);
                    }}
                  />
                </div>
                <div class="mb-3">
                  <label class="form-label">Email address</label>
                  <input
                    type="email"
                    class="form-control"
                    aria-describedby="emailHelp"
                    value={useremail}
                    onChange={(e) => {
                      setuseremail(e.target.value);
                    }}
                  />
                  <div id="emailHelp" class="form-text">
                    We'll never share your email with anyone else.
                  </div>
                </div>
                <div class="mb-3">
                  <label class="form-label">Password</label>
                  <input
                    type="password"
                    class="form-control"
                    value={userpassword}
                    onChange={(e) => {
                      setuserpassword(e.target.value);
                    }}
                  />
                </div>
                <div class="mb-3">
                  <label class="form-label">Role</label>
                  <input
                    type="text"
                    class="form-control"
                    value={userrole}
                    onChange={(e) => {
                      setuserrole(e.target.value);
                    }}
                  />
                </div>
                <button type="submit" class="btn btn-success">
                  Submit
                </button>
                <button onClick={handlecancel} class="btn btn-warning">
                  Cancel
                </button>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default UserForm;
