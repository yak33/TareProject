/*
 * @Author: ZHANGCHAO
 * @Date: 2025-02-19 09:44:36
 * @LastEditors: ZHANGCHAO
 * @LastEditTime: 2025-02-19 09:47:32
 * @FilePath: \vue3\src\router\index.ts
 */
import { createRouter, createWebHistory } from 'vue-router'
import type { RouteRecordRaw } from 'vue-router'

const routes: RouteRecordRaw[] = [
  {
    path: '/',
    name: 'home',
    component: () => import('@/views/home/index.vue')
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
