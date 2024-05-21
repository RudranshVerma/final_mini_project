import { useEffect, useState } from "react";
import UserNavbar from "./usernavbar";
import AdminNavbar from "./adminnavbar";
import StudentNavBar from "./studentNavBar";

const NavBar = () => {
    
    const [userRole, setUserRole] = useState("");

    useEffect(() => {
        setUserRole(localStorage.getItem("role"))
    },[])

    const handleNavBar = () => {
        return (userRole === 'Student')?  <StudentNavBar/>:(userRole === 'admin')? <AdminNavbar /> : <UserNavbar />;
    }
    return (
        <div>
            {handleNavBar()}
        </div>
    );
}

export default NavBar;