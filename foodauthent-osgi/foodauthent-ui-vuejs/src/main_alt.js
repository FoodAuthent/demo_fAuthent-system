//The Vue build version to load with the `import` command
//(runtime-only or standalone) has been set in webpack.base.conf with an alias.
import App from './App';
import Vue from 'vue';
import BootstrapVue from 'bootstrap-vue';
import VueMaterial from 'vue-material';
import VueFormGenerator from "vue-form-generator";
import VueResource from 'vue-resource';
import ModuleLibrary from 'vfg-field-array';
import ModuleLibrary2 from 'vfg-field-object';
import fieldSelectModel from '@/components/customFields/fieldSelectModel';
import fieldLoadFile from '@/components/customFields/fieldLoadFile';

import 'vue-material/dist/vue-material.min.css';
import 'vue-material/dist/theme/default.css';
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap-vue/dist/bootstrap-vue.css';
import "vue-form-generator/dist/vfg.css";

import { store } from '@/login/_store';
import { router } from '@/login/_helpers';

Vue.use(ModuleLibrary);

Vue.use(ModuleLibrary2);

Vue.use(VueResource);

Vue.use(VueFormGenerator);

Vue.use(VueMaterial);

Vue.use(BootstrapVue);

Vue.component("fieldSelectModel", fieldSelectModel);
Vue.component("fieldLoadFile", fieldLoadFile);


Vue.config.productionTip = false
Vue.config.devtools = true


new Vue({
el: '#app',
router,
store,
render: h => h(App)
})





