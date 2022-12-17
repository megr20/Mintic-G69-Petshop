/* eslint-disable react-hooks/exhaustive-deps */
/* eslint-disable jsx-a11y/anchor-is-valid */
import { Link, useNavigate } from "react-router-dom";
import Container from 'react-bootstrap/Container';
import { useEffect } from "react";
//import swal from "sweetalert";
//import "bootstrap/dist/css/bootstrap.min.css";
//import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import {NavLink} from 'react-router-dom';
import { NavDropdown } from "react-bootstrap";
//import {ListarProductosCategoria} from "../Producto/ListarProductosCategoria";
import axios from "axios";
import { useState } from "react";

let URL = 'http://localhost:8081/api/v1/categoria/list'



const Menu = () => {
  const [Categoria, setCategoria] = useState([]);

  useEffect(() => {
     getCategoria()
  }, []);

  const getCategoria = async() =>{

      try {
          const listaCat = await axios({
              method:"GET",
              url:URL,
              headers:{
                  //user:sessionStorage.getItem("user"),
                  //key:sessionStorage.getItem("key")
                  user:"admin",
                  key:"cb0b298c46cb1c8b541e19e7c5630c081a13e631"
              }
          })
          setCategoria(listaCat.data);     
          
      } catch (error) {
          console.log(error);
      }
  
    }

  return ( 

  <>
  <Container className="justify-content-center">
      <h1 className="justify-content-center">DogShop</h1>
</Container>
    <Container className="justify-content-center">
    <Navbar className="justify-content-center" bg="primary" variant="dark" expand="lg">
      <Container>
        <Navbar.Brand href="/">Tienda Online</Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="me-auto">
            <Link to={`/listarproductoscategoria/1`}>prueba1</Link>
            <Nav.Link href="/">Home</Nav.Link>
            <Nav.Link href="#link">Link</Nav.Link>
            <NavDropdown title="Categorias" id="basic-nav-dropdown">
            {
            Categoria.map(dato=>(
              <NavDropdown.Item as={NavLink} to={`/listarproductoscategoria/${dato.id}`}>{dato.nombre}</NavDropdown.Item>
            ))}
             </NavDropdown>
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  
  </Container>
  </>
 
  );




  /*
    return ( 

      

    
       <>
  <Container className="justify-content-center">
  <h2 className="justify-content-center">DogShop</h2> 
  </Container>

  <Container className="justify-content-center">
   <nav className="navbar navbar-expand-lg navbar-light bg-light">
    <div className="container-fluid">
      <Link className="navbar-brand" to="/clientes">Clientes</Link>

      <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span className="navbar-toggler-icon"></span>
      </button>

      <div className="collapse navbar-collapse" id="navbarSupportedContent">
      <Link className="navbar-brand" to="/listarproductos">ListarProductos</Link>
      <Link className="navbar-brand" to="/accesorios">Accesorios</Link>
      <Link className="navbar-brand" to="/aseoybelleza">Aseo y Belleza</Link>
      <Link className="navbar-brand" to="/saludybienestar">Salud y Bienestar</Link>
      <Link className="navbar-brand" to="/logout">Logout</Link>
      </div>
    </div>
  </nav>
  </Container>
  </> );
  */

  
}
 
export default Menu;