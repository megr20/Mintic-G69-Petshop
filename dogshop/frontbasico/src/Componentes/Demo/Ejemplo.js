import { useState } from "react";
import Hijo from "./Hijo";
const Ejemplo = () => {
    const [numeroA, setNumeroA] = useState("");
    const [numeroB, setNumeroB] = useState("");
    const [suma, setSuma] = useState("");

    const Sumar = () => {
        setSuma(parseInt(numeroA) + parseInt(numeroB));
    };
    return (
        <>
           <Hijo numeroA={numeroA} numeroB={numeroB} suma={suma} setNumeroA={setNumeroA} setNumeroB={setNumeroB} Sumar={Sumar}/>
        </>
    );
};

export default Ejemplo;
