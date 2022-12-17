const Hijo = ({ numeroA, numeroB, setNumeroA, setNumeroB, suma, Sumar }) => {
  return (
    <>
      {" "}
      <div className="container col-3">
        <div>
          <div>
            Sumando a
            <input
              className="form-control"
              type="number"
              value={numeroA}
              onChange={(e) => setNumeroA(e.target.value)}
            ></input>
          </div>
          <br />
          <div>
            Sumando b{" "}
            <input
              className="form-control"
              type="number"
              value={numeroB}
              onChange={(e) => setNumeroB(e.target.value)}
            ></input>
          </div>
          <br />
          <div>
            Sumando <button onClick={Sumar}>Sumar</button>
          </div>
          <br />
          <div>
            resultado{" "}
            <input className="form-control" type="text" value={suma}></input>
          </div>
        </div>
      </div>
    </>
  );
};

export default Hijo;
