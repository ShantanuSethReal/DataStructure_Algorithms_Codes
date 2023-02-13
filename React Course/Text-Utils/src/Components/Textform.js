import React, { useState } from "react";
// import { ReactPropTypes } from "react";
export default function Textform(props) {
  const [text, setText] = useState("Enter Text Here");

  //Function to convert text in the box to Uppercase
  const handleUpperCase = () => {
    let newText = text.toUpperCase();
    setText(newText);
    props.showalert("Your text has been converted to Upper-Case", "Success","success");
  };
  //Function to convert text in the box to Lowercase
  const handleLowerCase = () => {
    let newText = text.toLowerCase();
    setText(newText);
    props.showalert("Your text has been converted to Lower-Case", "Success", "success");
  };
  //Function to Update text in the box
  const UpdateText = (event) => {
    setText(event.target.value);
  };
  //Function to Clear Text/Reset text box
  const ClearText = (event) => {
    setText("");
    props.showalert("Your text has been Cleared", "Success", "success");
  };
  //Function to copy text into Clipboard
  const CopyText = (event) => {
    var text = document.getElementById("myBox");
    text.select();
    navigator.clipboard.writeText(text.value);
    props.showalert("Your text has been copied to Clipboard", "Success", "success");
  };
  return (
    <div>
      <div className="mb-3">
        <label htmlFor="myText" className="form-label">
          <h1> Please Enter Your Text Here</h1>
        </label>
        <textarea className="form-control border border-primary" onChange={UpdateText} value={text} id="myBox" rows="8"></textarea>
        <button type="button" class="btn btn-primary mx-3 my-2" onClick={handleUpperCase}>
          Convert to UpperCase
        </button>
        <button type="button" class="btn btn-success mx-3 my-2" onClick={handleLowerCase}>
          Convert to LowerCase
        </button>

        <button type="button" class="btn btn-danger mx-3 my-2" onClick={ClearText}>
          Clear Text
        </button>
        <button type="button" class="btn btn-warning mx-3 my-2" onClick={CopyText}>
          Copy Text
        </button>
        {/* <button type="button" class="btn btn-danger">
          Danger
        </button> */}
      </div>
      <div className="container">
        <h3>Your Text Summary</h3>
        <p>
          {text.split(" ").length} words , {text.length} characters
        </p>
        <p>Time taken to read : {0.008 * text.split(" ").length} minutes</p>
        <h2>Preview</h2>
        <p>{text}</p>
      </div>
    </div>
  );
}
