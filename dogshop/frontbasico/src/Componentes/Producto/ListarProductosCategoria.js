
import axios from "axios";
import { useState ,useEffect } from "react";
import { Link,useParams } from 'react-router-dom';

//import Button from 'react-bootstrap/Button';
//import DetallarProductos from "./DetallarProductos";
import Menu from "../Menu/Menu";
import { Container, Card } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import { Producto } from "./Producto";
//import swal from "sweetalert"

//const URL = "http://localhost:8081/api/v1/producto/list";
import Col from 'react-bootstrap/Col';
import Row from 'react-bootstrap/Row';
import Footer from "../Menu/Footer";

//import swal from "sweetalert"

//import { Link, useNavigate } from 'react-router-dom'
//import swal from "sweetalert"
let URL = 'http://localhost:8081/api/v1/producto/list/'



const ListarProductosCategoria = (props) => {
    //let idCategoria=1;
    let  {idCategoria} = useParams();
    const [ProductosCat, setProductosCat] = useState([]);

    console.log("idCategoria: "+idCategoria);

     
    const getProductosCat = async() =>{
  
        try {
            const listaProdCat = await axios({
                method:"GET",
                url:URL+idCategoria,
                headers:{
                    //user:sessionStorage.getItem("user"),
                    //key:sessionStorage.getItem("key")
                    user:"admin",
                    key:"cb0b298c46cb1c8b541e19e7c5630c081a13e631"
                }
            })
            setProductosCat(listaProdCat.data);     
            
        } catch (error) {
            console.log(error);
        }
    
      };

      useEffect(() => {
        getProductosCat();
      }, [idCategoria]);
  
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
    <br></br>  
    <br></br>        
    </Container> 
    <Footer></Footer>
    </>
  );

  }
 
export default ListarProductosCategoria;