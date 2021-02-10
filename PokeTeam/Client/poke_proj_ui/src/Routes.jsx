import React from 'react';
import { Switch, Route } from 'react-router-dom';

import Landing from './pages/Landing.jsx'
import Signup from './pages/Signup.jsx';
import Login from './pages/Login.jsx'

const Main = () => {
  return (
    <Switch> {/* The Switch decides which component to show based on the current URL.*/}
      <Route exact path='/' component={Landing}></Route>
      <Route exact path='/signup' component={Signup}></Route>
      <Route exact path='/login' component={Login}></Route>
    </Switch>
  );
}

export default Main;