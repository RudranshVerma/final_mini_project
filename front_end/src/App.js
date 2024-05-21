import './App.css';
import {Routes,Route} from 'react-router'
import Login from './JS/login.component';

import StudentList from "./JS/studentList";
import TeacherList from "./JS/teacherList";
import Home from "./JS/homeAll"
import UserForm from './JS/userform';

function App() {
  return (
    <div className="App">

            
      <Routes>
          <Route path="/" element={<PublicElement>
            <Login/>
          </PublicElement>
          } />
          <Route path="/studentlist" element={<StudentList />} />
          <Route path="/teacherlist" element={<TeacherList />} />
          <Route path="/userform" element={<UserForm />} />
          <Route path="/home" element={<Home />} />

    </Routes>
          
      
      </div>
  );
}

function PublicElement({children}){
  return<>
  {children}
  </>
}


export default App;
