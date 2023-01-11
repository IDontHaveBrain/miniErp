import React from "react";
import FormInput from "../ui/FormInput";
import { observer, inject } from "mobx-react";
import { useNavigate } from "react-router-dom";
//import rootStore from "../RootStore";
// function WithNavigate(props) {
//   let navigate = useNavigate();

//   return <LoginStore {...props} navigate={navigate} />;
// }

const Login = inject("loginStore")(
  observer(({ loginStore }) => {
    let navigate = useNavigate();

    const handleChange = (e) => {
      loginStore.changeInput(e.target.name, e.target.value);
    };

    const handleBlur = (e) => {
      //loginStore.changeInput(e.target.name, e.target.value);
    };

    const handleLogin = () => {
      loginStore
        .login()
        .then((response) => {
          loginStore.loginSuccessHandler(response);
          navigate("/");
        })
        .catch(({ code, response }) => {
          alert(response.data.message);
          navigate("/login");
        });
    };

    const { formData } = loginStore;

    return (
      <>
        <header className='Login-header'>
          <div>
            <FormInput
              labelName={"username"}
              onChange={handleChange}
              onBlur={handleBlur}
              formData={formData.username}
            ></FormInput>
            <FormInput
              labelName={"pw"}
              onChange={handleChange}
              onBlur={handleBlur}
              formData={formData.pw}
            ></FormInput>
          </div>

          <div>
            <button className='Login-button' onClick={handleLogin}>
              로그인
            </button>
          </div>
        </header>
      </>
    );
  })
);

export default Login;
