/* eslint-disable jsx-a11y/alt-text */
import "./App.css";
import {Route,Routes,HashRouter} from "react-router-dom"
import Login from "./Componentes/Login/Login";
import Menu from "./Componentes/Menu/Menu";
import ListarClientes from "./Componentes/Cliente/ListaClientes";
import ListarProductos  from "./Componentes/Producto/ListarProductos";
import { BrowserRouter } from "react-router-dom";
import DetallarProductos from "./Componentes/Producto/DetallarProductos";
import ListarProductosCategoria from "./Componentes/Producto/ListarProductosCategoria";
//import { Accesorios } from "./Componentes/Menu/Accesorios";
//import { AseoyBelleza } from "./Componentes/Menu/AseoyBelleza";
//import { SaludyBienestar } from "./Componentes/Menu/SaludyBienestar";


function App() {
/*          <Route exact path="/alimentos" element={<Alimentos/>}/>
          <Route exact path="/accesorios" element={<Accesorios/>}/>
          <Route exact path="/aseoybelleza" element={<AseoyBelleza/>}/>
          <Route exact path="/saludybienestar" element={<SaludyBienestar/>}/>
          <Route exact path="/logout" element={<ListarClientes/>}/>*/
          

          /*      <HashRouter>
        <Routes>
          <Route exact path="/login" element={<Login/>}/>
          <Route exact path="/" element={<Menu/>}/>          
          <Route exact path="/clientes" element={<ListarClientes/>}/>
          <Route exact path="/alimentos" element={<Alimentos/>}/>


        </Routes>

      </HashRouter>
      */


  return (
    <>
      <BrowserRouter>     
        
      <Routes>
      <Route exact path="/" element={<Menu/>}/>    
      <Route exact path="/login" element={<Login/>}/>        
      <Route exact path="/clientes" element={<ListarClientes/>}/>
      <Route exact path="/listarproductos" element={<ListarProductos/>}/>
      <Route exact path="/detallarproductos/:idProducto" element={<DetallarProductos/>}/>
      <Route exact path="/listarproductoscategoria/:idCategoria" element={<ListarProductosCategoria/>}/>

  
      </Routes>
      
      </BrowserRouter>  
    </>
  );
}

export default App;
