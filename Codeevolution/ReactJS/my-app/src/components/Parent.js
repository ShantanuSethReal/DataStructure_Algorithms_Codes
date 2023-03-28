import React, { Component } from "react";
import Child from "./Child";
export class Parent extends Component {
  constructor(props) {
    super(props);

    this.state = {
      parentName: "Parent from Parent Class Component",
    };
    this.greetHandler = this.greetHandler.bind(this);
  }

  greetHandler(childName) {
    console.log(`Hello ${this.state.parentName} ${childName}`);
  }

  render() {
    return (
      <div>
        <Child greetHandler={this.greetHandler}></Child>
      </div>
    );
  }
}

export default Parent;
