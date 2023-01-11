import { makeObservable, observable, action, toJS, runInAction } from "mobx";
import { ApiService } from "../../service/ApiService";

class HomeStore {
  constructor(rootStore) {
    this.rootStore = rootStore;

    makeObservable(this, {});
  }

  loginCheck() {
    return this.rootStore.loginStore.loginCheck();
  }
}

export default HomeStore;
