import React from "react";
import Container from 'react-bootstrap/Container';
  
const Footer = () => {
  return (

<footer class="flex-wrap justify-content-between align-items-center py-3 my-4 border-top">
    <Container className="col-sm-0 d-flex align-items-center">
      <a href="/" class="mb-3 me-2 mb-md-0 text-muted text-decoration-none lh-1">
        <svg class="bi" width="30" height="24"><use href="#"></use></svg>
      </a>
      <span class="mb-3 mb-md-0 text-muted">DogShop 2022 Company, Inc</span>
    </Container>

    <ul class="nav col-sm-0 justify-content-center list-unstyled d-flex">
        <li class="ms-3"><a class="text-muted" href="https://github.com/megr20/Mintic-G69-Petshop/"><img  width="50" height="40" src={process.env.PUBLIC_URL + "/images/github.svg"}></img></a></li>
        <li class="ms-3"><a class="text-muted" href="#"><img  width="50" height="40" src={process.env.PUBLIC_URL + "/images/twiter.jpg"}></img></a></li>
        <li class="ms-3"><a class="text-muted" href="#"><img  width="50" height="40" src={process.env.PUBLIC_URL + "/images/facebook.jpg"}></img></a></li>
        <li class="ms-3"><a class="text-muted" href="#"><img  width="50" height="40" src={process.env.PUBLIC_URL + "/images/instagram.jpg"}></img></a></li>
    </ul>
  </footer>
      
  );
}
export default Footer;