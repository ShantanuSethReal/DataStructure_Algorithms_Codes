import "./App.css";
import About from "./Components/About";
import Alert from "./Components/Alert";
import Navbar from "./Components/Navbar";
import Textform from "./Components/Textform";
import { useState } from "react";

function App() {
  const [alert, setalert] = useState(null);
  const showalert = (message, type, cssclass) => {
    setalert({
      msg: message,
      type: type,
      css: cssclass,
    });
    setTimeout(() => {
      setalert(null);
    }, 1500);
  };
  return (
    <>
      <Navbar title="TextUtils App" aboutText="About"></Navbar>

      <div className="container">
        <Alert alert={alert}></Alert>
        {/* <About /> */}

        <Textform showalert={showalert}></Textform>
      </div>
    </>
  );
}

export default App;
