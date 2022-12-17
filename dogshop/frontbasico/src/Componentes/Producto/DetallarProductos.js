//import { Link, useNavigate } from "react-router-dom";
 //import Card from 'react-bootstrap/Card';
 //import { Link, useNavigate } from "react-router-dom";
 //import Card from 'react-bootstrap/Card';
 //import "bootstrap/dist/css/bootstrap.min.css";
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
//import Placeholder from 'react-bootstrap/Placeholder';
import Container from 'react-bootstrap/Container';

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

   /*return ( 
      <>
    <Container className>
    <Menu></Menu>
    <br></br>
    <Row xs={1} md={4} className="g-4">
      {Array.from({ length: 1 }).map((_, idx) => (
        <Col>
          <Card>
            <Card.Img variant="top" src="holder.js/100px160" />
            <Card.Body>
              <Card.Title>Card title</Card.Title>
              <Card.Text>
              {DetalleProducto.map((prod)=>(
            {prod.categoria}
            {prod.id}
            {prod.descripcion}
            {prod.imagen}
            {prod.valor}))}
              </Card.Text>
              <Link to="/DetalleProducto">
          <Button variant="primary">Comprar</Button>
          </Link>
            </Card.Body>
          </Card>
        </Col>
      ))}
    </Row>
    <br></br>  
    <br></br>        
    </Container> 
    </>
  );
}*/
return (
  <>
  <Menu name="DetallarProductos" />
  <Container className="container">
    <Link className="btn btn-outline-primary" to={`/ListarProductos`}>
      <i className="fa-solid fa-user-plus"></i>
    </Link>

    <table className="table">
      <thead className="responsive">  
  <tr>

  <th>id</th>
  <th>Descripcion</th>
  <th>Imagen</th>
  <th>Valor</th>
  <th>Detalle</th>
  </tr>
</thead>
<tbody>
  <tr>

      <td>{detalle.id}</td>
      <td>{detalle.descripcion}</td>
      <td>{detalle.imagen}</td>
      <td>{detalle.valor}</td>
      

      <td> <Link to={detalle.imagen}>Imagen del producto</Link> </td>            
  </tr>
  
</tbody>
</table>
</Container>
</>  );
}
export default DetallarProductos;


/*
    return (
        <Container className>
          <Menu></Menu>
          <br></br>
        <div className="d-flex justify-content-around">
          <Card style={{ width: '18rem' }}>
            <Card.Img variant="top" src="holder.js/100px180" />
            <Card.Body>
              <Card.Title>Producto 1</Card.Title>
              <Card.Text>
               Descripcion Producto
              </Card.Text>
              <Link to="/DetalleProducto">
              <Button variant="primary">Detalle</Button>
              </Link>
            </Card.Body>
          </Card>                        
        </div> 
        <br></br>  
        <br></br>        
        </Container>        
      );
    }
  */
  
