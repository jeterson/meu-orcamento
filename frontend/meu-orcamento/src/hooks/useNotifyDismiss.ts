import { Notify, QSpinnerGears } from "quasar";

interface IError {
  message: string;
  type: "warning" | "positive" | "negative" | "info";
  action: Function;
}

export default () => {
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

  return {
    personalizedNotifyDismiss,
  };
};
