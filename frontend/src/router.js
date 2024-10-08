
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import RegistrationRegistrationManager from "./components/listers/RegistrationRegistrationCards"
import RegistrationRegistrationDetail from "./components/listers/RegistrationRegistrationDetail"

import ClassClassManager from "./components/listers/ClassClassCards"
import ClassClassDetail from "./components/listers/ClassClassDetail"

import EvaluationEvaluationManager from "./components/listers/EvaluationEvaluationCards"
import EvaluationEvaluationDetail from "./components/listers/EvaluationEvaluationDetail"

import HistoryHistoryManager from "./components/listers/HistoryHistoryCards"
import HistoryHistoryDetail from "./components/listers/HistoryHistoryDetail"

import RecommendRecommendManager from "./components/listers/RecommendRecommendCards"
import RecommendRecommendDetail from "./components/listers/RecommendRecommendDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/registrations/registrations',
                name: 'RegistrationRegistrationManager',
                component: RegistrationRegistrationManager
            },
            {
                path: '/registrations/registrations/:id',
                name: 'RegistrationRegistrationDetail',
                component: RegistrationRegistrationDetail
            },

            {
                path: '/classes/classes',
                name: 'ClassClassManager',
                component: ClassClassManager
            },
            {
                path: '/classes/classes/:id',
                name: 'ClassClassDetail',
                component: ClassClassDetail
            },

            {
                path: '/evaluations/evaluations',
                name: 'EvaluationEvaluationManager',
                component: EvaluationEvaluationManager
            },
            {
                path: '/evaluations/evaluations/:id',
                name: 'EvaluationEvaluationDetail',
                component: EvaluationEvaluationDetail
            },

            {
                path: '/histories/histories',
                name: 'HistoryHistoryManager',
                component: HistoryHistoryManager
            },
            {
                path: '/histories/histories/:id',
                name: 'HistoryHistoryDetail',
                component: HistoryHistoryDetail
            },

            {
                path: '/recommends/recommends',
                name: 'RecommendRecommendManager',
                component: RecommendRecommendManager
            },
            {
                path: '/recommends/recommends/:id',
                name: 'RecommendRecommendDetail',
                component: RecommendRecommendDetail
            },



    ]
})
