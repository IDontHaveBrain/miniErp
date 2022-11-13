import AppStore from "./AppStore";

/*
const RooStore = () => ({
  AppStore,
});

export default RooStore;
*/

class RootStore {
  constructor() {
    this.appStore = new AppStore(this);
  }
}

export default new RootStore();
