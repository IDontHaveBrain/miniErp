import AppStore from "./AppStore";
import LoginStore from "./login/LoginStore";
import HomeStore from "./home/HomeStore";

/*
const RooStore = () => ({
  AppStore,
});

export default RooStore;
*/

class RootStore {
  constructor() {
    this.appStore = new AppStore(this);
    this.loginStore = new LoginStore(this);
    this.homeStore = new HomeStore(this);
  }
}

const rootStore = new RootStore();
export default rootStore;
