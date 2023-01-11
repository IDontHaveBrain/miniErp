import React from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Login from "./component/login/Login";
import Dashboard from "./component/Dashboard";
import AppStore from "./store/AppStore";
import "./resources/login.css";
import _ from "lodash";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        {/* {!_.isEmpty(AppStore.successToken) ? (
          <Route path='/' exact={true} element={<Dashboard />}></Route>
        ) : (
          <Route path='/' exact={true} element={<Login />}></Route>
        )} */}
        <Route path='/' exact={true} element={<Dashboard />}></Route>
        <Route path='/login' exact={true} element={<Login />}></Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
