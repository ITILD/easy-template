import {
  createRouter,
  createWebHashHistory
} from 'vue-router'
import Home from '../views/Home.vue'

const routes = [
  //   {
  //   path: '/',
  //   name: 'Home',
  //   component: Home
  // },
  {
    path: '/',
    name: 'TheThree',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import( /* webpackChunkName: "TheThree" */ '../views/TheThree.vue')
  },
  {
    path: '/TheCesium',
    name: 'TheCesium',
    component: () => import('../views/TheCesium.vue')
  },
  {
    path: '/TheBabylons',
    name: 'TheBabylons',
    component: () => import('../views/TheBabylons.vue')
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router