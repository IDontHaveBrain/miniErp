import React from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Test from "./test";
import Dashboard from "./component/Dashboard";
import AppStore from "./store/AppStore";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path='/' exact={true} element={<Test />}></Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
