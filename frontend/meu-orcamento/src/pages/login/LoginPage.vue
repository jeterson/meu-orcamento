<template>
  <div class="body">
    <img class="wave" src="wave.png" />
    <div class="container">
      <div class="img">
        <img src="undraw_savings_re_eq4w.svg" />
      </div>
      <div class="login-content">
        <form>
          <img src="undraw_profile_pic_ic5t_blue.svg" />
          <h2 class="title">Bem-Vindo</h2>
          <div class="input-div input-div-blue one">
            <div class="i">
              <i class="fas fa-user"></i>
            </div>
            <div class="div">
              <h5>Usuário</h5>
              <input @keyup.enter="performLogin" v-model="credentials.username" type="text" class="input" />
            </div>
          </div>
          <div class="input-div input-div-blue pass">
            <div class="i">
              <i class="fas fa-lock"></i>
            </div>
            <div class="div">
              <h5>Senha</h5>
              <input @keyup.enter="performLogin" v-model="credentials.password" type="password" class="input" />
            </div>
          </div>
          <a class="cursor-pointer" @click="forgotPassword">Esqueceu sua senha?</a>
          <input @click="performLogin" :disabled="loading" type="button" class="btn btn-blue"
            :value="loading ? 'Aguarde...' : 'Login'" />
        </form>
      </div>
    </div>
  </div>
</template>
<script lang="ts">
import { useQuasar } from 'quasar';
import { AxiosErrorData } from 'src/boot/axios';
import useLoginService from 'src/hooks/useLoginService';
import useMessageService from 'src/hooks/useMessageService';
import { CredentialsRequest } from 'src/models/login';
import { defineComponent, ref } from 'vue';
import { useRouter } from 'vue-router';

export default defineComponent({
  name: 'LoginPage',
  mounted() {
    this.focusInput();
  },
  setup() {
    const $router = useRouter();
    const $q = useQuasar()
    const { login } = useLoginService()
    const { showMessageError } = useMessageService()
    const credentials = ref<CredentialsRequest>({ password: '', username: '' })
    const loading = ref<boolean>(false);

    const forgotPassword = () => {
      $q.dialog({
        message:
          "Para recuperar a senha, por favor entre em contato com o suporte do sistema.",
        title: "Atenção",
        dark: true,
      });
    };

    const performLogin = async () => {
      try {
        loading.value = true
        await login(credentials.value)
        $router.push('/')

      } catch (e) {
        var err = e as AxiosErrorData
        showMessageError(err)
      } finally {
        loading.value = false
      }
    }

    const focusInput = () => {
      const inputs = document.querySelectorAll(".input");
      inputs.forEach((input: any) => {
        input.addEventListener("focus", () => {
          const parent: any = input.parentNode?.parentNode;
          parent?.classList?.add("focus");
        });

        input.addEventListener("blur", () => {
          const parent: any = input.parentNode?.parentNode;
          if (input.value == "") {
            parent.classList.remove("focus");
          }
        });
      });
    };

    return {
      credentials,
      performLogin,
      loading,
      forgotPassword,
      focusInput
    }
  }
})
</script>
<style scoped>

/*https://www.youtube.com/watch?v=t-EMinSz_Tk*/
* {
  padding: 0;
  margin: 0;
  box-sizing: border-box;
}

.body {
  font-family: "Poppins", sans-serif;
}
.title {
  font-family: "Poppins", sans-serif;
}
.wave {
  position: fixed;
  bottom: 0;
  left: 0;
  height: 100%;
  z-index: -1;
}

.container {
  width: 100vw;
  height: 100vh;
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  grid-gap: 7rem;
  padding: 0 2rem;
}

.img {
  display: flex;
  justify-content: flex-end;
  align-items: center;
}

.login-content {
  display: flex;
  justify-content: flex-start;
  align-items: center;
  text-align: center;
}

.img img {
  width: 500px;
}

form {
  width: 360px;
}

.login-content img {
  height: 100px;
}

.login-content h2 {
  margin: 15px 0;
  color: #333;
  text-transform: uppercase;
  font-size: 2.9rem;
}

.login-content .input-div {
  position: relative;
  display: grid;
  grid-template-columns: 7% 93%;
  margin: 25px 0;
  padding: 5px 0;
  border-bottom: 2px solid #d9d9d9;
}

.login-content .input-div.one {
  margin-top: 0;
}

.i {
  color: #d9d9d9;
  display: flex;
  justify-content: center;
  align-items: center;
}

.i i {
  transition: 0.3s;
}

.input-div > div {
  position: relative;
  height: 45px;
}

.input-div > div > h5 {
  position: absolute;
  left: 10px;
  top: 50%;
  transform: translateY(-50%);
  color: #999;
  font-size: 18px;
  transition: 0.3s;
}

.input-div:before,
.input-div:after {
  content: "";
  position: absolute;
  bottom: -2px;
  width: 0%;
  height: 2px;
  background-color: #00D253;
  transition: 0.4s;
}

.input-div-blue:after .input-div-blue:before {
  background-color: #00D253;
}

.input-div:before {
  right: 50%;
}

.input-div:after {
  left: 50%;
}

.input-div.focus:before,
.input-div.focus:after {
  width: 50%;
}

.input-div.focus > div > h5 {
  top: -5px;
  font-size: 15px;
}

.input-div.focus > .i > i {
  color: #00D253;
}

.input-div > div > input {
  position: absolute;
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
  border: none;
  outline: none;
  background: none;
  padding: 0.5rem 0.7rem;
  font-size: 1.2rem;
  color: #555;
  font-family: "poppins", sans-serif;
}

.input-div.pass {
  margin-bottom: 4px;
}

a {
  display: block;
  text-align: right;
  text-decoration: none;
  color: #999;
  font-size: 0.9rem;
  transition: 0.3s;
}

a:hover {
  color: #34b2ce;
}

.btn {
  display: block;
  width: 100%;
  height: 50px;
  border-radius: 25px;
  outline: none;
  border: none;
  /*background-image: linear-gradient(to right, #32be8f, #38d39f, #32be8f);*/
  background-size: 200%;
  font-size: 1.2rem;
  color: #fff;
  font-family: "Poppins", sans-serif;
  text-transform: uppercase;
  margin: 1rem 0;
  cursor: pointer;
  transition: 0.5s;
}

.btn-blue {
  background-image: linear-gradient(to right, #00D253, #34b2ce, #00D253);
}
.btn:hover {
  background-position: right;
}

@media screen and (max-width: 1050px) {
  .container {
    grid-gap: 5rem;
  }
}

@media screen and (max-width: 1000px) {
  form {
    width: 290px;
  }

  .login-content h2 {
    font-size: 2.4rem;
    margin: 8px 0;
  }

  .img img {
    width: 400px;
  }
}

@media screen and (max-width: 900px) {
  .container {
    grid-template-columns: 1fr;
  }

  .img {
    display: none;
  }

  .wave {
    display: none;
  }

  .login-content {
    justify-content: center;
  }
}

</style>
