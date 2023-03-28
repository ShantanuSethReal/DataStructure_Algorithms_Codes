import React from "react";

/*function Greet({name,heroName})*/
function Greet(props) {
  function clickMe(){
    //onClick={clickMe()} will be a function call and will not work|Function call 
    console.log("Clicked the button: ");
  }
  // const {name,heroName}=props
  // console.log(props);
  return (
    <div>
      <h1>Hello! {props.name} a.k.a {props.heroName}</h1>
      <button onClick={clickMe}>Click Me</button>
    </div>
  );
}

export default Greet;
