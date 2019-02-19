import Vue from 'vue'
import Router from 'vue-router'
import Main from '@/components/Main'
import Sop from '@/components/sop/Sop'
import Product from '@/components/product/Product'
import Fingerprint from '@/components/fingerprint/Fingerprint'
import Workflow from '@/components/workflow/Workflow'
import Prediction from '@/components/prediction/Prediction'
import Predictionjob from '@/components/predictionjob/Predictionjob'
import Trainingjob from '@/components/trainingjob/Trainingjob'
import Model from '@/components/model/Model'
import ObjectEvent from '@/components/objectEvent/ObjectEvent'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Main',
      component: Main
    },
      {
      path: '/sop',
      name: 'Sop',
      component: Sop,
     },
      {
      path: '/product',
      name: 'Product',
      component: Product
    },
      {
      path: '/prediction',
      name: 'Prediction',
      component: Prediction
    },
    {
      path: '/predictionjob',
      name: 'Prediction Job',
      component: Predictionjob
    },
        {
      path: '/trainingjob',
      name: 'Training Job',
      component: Trainingjob
    },
      {
      path: '/fingerprint',
      name: 'Fingerprint Set',
      component: Fingerprint
    },
      {
      path: '/workflow',
      name: 'Workflow',
      component: Workflow
    },
     {
      path: '/model',
      name: 'Model',
      component: Model,
      },
    {
     path: '/objectEvent',
     name: 'ObjectEvent',
     component: ObjectEvent,
     }
  ]
})
