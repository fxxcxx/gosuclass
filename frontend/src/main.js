<<<<<<< HEAD
/**
 * main.js
 *
 * Bootstraps Vuetify and other plugins then mounts the App`
 */
=======
/*eslint-disable*/
import Vue from "vue";
import App from "./App.vue";
import vuetify from "./plugins/vuetify";
import Managing from "./components";
import router from "./router";
Vue.config.productionTip = false;
require("./GlobalStyle.css");
>>>>>>> 5630

// Plugins
import { registerPlugins } from '@/plugins'

// Components
import App from './App.vue'

<<<<<<< HEAD
// Composables
import { createApp } from 'vue'

const app = createApp(App)
=======
// axios.backendUrl = new URL(axios.backend);
axios.fixUrl = function (original) {
  if (!axios.backend && original.indexOf("/") == 0) return original;
>>>>>>> 5630

registerPlugins(app)

<<<<<<< HEAD
app.mount('#app')
=======
  try {
    url = new URL(original);
  } catch (e) {
    url = new URL(axios.backend + original);
  }

  if (!axios.backend) return url.pathname;

  url.hostname = axios.backendUrl.hostname;
  url.port = axios.backendUrl.port;

  return url.href;
};

const templateFiles = require.context("./components", true);
Vue.prototype.$ManagerLists = [];
templateFiles.keys().forEach(function (tempFiles) {
  if (!tempFiles.includes("Manager.vue") && tempFiles.includes("vue")) {
    Vue.prototype.$ManagerLists.push(
      tempFiles.replace("./", "").replace(".vue", "")
    );
  }
});
Vue.use(Managing);
const pluralCaseList = [];

pluralCaseList.push({
  plural: "registrations/registrations",
  pascal: "RegistrationRegistration",
});

pluralCaseList.push({
  plural: "gosuclasses/gosuClasses",
  pascal: "GosuclassGosuClass",
});

pluralCaseList.push({
  plural: "evaluations/evaluations",
  pascal: "EvaluationEvaluation",
});

pluralCaseList.push({
  plural: "histories/histories",
  pascal: "HistoryHistory",
});

pluralCaseList.push({
  plural: "recommends/recommends",
  pascal: "RecommendRecommend",
});

Vue.prototype.$ManagerLists.forEach(function (item, idx) {
  pluralCaseList.forEach(function (tmp) {
    if (item.toLowerCase() == tmp.pascal.toLowerCase()) {
      var obj = {
        name: item,
        plural: tmp.plural,
      };
      Vue.prototype.$ManagerLists[idx] = obj;
    }
  });
});

new Vue({
  vuetify,
  router,
  render: (h) => h(App),
}).$mount("#app");
>>>>>>> 5630
