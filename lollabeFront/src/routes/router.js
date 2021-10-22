import Vue from 'vue';
import VueRouter from 'vue-router';

Vue.use(VueRouter);

import Produtos from '@/pages/Produtos';


const routes = [
    {
        path: '/',
        name: 'produtos',
        component:Produtos,
        meta: {
          publica: true
        }
    },
];

const router = new VueRouter ({
    routes,
    mode: 'history'
})

export default router;