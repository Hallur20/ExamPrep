import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import { BrowserRouter as Router, Route,  Switch } from 'react-router-dom'

import Welcome from './Welcome'
import AllUsers from './AllUsers'
import Details from './Details'

class App extends Component {
  render() {
    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h1 className="App-title">Welcome to React</h1>
        </header>
        <p className="App-intro">
          To get started, edit <code>src/App.js</code> and save to reload.
        </p>
      
        <Router>
          <Switch>
      
          <Route exact path='/' component={Welcome}/>
          <Route path="/all" component={AllUsers}/>
          <Route path="/details/:index" component={Details}/>

          </Switch>
         
        </Router>
       
      </div>
    );
  }
}
export default App;
