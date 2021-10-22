<template>
    <main>

        <section class="container">

            <h1>Produtos</h1>

            <section class="produtos">

                <div class="produto" v-for="produto of produtos" :key="produto.id">

                    <div class="produto-nome">{{produto.nome}}</div>
                 
                    <div class="produto-preco">Valor: R$ {{produto.preco}}</div>
                    
                    <div class="produto-descricao">{{produto.descricao}}</div>
                    <img style='display:block; width:300px; height:300px;' id='base64image'
                    :src="gerarLink(produto)"/>

                </div>

            </section>

        </section>

    </main>
</template>

<script>
import Produto from '@/services/produtos.js'

export default {
    name: 'Produtos',
    data(){
       return {
           produtos: []
       }
    },
    mounted(){
        this.listar()
    },

    methods:{

        gerarLink(produto){
            return `data:image/jpeg;base64, ${produto.foto}`;
        },

        listar(){
            Produto.listar().then(resposta => {
            this.produtos = resposta.data
            })
        }
    },
    
}

</script>

<style scoped>

main{
    align-items: center;
    height: auto;
    
}

.produtos{
    display: flex;
    flex-direction: column;
    align-items: center;
    padding: 15px;
}

.produto{
    width: 90%;
    margin-block: 15px;
}

.produto img{
    width: 100%;
}

.produto-nome{
    color: rgb(93, 136, 93);
    font-size: 30px;
    font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
}

.produto-preco{
    font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
}

.produto-nome{
    font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
}

.produto-codigo{
    font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
}

.produto-descricao{
    font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
    margin-block-end: 10px;
}

@media (min-width:700px){
    
    .produto{
        max-width: 350px;
        box-sizing: border-box;
        background-repeat: no-repeat;
        background-position: top 1.25rem left 2.5rem;
    }

    .produtos{
        display: flex;
        flex-direction: row;
        flex-wrap: wrap;
        justify-content: space-evenly;
    }

    

}

</style>