import { boot } from "quasar/wrappers";
import Menu from "components/Menu.vue";
import InputContainer from "components/InputContainer.vue";


export default boot(({ app }) => {
  app.component("j-menu", Menu);
  app.component("j-container", InputContainer);
});