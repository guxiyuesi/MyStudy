import Vue from "vue"
import Router from 'vue-router'
import login from '../views/login'
import signUp from '../views/signUp'
import admin from '../views/admin'

export default new Router({
    routes:[{
        //登录页
        path:'/login',
        name:'login',
        component:login
    }, {
        //注册ye
        path:'/signUp',
        name:'signUp',
        component: signUp
    }, {
        path:'/admin',
        name:'admin',
        component: admin
    }]
})