import {
  action,
  computed,
  makeAutoObservable,
  observable,
  runInAction,
  toJS,
} from "mobx";

/* 전역 data manage store
 ex> 회원정보, 토큰 , 에러도...?
*/

class AppStore {
  test1 = "1111";

  constructor(RootStore) {
    this.RootStore = RootStore;
    makeAutoObservable(this);
  }

  changeTest() {
    this.test1 = "test입니다";
  }

  getTest() {
    console.log("s");
    return this.test1;
  }
}

export default AppStore;
