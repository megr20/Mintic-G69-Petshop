
import axios from "axios";
import { useState ,useEffect } from "react";
import { Link } from 'react-router-dom';
import Button from 'react-bootstrap/Button';
import DetallarProductos from "./DetallarProductos";
import Menu from "../Menu/Menu";
import { Container } from "react-bootstrap";
//import { useNavigate } from "react-router-dom";
//import swal from "sweetalert"

//const URL = "http://localhost:8081/api/v1/producto/list";
//import Col from 'react-bootstrap/Col';
//import Row from 'react-bootstrap/Row';
//import axios from "axios";
//import { useState ,useEffect } from "react";
//import { useNavigate } from "react-router-dom";
//import swal from "sweetalert"

const URL = "http://localhost:8081/api/v1/producto/list";

const ListarProductos = () => {
    const [Producto, setProductos] = useState([]);

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
        <Menu name="DetallarProductos" />
        <Container className="container">
          <Link className="btn btn-outline-primary" to={`/ListarProductos`}>
            <i className="fa-solid fa-user-plus"></i>
          </Link>

          <table className="table">
            <thead className="responsive">  
        <tr>
        <th>IdCtegoria</th>
        <th>Descripcion</th>
        <th>Imagen</th>
        <th>Valor</th>
        <th>Detalle</th>
        </tr>
    </thead>
    <tbody>
        {Producto.map((producto)=>(<tr>
            <td>{producto.id}</td>
            <td>{producto.descripcion}</td>
            <td>{producto.imagen}</td>
            <td>{producto.valor}</td>
            <td> <a Link to ={producto.imagen}>Imagen del producto</a> </td>            
        </tr>))}
        
    </tbody>
  </table>
  </Container>
  </>  );
  }
 
export default ListarProductos;