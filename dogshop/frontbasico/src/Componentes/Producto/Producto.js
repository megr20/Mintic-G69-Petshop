import { Container, Card, Button} from "react-bootstrap";
import { Link } from 'react-router-dom';

export function Producto(props){

return  <Card  style={{ width: '12rem' }} >
            <Card.Img variant="top" src= {process.env.PUBLIC_URL + "/images/" + props.id + ".jpg"} width="100" height="200" />
            {/*<Card.Img variant="top" src= "https://drive.google.com/file/d/0B1AigQPzCXwVNXJ2MWpHdTQyZW04N2VPdHA5dDcyV0p5Zk9F/view?usp=sharing&resourcekey=0-zl8UQILQA0igFrSO2jkM0A" width="100"></Card.Img>*/}
                <Card.Body>
                <Card.Title>{props.descripcion}</Card.Title>
                <Card.Text>
                        <p></p>
                </Card.Text>
                <Link to={`/detallarproductos/${props.id}`}>
                    <Button variant="primary">Detalle</Button>
                </Link>
                </Card.Body>
        </Card>

    /*return  <div>
    <img src={process.env.PUBLIC_URL + '/images/'+ props.id +'.jpg'} className='img-thumbnail' />
    <p>{props.nombre}</p>
</div>*/
}