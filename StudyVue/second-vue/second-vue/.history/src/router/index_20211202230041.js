import Vue from "vue"
import Router from 'vue-router'
import login from '../src/views/login'

export default new Router({
    routes:[{
        //登录页
        path:'/login',
        name:'login',
        component:login
    }]
})