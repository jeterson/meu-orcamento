import { Notify } from "quasar";

interface ISuccess {
  message: string;
  type?: "warning" | "positive" | "info";
  time?: number;
}

export default () => {
  const successNotify = (success: any) => {
    Notify.create({
      type: "positive",
      message: success.response?.data?.message || success.message,
      progress: true,
    });
  };
  const personSuccessNotify = (success: ISuccess) => {
    Notify.create({
      type: success.type || "positive",
      message: success.message,
      timeout: success.time || 3000,
      progress: true,
    });
  };

  return {
    successNotify,
    personSuccessNotify,
  };
};
