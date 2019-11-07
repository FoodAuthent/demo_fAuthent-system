import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home'
import Sop from '@/components/sop/Sop'
import Product from '@/components/product/Product'
import Fingerprint from '@/components/fingerprint/Fingerprint'
import Fingerprintset from '@/components/fingerprintset/Fingerprintset'
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
import File from '@/components/file/File'


Vue.use(Router)

export default new Router({
    routes: [
        {
            path: '/',
            name: 'Home',
            component: Home,
            meta: {
               
            }
    },
        {
            path: '/sop',
            name: 'Sop',
            component: Sop,
            meta: {
                Experiments: true
            }
     },
        {
            path: '/product',
            name: 'Product',
            component: Product,
            meta: {
                Experiments: true
            }
    },
        {
            path: '/sample',
            name: 'Sample',
            component: Sample,
            meta: {
                Experiments: true
            }
        },
        {
            path: '/fingerprintsets',
            name: 'Fingerprint Set',
            component: Fingerprintset,
            meta: {
                Experiments: true
            }
          },
          {
              path: '/fingerprints',
              name: 'Fingerprint',
              component: Fingerprint,
              meta: {
                  Experiments: true
              }
            },
        {
            path: '/prediction',
            name: 'Prediction',
            component: Prediction,
            meta: {
                Analytics: true
            }
    },
        {
            path: '/predictionjob',
            name: 'Prediction Job',
            component: Predictionjob,
            meta: {
                Analytics: true
            }
    },
        {
            path: '/trainingjob',
            name: 'Training Job',
            component: Trainingjob,
            meta: {
                Analytics: true
            }
    },
        {
            path: '/model',
            name: 'Model',
            component: Model,
            meta: {
                Analytics: true
            }
        },
        {
            path: '/workflow',
            name: 'Workflow',
            component: Workflow,
            meta: {
                Analytics: true
            }
    },
        {
            path: '/objectEvents',
            name: 'ObjectEvent',
            component: ObjectEvent,
            meta: {
                Tracing: true
            }
     },
        {
            path: '/transactions',
            name: 'DiscoveryService',
            component: DiscoveryService,
            meta: {
                Tracing: true
            }
     },
        {
            path: '/login',
            name: 'Login',
            component: Login,
            meta: {
                notdisplay: true
            }
     },
        {
            path: '/logout',
            name: 'Logout',
            component: Logout,
            meta: {
                notdisplay: true
            }
     },
        {
            path: '/register',
            name: 'Register',
            component: Register,
            meta: {
                notdisplay: true
            }
     },
        {
            path: '/file',
            name: 'File',
            component: File,
            meta: {
                Misc: true
            }
         },
//         {
//             path: '/test',
//             name: 'Test',
//             component: Test
//             },
  ]
});
