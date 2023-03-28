import React, { Component } from 'react'
//Never change state directly .Always change using setState
export default class Counter extends Component {
    constructor(props) {
      super(props)
    
      this.state = {
         count: 0
      }
    }
    increment(){
        this.setState({
            count: this.state.count +1
        },()=>{console.log("Call Back Value: ", this.state.count)})
        console.log(this.state.count)
    }
    
  render() {
    const {name,heroName}=this.props;
    /*const{state1,state2}=this.state*/
    return (
      <div>
        <h2>Count: |{this.state.count}| </h2>
        <button onClick={()=>this.increment()}>Increment</button>
      </div>
    )
  }
}
