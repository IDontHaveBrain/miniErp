import axios from "axios";
import history from "../util/AppRouter";
// import rooStore from "../store/RootStore";
import appStore from "../store/AppStore";
import { useNavigate } from "react-router-dom";
const Api = axios.create({
  baseURL: "",
  timeout: 30000,
  headers: { "Content-Type": "application/json" },
});

Api.interceptors.request.use(
  function (config) {
    let token = "";
    //로그인 화면시 토큰 정보 빈값으로 처리
    if (config.url && config.url.indexOf("signin") !== -1) {
      config.headers["Authorization"] = "";
    } else {
      config.headers["Authorization"] = "Bearer " + token;
    }
    return config;
  },
  function (error) {
    return Promise.reject(error);
  }
);

Api.interceptors.response.use(
  function (response) {
    // let config = response.config;
    // let method = config.method;
    return response;
  }
  //   function (error) {
  // /z

  //     return Promise.reject(error);
  //   }
);

export default Api;
