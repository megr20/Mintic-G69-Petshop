
import axios from "axios";
import { useState ,useEffect } from "react";
import { Link,useParams } from 'react-router-dom';

//import Button from 'react-bootstrap/Button';
//import DetallarProductos from "./DetallarProductos";
import Menu from "../Menu/Menu";
import { Container } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
//import swal from "sweetalert"

//const URL = "http://localhost:8081/api/v1/producto/list";
//import Col from 'react-bootstrap/Col';
//import Row from 'react-bootstrap/Row';

//import swal from "sweetalert"

//import { Link, useNavigate } from 'react-router-dom'
//import swal from "sweetalert"
let URL = 'http://localhost:8081/api/v1/producto/list/'



const ListarProductosCategoria = () => {
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
  }, []);
  
    return (
        <>
        <Menu name="DetallarProductos" />
        <Container className="container">
          <Link className="btn btn-outline-primary" to={`/ListarProductos`}>
            <i className="fa-solid fa-user-plus"></i>
          </Link>
<h2>{idCategoria}</h2>
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
        {ProductosCat.map((productoscat)=>(<tr>

            <td>{productoscat.id}</td>
            <td><Link to={`/detallarproductos/${productoscat.id}`}>{productoscat.descripcion}</Link></td>
            <td>{productoscat.imagen}</td>
            <td>{productoscat.valor}</td>
            

            <td> <a Link to={productoscat.imagen}>Imagen del producto</a> </td>            
        </tr>))}
        
    </tbody>
  </table>
  </Container>
  </>  );
  }
 
export default ListarProductosCategoria;