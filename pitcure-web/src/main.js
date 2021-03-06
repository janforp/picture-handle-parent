// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'

Vue.config.productionTip = false;

import axios from 'axios';
window.axios=axios;

// axios.defaults.baseURL='http://localhost:9001/';

import ElementUI from 'element-ui';
import 'element-ui/lib/theme-default/index.css';

Vue.use(ElementUI);

new Vue({
  el: '#app',
  router,
  template: '<App/>',
  components: { App }
})
