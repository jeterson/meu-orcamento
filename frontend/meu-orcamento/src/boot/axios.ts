import { boot } from 'quasar/wrappers';
import axios, { AxiosInstance } from 'axios';
import useLoginService from 'src/hooks/useLoginService';

declare module '@vue/runtime-core' {
  interface ComponentCustomProperties {
    $axios: AxiosInstance;
  }
}

export interface AxiosErrorData {
  message?: string;
  error?: string;
  status?: number
}

// Be careful when using SSR for cross-request state pollution
// due to creating a Singleton instance here;
// If any client changes this (global) instance, it might be a
// good idea to move this instance creation inside of the
// "export default () => {}" function below (which runs individually
// for each client)
const api = axios.create({ baseURL: 'http://localhost:8080' });

export default boot(({ app }) => {
  // for use inside Vue files (Options API) through this.$axios and this.$api

  app.config.globalProperties.$axios = axios;
  // ^ ^ ^ this will allow you to use this.$axios (for Vue Options API form)
  //       so you won't necessarily have to import axios in each vue file

  app.config.globalProperties.$api = api;
  // ^ ^ ^ this will allow you to use this.$api (for Vue Options API form)
  //       so you can easily perform requests against your app's API
});


api.interceptors.request.use(async (request) => {
  if(request.url?.includes("validate-token")){
    return request;
  }
  const { userToken, toLoginTokenExpired, validateToken } = useLoginService();

  const data = await userToken();
  if (data) {
    if (!request.url?.includes("login")) {
      request.headers.Authorization = `Bearer ${data.token}`;
    }

    const valid = await validateToken();
    if (valid) {
      return request;
    } else {
      toLoginTokenExpired();
    }
  }

  return request;
});

api.interceptors.response.use(
  (response) => {
    return response;
  },

  (err) => {
    console.log("bootErro ", err);
    const { toLoginTokenExpired } = useLoginService();
    if (err.response && err.response.status === 403) {
      toLoginTokenExpired();
    }
    if (err.response && err.response.status === 429) {
      alert("429 Too Many Requests!!");
      window.location.reload();
    }

    if (!err.response) {
      return Promise.reject({
        response: {
          data: { statusCode: 0, message: "Sem comunicação com o servidor" },
        },
      });
    }
    return Promise.reject(err);
  }
);

export { api };
