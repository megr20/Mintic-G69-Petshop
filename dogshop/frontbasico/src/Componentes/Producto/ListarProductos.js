
import axios from "axios";
import { useState ,useEffect } from "react";
import { Link } from 'react-router-dom';
import Button from 'react-bootstrap/Button';
import DetallarProductos from "./DetallarProductos";
import Menu from "../Menu/Menu";
import { Container } from "react-bootstrap";
import Footer from "../Menu/Footer";
//import { useNavigate } from "react-router-dom";
//import swal from "sweetalert"

//const URL = "http://localhost:8081/api/v1/producto/list";
//import Col from 'react-bootstrap/Col';
//import Row from 'react-bootstrap/Row';
//import axios from "axios";
//import { useState ,useEffect } from "react";
//import { useNavigate } from "react-router-dom";
//import swal from "sweetalert"


import { Producto } from "./Producto";
//import swal from "sweetalert"

//const URL = "http://localhost:8081/api/v1/producto/list";
import Col from 'react-bootstrap/Col';
import Row from 'react-bootstrap/Row';

const URL = "http://localhost:8081/api/v1/producto/list";

const ListarProductos = () => {
    const [ProductosCat, setProductos] = useState([]);

    useEffect(() => {
       getProductos()
    }, []);
  
    const getProductos = async() =>{
  
        try {
            const listaProd = await axios({
                method:"GET",
                url:URL,
                headers:{
                    //user:sessionStorage.getItem("user"),
                    //key:sessionStorage.getItem("key")
                    user:"admin",
                    key:"cb0b298c46cb1c8b541e19e7c5630c081a13e631"
                }
            })
            setProductos(listaProd.data);     
            
        } catch (error) {
            console.log(error);
        }
    
      }
  
    return (
        <>
        <Container className>
        <Menu></Menu>
        <br></br>
        <Container className="col-sm-8">
            <Row>
            <Col xs={1}></Col>
            <Col xs={10}>
            <Row xs={1} md={1} className="g-1 p-3 ">

            {ProductosCat.map((productoscat)=>(
            <Producto
                id = {productoscat.id}
                descripcion = {productoscat.descripcion}
                imagen = {productoscat.imagen}
                valor = {productoscat.valor}
            />    

                ))}

            </Row>
            </Col>
            <Col xs={1}></Col>
        </Row>
        </Container>
        <Container className="col-sm-4"></Container>
        <br></br>  
        <br></br>        
        </Container> 
        <Footer></Footer>
        </> );
  }
 
export default ListarProductos;