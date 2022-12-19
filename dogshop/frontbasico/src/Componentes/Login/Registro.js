import {useRef} from 'react'
import {Link,Navigate,useNavigate} from 'react-router-dom'
import swal from 'sweetalert'
import axios from "axios";

const URL = "http://localhost:8081/api/v1/cliente/";

const Registro= () => {
    const refNombre = useRef(null)
	const refCorreo = useRef(null)
	const refPasswd = useRef(null)
	const navigate = useNavigate()

    const headers = {
        user: sessionStorage.getItem("user"),
        key: sessionStorage.getItem("key"),
      };
    

	const handleBoton = ()=>{
		console.log("presionado Boton")
	}

	const guardar = async () => {
		//.current.value ="wvalle@gmail.com"
		//refPasswd.current.value="asdfg"
        console.log("Correo: " + refNombre.current.value)
		console.log("Correo: " + refCorreo.current.value)
		console.log("Passwd: " + refPasswd.current.value)
    try {
		const insertarCliente = await axios({
            method: "POST",
            url: URL,
            data: {
              nombre: refNombre.current.value,
              email: refCorreo.current.value,
              clave: refPasswd.current.value
            },
            headers: headers,
          });
    
          console.log(insertarCliente.data);
      swal("Registro creado", insertarCliente.data.message, "success").then(
        (value) => {
            navigate("/login");
        }
      );
    } catch (error) {
      swal(
        "Error en datos",
        JSON.parse(error.request.response).errors[0].message,
        "error"
      );
    }
    console.log("Registro");
  };

        
        
        /*{
			method : 'POST',
			headers : {
				"Content-Type": "application/json"
			},
			body : JSON.stringify({
                nombre : refNombre.current.value ,
				email : refCorreo.current.value,
				clave : refPasswd.current.value
				
			})
		}
		fetch(URL + "/usuario/registro/",requestOptions)
		.then(response => response.json())
		.then(data => { console.log("data: " + data)
			if (data){
				//localStorage.setItem("token", data.token)
				swal({
					title : "Registro",
					test : data.msj,
					icon : 'success'
				})
				navigate("/login")
			}
			else{
				swal({
					title : "Acceso",
					test : data.msj,
					icon : 'error'
				})				
			}
		})
		.catch(error => { console.log(error)
			swal({
				title: "Error",
				text: "Error en el registro",
				icon:"error"
			})

		})
	}*/
	const handleSubmit=(ev)=>{
		ev.preventDefault()
		console.log("Enviando Datos: "+ refCorreo.current.value + " - " + refPasswd.current.value)
		guardar()
	}
    return <div className="container-fluid">
	<div className="row">
		<div className="col-md-4 offset-4">
			<form  onSubmit={handleSubmit}>
                <div className="form-group"> 
					<label for="exampleInputEmail1">
						Nombre
					</label>
					<input type="text"  className="form-control" ref={refNombre}  onChange={ function(){ console.log("digitando...") }} placeholder="Nombre"/>
				</div>
				<div className="form-group"> 
					<label for="exampleInputEmail1">
						Email address
					</label>
					<input type="email"  className="form-control" ref={refCorreo}  onChange={ function(){ console.log("digitando...") }} placeholder="user@mail.com"/>
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">
						Password
					</label>
					<input type="password" className="form-control" ref={refPasswd}  onChange={ function(){ console.log("digitando...") }} placeholder="clave" />
				</div>
				<div class="form-group my-4">
                    <button type="submit" className="btn btn-warning" onClick={ handleBoton }>
                        Registro
                    </button>
                    <br></br><p>Accede a Match-online
					<Link to="/login"> aqui! </Link></p>
				</div>				
			</form>
		</div>
	</div>
</div>
}
export default Registro;