import React from "react";
import "./Stylesheet.css";
import sty from "./Style.module.css";
export default function Child(props) {
  //Inline CSS
  const heading = {
    fontSize: "72px",
    color: "yellow",
  };
  return (
    <div>
      {/* Without parameter <button onClick={props.greetHandler}>Click Me</button> */}
      <h1 style={heading}>Inline</h1>
      <h1 className={sty.primary}> Hello from module CSS</h1>
      <h2 className="primary">Hello from CSS Stylesheet</h2>
      <button onClick={() => props.greetHandler("Child Function Component")}>Click Me</button>
    </div>
  );
}

//If/Else
//Element variables
//Terenary Conditional Operator
//Short Circuit Operator

//if else doesnt work inside JSX
