import Vue from 'vue';
import VueRouter from 'vue-router';

Vue.use(VueRouter);

import Home from '@/pages/Home';
import Produtos from '@/pages/Produtos';
import Cadastros from '@/pages/Cadastros';
import Categorias from '@/pages/Categorias';

const routes = [
    {
        path: '/',
        component:Home
    },
    {
        path: '/produtos',
        component:Produtos
    },
    {
        path: '/cadastros',
        component:Cadastros
    },
    {
        path: '/tipos',
        component:Categorias
    }
];

const router = new VueRouter ({
    routes,
    mode: 'history'
});

export default router;