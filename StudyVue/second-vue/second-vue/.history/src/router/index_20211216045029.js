import Vue from "vue"
import Router from 'vue-router'
import login from '../views/login'
import signUp from '../views/signUp'
import admin from '../views/admin'
import doctor from '../views/do'

export default new Router({
    routes:[{
        //登录页
        path:'/login',
        name:'login',
        component:login
    }, {
        //注册页
        path:'/signUp',
        name:'signUp',
        component: signUp
    }, {
        //管理员界面
        path:'/admin',
        name:'admin',
        component: admin
    }]
})