
import axios from "axios";
import { useState ,useEffect } from "react";
import { useNavigate } from "react-router-dom";
import swal from "sweetalert"

const URL = "http://localhost:8081/api/v1/cliente/list";
const ListarClientes = () => {
    const [Cliente, setClientes] = useState([]);

    useEffect(() => {
       getClientes()
    }, []);

    const getClientes = async() =>{

        try {
            const login = await axios({
                method:"GET",
                url:URL,
                headers:{
                    user:sessionStorage.getItem("user"),
                    key:sessionStorage.getItem("key")

                }
            })
            setClientes(login.data);     
            
        } catch (error) {
            console.log(error);
        }
    
      }

    return (
    <>
    <div className="container"><table className="table">
    <thead className="table-primary">
        <tr>
        <th>Nombre</th>
        <th>Usuario</th>
        </tr>
    </thead>
    <tbody>
        {Cliente.map((cliente)=>(<tr>
            <td>{cliente.nombre}</td>
            <td>{cliente.userName}</td>
        </tr>))}
        
    </tbody>
</table>
</div>
</>  );
}
 
export default ListarClientes;