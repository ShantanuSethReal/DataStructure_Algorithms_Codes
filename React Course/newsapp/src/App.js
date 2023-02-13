// import logo from './logo.svg';
import "./App.css";

import React, { Component } from "react";
import NavBar from "./Components/NavBar";
import News from "./Components/News";
import NewsItem from "./Components/NewsItem";
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";

export default class App extends Component {
  render() {
    return (
      <>
        <Router>
          <NavBar />
          <div className="container">
            <News pageSize={20} country="in" category="sports" />
            <Switch>
              <Route path="/business">
                <News pageSize={20} country="in" category="business" />
              </Route>
              <Route path="/users">
                <News pageSize={20} country="in" category="sports" />
              </Route>
              <Route path="/">
                <Home />
              </Route>
            </Switch>
          </div>
        </Router>
      </>
    );
  }
}
