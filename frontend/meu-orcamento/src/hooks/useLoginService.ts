import { CredentialsRequest } from "src/models/login";
import { LoginService } from "src/services/login/LoginService";
import useErrorNotify from "./useErrorNotify";

const service = new LoginService();
const {personErrorNotify} = useErrorNotify()
const login = async (credentials: CredentialsRequest) => service.login(credentials)
const validateToken = async () => service.validateToken();
const isLogged = () => service.isLogged();
const logout = () => service.logout();
const userToken = () => service.getToken();

const toLoginTokenExpired = () => {
  logout();
  personErrorNotify({
    message: "Seu token expirou, faça login novamente!",
    type: "warning",
  });

  setTimeout(() => {
    window.location.reload();
  }, 7000);
};


export default () => ({
  login,
  validateToken,
  isLogged,
  logout,
  userToken,
  toLoginTokenExpired
})