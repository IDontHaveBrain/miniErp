import { action, computed, observable, runInAction, toJs } from "mobx";

/* 전역 data manage store
 ex> 회원정보, 토큰 , 에러도...?
*/

class AppStore {
    constructor(rootStore) {
        this.rootStpre = rootStore;
    }
}

export default AppStore;
