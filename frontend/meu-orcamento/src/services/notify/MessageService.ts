import {Notify} from 'quasar'
import { AxiosErrorData } from 'src/boot/axios';

type NotifyPositionType = "top-left" | "top-right" | "bottom-left" | "bottom-right" | "top" | "bottom" | "left" | "right" | "center" | undefined

export class MessageService {

  notifyError(err: AxiosErrorData) {
   var type = this.getNotifyType(err);
   var position = this.getMessagePosition(err)
   Notify.create({
    type: type,
    message: err.message,
    progress: true,
    position: position
   })
  }

  private getMessagePosition(err: AxiosErrorData): NotifyPositionType {
    switch(err.status) {
      case 401:
      case 403:
      case 500:
      case 400:
      case 404:
        return 'center'
      case 200:
      case 201:
      case 204:
        return 'bottom'
      default:
        return 'bottom'
    }
  }
  private getNotifyType(err: AxiosErrorData):string {
    switch(err.status) {
      case 403:
      case 401:
      case 400:
        return 'warning'
      case 404:
        return 'negative'
      case 200:
      case 201:
      case 204:
        return 'positive'
      default:
        return ''
    }
  }
}