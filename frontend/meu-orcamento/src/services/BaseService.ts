import { AxiosInstance, AxiosResponse } from 'axios';
import { api, AxiosErrorData } from 'src/boot/axios'
export abstract class BaseServiceApi {
  protected request: AxiosInstance = api;

  handleError(err: any): AxiosErrorData {
    if (err.response) {
      var errorResponse = this.getStatusCodeBody(err.response as AxiosResponse)      
      return errorResponse;
    } else {
      return { message: 'Failed connect to server', status: 0, error: 'Server Unavailable' };
    }
  }

  private  getStatusCodeBody(error: AxiosResponse): AxiosErrorData {
    switch(error.status) {
      case 403:
        if(error.config.url == '/login'){
          return {message: 'Usuário e/ou senha inválidos', status: 401, error: 'Bad Credentials'}
        }
        return {message: 'Acesso Negado', status: 403, error: 'Forbidden'}
      default:
        return {status: error.status, message: error.data.message, error: error.data.code}
    }
  }
}
