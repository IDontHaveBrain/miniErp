import {
  makeObservable,
  observable,
  action,
  toJS,
  computed,
  runInAction,
} from "mobx";
import update from "immutability-helper";
import _ from "lodash";
import ApiService from "../../service/ApiService";

class LoginStore {
  formData = null;
  formType = "ADD";
  // detailId = null;
  // detailInfo = null;
  username = "";
  pw = "";
  successToken = "";
  tokenTime = "";

  constructor(rootStore) {
    this.rootStore = rootStore;

    makeObservable(this, {
      formData: observable,
      formType: observable,
      // detailId: observable,
      // detailInfo: observable,
      username: observable,
      pw: observable,
      successToken: observable,
      tokenTime: observable,
      initFormData: action,
      isNumber: action,
    });

    this.initFormData();
  }

  initFormData() {
    const formData = {};

    formData.username = this.getDefaultInputData("username", false);
    formData.pw = this.getDefaultInputData("pw", false);

    this.formData = formData;
  }

  //공통으로 뺄 것
  changeInput(inputName, inputValue) {
    console.log(inputName);
    console.log(inputValue);
    let beforeFormData = toJS(this.formData);
    let inputData = beforeFormData[inputName];
    inputData.value = inputValue;
    //let validResult = this.checkValidation(inputData);
    let updateInputData = update(inputData, {
      $merge: {
        //touched: true,
        errorMessage: "필수항목입니다.", //validResult.errorMessage,
        isValid: "", //validResult.isValid,
        value: inputValue,
        byPassValid: false,
      },
    });
    let updateFormData = update(beforeFormData, {
      $merge: {
        [inputName]: updateInputData,
      },
    });
    this.formData = updateFormData;

    console.log(toJS(this.formData));
  }

  //공통으로 뺄 것 / 초기값 세팅
  getDefaultInputData(inputName, required, value) {
    if (!value) {
      if (this.isNumber(value)) {
        value = 0;
      } else {
        value = "";
      }
    }
    let inputData = {
      inputName: inputName,
      //touched = false,
      isRequired: required,
      isValid: true,
      errorMessage: "필수항목입니다.",
      value: value,
    };
    return inputData;
  }

  isNumber(value) {
    let success = false;
    if (value !== true && value !== "" && !isNaN(value)) {
      success = true;
    }
    return success;
  }

  login() {
    if (this.validate()) {
      const apiParam = this.getApiParam();

      //Object.assign(apiParam, 여기에 추가할 데이터)
      // ApiService.post("signin", apiParam).then((response) => {
      //   runInAction(() => {
      //     this.loginSuccessHandler(response);
      //   });
      // });
      return ApiService.post("signin", apiParam);
    }
  }

  //유효성 체크 필요
  validate() {
    return true;
  }

  loginSuccessHandler(response) {
    let { data } = response;

    this.successToken = data;
    //비어있으면 만료시간 설정
    // if (_.isEmpty(this.expirationTime)) {
    //   this.expirationTime = new Date(new Date().getTime() + 60 * 100);
    // }
  }
  loginCheck() {
    if (!_.isEmpty(this.successToken)) {
      return true;
    } else {
      return false;
    }
  }
  getApiParam() {
    let formData = this.formData;
    let inputKeys = _.keys(formData);
    let apiParam = {};
    inputKeys.forEach((key) => {
      let inputData = formData[key];
      if (inputData.value) {
        if (inputData.keyName) {
          apiParam[key] = inputData.value[inputData.keyName];
        } else {
          apiParam[key] = inputData.value;
        }
      } else {
        apiParam[key] = null;
      }
    });
    return apiParam;
  }
}

export default LoginStore;
