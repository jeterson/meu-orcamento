import { Notify,QSpinnerGears } from "quasar";
import { AxiosErrorData } from "src/boot/axios";
import { MessageService } from "src/services/notify/MessageService";

const service = new MessageService();

interface IError {
  message: string;
  type: "warning" | "positive" | "negative" | "info";
  action: Function;
}
interface ISuccess {
  message: string;
  type?: "warning" | "positive" | "info";
  time?: number;
}

const showMessageError = (err: AxiosErrorData) => service.notifyError(err);

const personSuccessNotify = (success: ISuccess) => {
  Notify.create({
    type: success.type || "positive",
    message: success.message,
    timeout: success.time || 3000,
    progress: true,
  });
};
const successNotify = (success: any) => {
  Notify.create({
    type: "positive",
    message: success.response?.data?.message || success.message,
    progress: true,
  });
};


const personalizedNotifyDismiss = (error: IError) => {
  return new Promise((resolve, reject) => {
    let cancelar = false;
    Notify.create({
      color: error.type,
      message: error.message,
      timeout: 2000,
      spinner: QSpinnerGears,
      actions: [
        {
          label: "Cancelar",
          color: "yellow",
          handler() {
            cancelar = true;
          },
        },
      ],
      onDismiss() {
        if (!cancelar) {
          setTimeout(() => {
            resolve(error.action());
          }, 2000);
        }
      },
    });
  });
};

export default () => ({
  showMessageError,
  personalizedNotifyDismiss,
  personSuccessNotify,
  successNotify
})