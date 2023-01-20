<template>
  <q-layout view="hHh LpR lFf">
    <q-header bordered>
      <q-toolbar>
        <q-btn
          flat
          dense
          round
          icon="menu"
          @click="leftDrawerOpen = !leftDrawerOpen"
        />
        <q-toolbar-title>
          <router-link class="title" to="/">{{ productName }} </router-link>
        </q-toolbar-title>

        <q-btn
          class="title"
          flat
          rounded
          icon-right="account_circle"
          :label="user?.name"
        />
      </q-toolbar>
    </q-header>

    <q-drawer
      v-model="leftDrawerOpen"
      side="left"
      :width="300"
      :breakpoint="500"
      bordered
    >
      <j-menu @logout="logoutPage" />
    </q-drawer>

    <q-page-container>
      <router-view />
    </q-page-container>

    <q-footer elevated class="bg-primary1 title">
      <q-toolbar>
        <q-toolbar-title>
          <small>&copy; {{ copyright }} - Jeterson</small>
        </q-toolbar-title>
        <q-space></q-space>
        <small @click="copyToClipBoard">Powered By {{ author }}</small>
        <strong @click="copyToClipBoard"
          ><small>&nbsp;&nbsp;Versão {{ appVersion }}</small></strong
        >
      </q-toolbar>
    </q-footer>
  </q-layout>
</template>

<script lang="ts">
import { defineComponent, ref } from "vue";
import pachageInfo from "../../package.json";
import { useRouter } from "vue-router";
import { ELogin } from "src/enums/routes";
import { copyToClipboard } from "quasar";
import useLoginService from "src/hooks/useLoginService";
import questionLogout from "src/hooks/useNotifyDismiss";
import useSuccessNotify from "src/hooks/useSuccessNotify";
import useCatchError from "src/hooks/useErrorNotify";

export default defineComponent({
  name: "MainLayout",

  setup() {
    const $router = useRouter();
    const { logout,userToken } = useLoginService();
    const {personalizedNotifyDismiss} = questionLogout()   
    const {personErrorNotify} = useCatchError() 
    const { personSuccessNotify } = useSuccessNotify();

    const logoutPage = async () => {
      await personalizedNotifyDismiss({
        message: "Desconectando...",
        type: "info",
        action: logout,
      });

      $router.push({ path: ELogin.Path });
    };

    const copyToClipBoard = () => {
      copyToClipboard("Precisando entre em contato! | jetersonsi@gmail.com")
        .then(() => {
          personSuccessNotify({
            message: "Dados Copiados para a área de transferência!",
          });
        })
        .catch(() => {
          console.log('Erro ao copiar para area de transferencia')
        });
    };

    return {
      leftDrawerOpen: ref(true),
      miniState: ref(false),
      appVersion: pachageInfo.version,
      author: pachageInfo.author,
      copyright: pachageInfo.copyright,
      productName: pachageInfo.productName,
      logoutPage,
      user: userToken(),
      copyToClipBoard,
    };
  },
});
</script>

<style>
.title {
  text-decoration: none;
  color: white;
  font-family: "Poppins", sans-serif;
}
.q-drawer__content {
  background-color: #0c9abe !important;
}
</style>
