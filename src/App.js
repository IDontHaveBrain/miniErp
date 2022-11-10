import React from "react";
import {BrowserRouter, Route, Routes} from "react-router-dom";

import Dashboard from "./component/Dashboard";

function App() {
  return (
      <BrowserRouter>
          <Header />
          <SideBar />
          <Routes>
              <Route path="/" exact={true} element={<Dashboard />}></Route>
          </Routes>
          <Footer />
      </BrowserRouter>
  );
}

export default App;
