import { createRouter, createWebHistory } from 'vue-router'
import { IndexInfo } from './IndexInfo.js'

import Index from '../views/Index.vue'
import { filterAsyncRoutes } from './filterAsyncRoutes.js'
const routerHistory = createWebHistory()

const children = []
// mock json转路由
filterAsyncRoutes(IndexInfo.workList, children)
const router = createRouter({
  history: routerHistory,
  routes: [
  {
    path: '',
    component: Index,
    children: children

  }
  // ,
  // other

]

})

export default router






/*
const router = createRouter({
  history: routerHistory,
  routes: [
  {
    path: '',
    component: Index,
    children:
     [
      // -----------------------------------------------当前测试
      {
        path: '',
        name: 'FullProject',
        component: Index1,
        // component: () =>
        //   import(
        //     '../views/App/Index/FullProject.vue'
        //   ),
      },
      // -----------------------------------------------Cesium
      {
        path: '/App/GL/Cesium/CesiumStart',
        // path: '/App/GL/Cesium/CesiumStart',
        name: 'CesiumStart',
        component: () => import('../views/App/GL/Cesium/CesiumStart.vue'),
      },
    ],
  },
  {
    path: '/EasyCAD',
    name: 'EasyCAD',
    component: () => import('../views/App/EasyCAD/Index.vue'),
  },
    {
      path: 'novel',
      name: 'App_EasyCAD_Index',
      component: () => import('../views/App/Library/novel.vue'),
    }, ]
})
*/