import Api from "../service/Api";

const apiPrefixUri = "http://localhost:8085/api/";

class ApiService {
  get(apiUri, params, config) {
    config = config || {};
    config.params = params;
    return Api.get(apiPrefixUri + apiUri, config);
  }
  post(apiUri, body, config) {
    body = body || {};
    console.log(body);
    console.log(config);
    return Api.post(apiPrefixUri + apiUri, body, config);
  }
  put(apiUri, body, config) {
    body = body || {};
    return Api.put(apiPrefixUri + apiUri, body, config);
  }
  patch(apiUri, body, config) {
    body = body || {};
    return Api.patch(apiPrefixUri + apiUri, body, config);
  }
  delete(apiUri, body, config) {
    body = body || {};
    return Api.delete(apiPrefixUri + apiUri, body, config);
  }
}

export default new ApiService();
