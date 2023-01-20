import { CredentialsRequest, TokenResponse } from "src/models/login";
import { BaseServiceApi } from "../BaseService";

export class LoginService extends BaseServiceApi {

  private readonly TOKEN_KEY = 'sac.interno.winthor.token';

  async login(credentialsRequest: CredentialsRequest): Promise<TokenResponse> {
    try{
      var response = await this.request.post('/login', credentialsRequest);
      this.storeToken(response.data);
      return response.data
    }catch(err) {
      throw this.handleError(err);
    }
  }

  async validateToken():Promise<boolean> {    
    var tokenData = this.getToken()
    if(!tokenData)
      return false;
    
    try{
      var response = await this.request.get('/auth/validate-token', {params: {token: tokenData?.token}})
      return response.data.valid;
    }catch(err) {
      throw this.handleError(err);
    }
  }

  storeToken(token: TokenResponse) {
    localStorage.setItem(this.TOKEN_KEY, JSON.stringify(token))
  }

  getToken(): TokenResponse|null {
    var tokenString = localStorage.getItem(this.TOKEN_KEY)
    if(!tokenString)
      return null;
    
    var token = JSON.parse(tokenString)
    
    if(!token)
      return null;

    return token as TokenResponse;
  }

  isLogged(): boolean {
    return this.getToken() != null;
  }

  logout() {
    localStorage.removeItem(this.TOKEN_KEY)
  }
}
