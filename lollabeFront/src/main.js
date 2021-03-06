import Vue from 'vue'
import App from './App.vue'
import router from './routes/router.js';
import vSelect from 'vue-select';


Vue.config.productionTip = false
Vue.component('v-select', vSelect)


new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
