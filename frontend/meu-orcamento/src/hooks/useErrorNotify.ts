import { Notify } from "quasar";

interface IError {
  message: string;
  type?: "warning" | "negative" | "info";
  icon?: string;
  caption?: string;
}

export default () => {
  const errorNotify = (error: any) => {
    Notify.create({
      type: "negative",
      message: error.response?.data?.message || error.message,
      icon: "report_problem",
      progress: true,
    });
  };
  const personErrorNotify = (error: IError) => {
    Notify.create({
      color: error.type || "negative",
      message: error.message,
      icon: error.icon || "report_problem",
      caption: error.caption,
      progress: true,
    });
  };

  return {
    errorNotify,
    personErrorNotify,
  };
};
