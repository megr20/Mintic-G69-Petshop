import axios from "axios";
import { useState ,useEffect } from "react";
import { Link } from 'react-router-dom';
import Button from 'react-bootstrap/Button';
import DetallarProductos from "./DetallarProductos";
import Menu from "../Menu/Menu";
import { Container } from "react-bootstrap";
import ListarProductos from "../Producto/ListarProductos";
import Footer from "./Footer";

const URL = "http://localhost:8081/api/v1/producto/list";

const PanelPrincipal = () => {
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
    <Container>
        <Menu>
            <ListarProductos></ListarProductos>
        </Menu>
    </Container>
    <Footer></Footer>
  </>  );
  }
 
export default PanelPrincipal;