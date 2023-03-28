import React, { Component } from "react";
//Can recieve props as argument and have states
//Props are immutable
//State is managed within the component

export default class Welcome extends Component {
    constructor(){
        super();
        this.state={
            message: "Welcome visitor"
        }
    }
    changeMessage(){
        this.setState({
            message: "Thank you for Subscibing"
        })
    }
    clickMe(){ 
    console.log("Clicked the button: Class Based");
    }
  render() {
    return (
      <div>
        <h1>Hi this is a Class Component with {this.props.name} a.k.a {this.props.heroName}</h1>
        <button onClick={()=>{this.changeMessage()}}>Subscribe</button>
        <button onClick={this.clickMe}>Button event</button>
        <h1> {this.state.message}</h1>
      </div>
    );
  }
}
