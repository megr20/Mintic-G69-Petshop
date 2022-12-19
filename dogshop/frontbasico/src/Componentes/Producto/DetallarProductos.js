//import { Link, useNavigate } from "react-router-dom";
 //import Card from 'react-bootstrap/Card';
 //import { Link, useNavigate } from "react-router-dom";
 //import Card from 'react-bootstrap/Card';
 //import "bootstrap/dist/css/bootstrap.min.css";
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
//import Placeholder from 'react-bootstrap/Placeholder';
import Container from 'react-bootstrap/Container';
import Footer from "../Menu/Footer";

import { Link, useParams } from 'react-router-dom';
import Menu from '../Menu/Menu';
import { Row } from 'react-bootstrap';
import {Col} from 'react-bootstrap';
import { useState } from 'react';
import { useEffect } from 'react';
import axios from 'axios';

//import Card from 'react-bootstrap/Card';
const URL = "http://localhost:8081/api/v1/producto/";

 const DetallarProductos = () => {
    const  {idProducto} = useParams();
    const [detalle, setDetalle] = useState([]);
    console.log("idProducto: "+idProducto);
    useEffect(() => {
       getDetalle()
    }, []);
  
    const getDetalle = async() =>{
  
        try {
            const producto = await axios({
                method:"GET",
                url:URL+idProducto,
                headers:{
                    //user:sessionStorage.getItem("user"),
                    //key:sessionStorage.getItem("key")
                    user:"admin",
                    key:"cb0b298c46cb1c8b541e19e7c5630c081a13e631"
                }
            })
            setDetalle(producto.data);     
            
        } catch (error) {
            console.log(error);
        }
      }

   return ( 
      <>
    <Container className>
    <Menu></Menu>
    <br></br>
    <Container className>
      
      <Row>
      <Col xs={2}>
           
        </Col>
        <Col xs={4}>
            <img src= {process.env.PUBLIC_URL + "/images/" + detalle.id + ".jpg"} width="300" height="400"></img>
        </Col>

        <Col xs={6}>
        <h3>{detalle.descripcion}</h3>
        <h5>Valor: $ {detalle.valor}</h5>
        <Button>Comprar</Button>
        </Col>
      </Row>
    </Container> 
    </Container>
    <Footer></Footer>
    </>
  );
}

export default DetallarProductos;


  
