import { Container, Nav, Navbar } from "react-bootstrap";
import { LinkContainer } from "react-router-bootstrap";

function AdminNavBar() {
  return (
    <Navbar collapseOnSelect expand="lg" bg="dark" variant="dark">
      <Container>
        <Navbar.Brand>
          <LinkContainer to={"/home"}>
            <Nav.Link>Home</Nav.Link>
          </LinkContainer>
        </Navbar.Brand>
        <Navbar.Toggle aria-controls="responsive-navbar-nav" />
        <Navbar.Collapse id="responsive-navbar-nav">
          <Nav className="me-auto">
            <LinkContainer to="/teacherlist">
              <Nav.Link>Teacher</Nav.Link>
            </LinkContainer>
            <LinkContainer to="/studentlist">
              <Nav.Link>Student</Nav.Link>
            </LinkContainer>
          </Nav>
          <Nav >
          <LinkContainer to="/userform">
              <Nav.Link>Add New User</Nav.Link>
            </LinkContainer>
            <LinkContainer to="/">
              <Nav.Link>LogOut</Nav.Link>
            </LinkContainer>
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
}
export default AdminNavBar;