import React, { Component } from "react";

export class Forms extends Component {
  constructor(props) {
    super(props);

    this.state = {
      username: "",
      comments: "",
      topic: "react",
    };
  }
  handleChange = (event) => {
    this.setState({
      username: event.target.value,
    });
  };
  handleTextChange = (event) => {
    this.setState({
      comments: event.target.value,
    });
  };
  handleTopicChange = (event) => {
    this.setState({
      topic: event.target.value,
    });
  };
  handleSubmit = (event) => {
    alert(`${this.state.username} comment ${this.state.comments} topic ${this.state.topic}`);
  };
  render() {
    return (
      <div>
        <h1>Form Component</h1>
        <form onSubmit={this.handleSubmit}>
          <div>
            <label>Username: </label>
            <input type="text" value={this.state.username} onChange={this.handleChange}></input>
          </div>

          <div>
            <label>Comments: </label>
            <textarea value={this.state.comments} onChange={this.handleTextChange}></textarea>
          </div>
          <div>
            <label>Options: </label>
            <select value={this.state.topic} onChange={this.handleTopicChange}>
              <option value="react">React</option>
              <option value="angular">Angular</option>
            </select>
          </div>
          <button type="submit">Submit</button> 
        </form>
      </div>
    );
  }
}

export default Forms;
