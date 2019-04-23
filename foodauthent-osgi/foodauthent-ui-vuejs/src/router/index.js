import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home'
import Sop from '@/components/sop/Sop'
import Product from '@/components/product/Product'
import Fingerprint from '@/components/fingerprint/Fingerprint'
import Workflow from '@/components/workflow/Workflow'
import Prediction from '@/components/prediction/Prediction'
import Predictionjob from '@/components/predictionjob/Predictionjob'
import Trainingjob from '@/components/trainingjob/Trainingjob'
import Model from '@/components/model/Model'
import ObjectEvent from '@/components/objectEvent/ObjectEvent'
import DiscoveryService from '@/components/discoveryService/DiscoveryService'
import Sample from '@/components/sample/Sample'
import Login from '@/components/login/Login'
import Logout from '@/components/login/Logout'
import Register from '@/components/login/Register'
//import Test from '@/components/test/Test'


Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home,
      meta: { notdisplay: false }
    },
      {
      path: '/sop',
      name: 'Sop',
      component: Sop,
      meta: { notdisplay: false }
     },
      {
      path: '/product',
      name: 'Product',
      component: Product,
      meta: { notdisplay: false }
    },
      {
      path: '/prediction',
      name: 'Prediction',
      component: Prediction,
      meta: { notdisplay: false }
    },
    {
      path: '/predictionjob',
      name: 'Prediction Job',
      component: Predictionjob,
      meta: { notdisplay: false }
    },
        {
      path: '/trainingjob',
      name: 'Training Job',
      component: Trainingjob,
      meta: { notdisplay: false }
    },
      {
      path: '/fingerprint',
      name: 'Fingerprint Set',
      component: Fingerprint,
      meta: { notdisplay: false }
    },
      {
      path: '/workflow',
      name: 'Workflow',
      component: Workflow,
      meta: { notdisplay: false }
    },
     {
      path: '/model',
      name: 'Model',
      component: Model,
      meta: { notdisplay: false }
      },
    {
     path: '/objectEvent',
     name: 'ObjectEvent',
     component: ObjectEvent,
     meta: { notdisplay: false }
     },
     {
     path: '/discoveryService',
     name: 'DiscoveryService',
     component: DiscoveryService,
     meta: { notdisplay: false }
     },
     {
     path: '/sample',
     name: 'Sample',
     component: Sample,
     meta: { notdisplay: false }
     },
     {
     path: '/login',
     name: 'Login',
     component: Login,
     meta: { notdisplay: true }
     },
     {
     path: '/logout',
     name: 'Logout',
     component: Logout,
     meta: { notdisplay: true }
     },
     {
     path: '/register',
     name: 'Register',
     component: Register,
     meta: { notdisplay: true }
     },
//         {
//             path: '/test',
//             name: 'Test',
//             component: Test
//             },
  ]
});


