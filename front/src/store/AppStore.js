import {
  action,
  computed,
  makeAutoObservable,
  observable,
  runInAction,
  toJS,
} from "mobx";
// import RootStore from "./store/RootStore"; rootStore와 각 store간의 순환참조로 인한 에러 발생 추측
/* 전역 data manage store
 ex> 회원정보, 토큰 , 에러도...?
*/

class AppStore {
  token = "";

  constructor(RootStore) {
    this.RootStore = RootStore;
    makeAutoObservable(this, {
      token: observable,
      handleUnauthorizedError: action,
    });
  }
  //인터셉터에서 token정보 없거나 유효기간 만료시 호출할 것
  handleUnauthorizedError(httpError) {
    alert("인증정보가 없어 로그아웃됩니다.");
    this.RootStore.AppStore.logout();
  }
  // getTest() {
  //   console.log("s");
  //   return this.test1;
  // }
}

export default AppStore;
