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
import { Col, NavDropdown, Row } from "react-bootstrap";
//import {ListarProductosCategoria} from "../Producto/ListarProductosCategoria";
import axios from "axios";
import { useState } from "react";

let URL = 'http://localhost:8081/api/v1/categoria/list'



const Menu = () => {
  const [Categoria, setCategoria] = useState([]);
  console.log('Link clicked');
/*
  const handleClick = (event, message) => {
    console.log('Link clicked');
    console.log(message);
  };*/

  useEffect(() => {
     getCategoria()
  },[]);

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
  <br></br>  
  <Container className="md={12} d-flex">
  <Row>
  
  <Col className="md={2} d-flex">
        <a className="navbar-brand " href="/">
            <img src={process.env.PUBLIC_URL + "/images/Dogshop.jpg"} alt="Logo" width="150"  className="d-inline-block align-text-botton p-2"/>
        </a>
  </Col>    
  <Col className="md={8}  ">
    <nav className="navbar  " >
        <Navbar style={{backgroundSize: "0", backgroundColor: "#d63384"}} variant="dark">
        <Container className="md={10} d-flex">
          <Navbar.Brand href=""></Navbar.Brand>
          <Nav  className=" fs-4 " style={{fontWeight: 'bold'}} >
            <Nav.Link href="/">Home</Nav.Link>
            { Categoria.map(dato=>(
                              <Nav.Link as={NavLink} to={`/listarproductoscategoria/${dato.id}`}>{dato.nombre}</Nav.Link>
              ))
            }
          </Nav>
        </Container>
        <Container className=" md={2} d-flex">
              <Row>
                    {/* <button className="btn btn-outline-warning">Login</button> */}
                    <Link className="btn btn-outline-dark" to="/login">Login</Link>
                    {/* <button className="btn btn-outline-warning">Login</button> 
                    <Link className="btn btn-outline-dark" to="/registro">Registro</Link>*/}
                  </Row>
        </Container>
        
      </Navbar>
      <br />


</nav>
</Col>
<Col className="md={2} d-flex"></Col>
</Row>
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