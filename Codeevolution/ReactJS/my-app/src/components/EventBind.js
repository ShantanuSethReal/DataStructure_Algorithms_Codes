import React, { Component } from "react";

export class EventBind extends Component {
  constructor(props) {
    super(props);

    this.state = {
      message: "Hello",
    };
    //Method 3 this.clickHandler=this.clickHandler.bind(this)
  }
  //Event Bind in React
  clickHandler() {
    this.setState({
      message: "GoodBye",
    });
  }
  //Method 4 clickHandler=()=>{this.setState({message: "GoodBye"})}
  //Method 3 and 4 are best methods
  
  render() {
    return (
      <div>
        {/* Right */}
        {/* Method 1<button onClick={this.clickHandler.bind(this)}>Click Me Event</button> */}
        {/* Method 2 <button onClick={()=>this.clickHandler()}>Click Me Event</button> */}
        {/* Wrong */}
        {/* <button onClick={this.clickHandler}>Click Me Event</button> */}
        <h1>{this.state.message}</h1>
      </div>
    );
  }
}

export default EventBind;
