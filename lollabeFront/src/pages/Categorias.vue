<template>
  <main>
    <div class="container">
        <h1>CADASTRAR UMA NOVA CATEGORIA</h1>
      <form>
        <div class="form-group">
          <label for="nome">Descrição</label>
          <input
            type="text"
            class="form-control"
            id="descricao"
            placeholder="Descrição da Categoria"
            v-model="tipo.descricao"
          />
        </div>
        <input class="botao" type="button" @click="salvar()" value="Enviar" />
        <a
          href="/cadastros"
          class="btn btn-primary btn-sm"
          role="button"
          aria-pressed="true"
          >Voltar para o cadastro de produtos</a
        >
      </form>

      <table class="tabela">
        <thead>
          <tr>
            <th>Descrição</th>
            <th>Ações</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="tipo of tipos" :key="tipo.id">
            <td>{{ tipo.descricao }}</td>
            <td>
              <button
                @click="editar(tipo)"
              >
                <i class="alterar">Alteração</i>
              </button>
              <button
                @click="remover(tipo)"
              >
                <i class="remover">Remover</i>
              </button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </main>
</template>

<script>
import Tipo from "@/services/tipos.js";

export default {
  name: "Categorias",

  data() {
    return {
      tipo: {
        descricao: "",
      },
      errors: [],
      tipos: [],
    };
  },

  mounted() {
    this.listar();
  },

  methods: {
    salvar(){

      if(!this.tipo.id){
          Tipo.salvar(this.tipo).then(() =>{
            this.tipo = {}
            alert('Salvo com sucesso!')
            this.listar()
            this.errors = []
          }).catch(e =>{
            this.errors = e.response.data.errors
            alert("Descrição nao pode ser nula ou indefinida!");
          })
       }else{
          Tipo.atualizar(this.tipo).then(() =>{
            this.tipo = {}
            alert('Atualizado com sucesso!')
            this.listar()
            this.errors = []
          }).catch(e =>{
            this.errors = e.response.data.errors
            alert("Descrição nao pode ser nula ou indefinida!");
          })
       }
    },

    listar() {
      Tipo.listar().then((resposta) => {
        this.tipos = resposta.data;
      });
    },

    editar(tipo) {
      this.tipo = tipo;
    },

    remover(tipo) {
      if (confirm("Deseja excluir o produto?")) {
        Tipo.apagar(tipo)
          .then(() => {
            this.errors = [];
            alert("Produto apagado com sucesso!");
            this.listar();
          })
          .catch((e) => {
            this.errors = e.response.data.errors;
          });
      }
    },
  },
};
</script>


<style scoped>
.container {
  display: flex;
  align-items: center;
  justify-content: space-between;
}

.tabela {
  width: 50%;
  text-align: center;
  border: black;
  height: 100px;
  margin-bottom: 20px;
  border-color: black;
  border-style: solid;
  border-width: 1px;
}

tbody, td, tfoot, th, thead, tr {
    border-color: black;
    border-style: solid;
    border-width: 1px;
    
}

.remover{
  background: red;
  color: white;
  border-style: outset;
  border-color: red;
  height: 50px;
  width: 100px;
  font: bold 15px arial, sans-serif;
  text-shadow:none;
}

.alterar{
  background: rgb(53, 9, 153);
  color: white;
  border-style: outset;
  border-color: rgb(53, 9, 153);
  height: 50px;
  width: 100px;
  font: bold 15px arial, sans-serif;
  text-shadow:none;
}

form {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin: 20px 0px;
  margin-block: 40px;
}

.form-group {
  margin: 20px 60px;
  height: 30px;
  font-size: 22px;
}

.selecao {
  height: 140px;
  font-size: 22px;
  display: flex;
}
  
.form-control {
  width: 300px;
  height: 30px;
  margin: 10px;
}

.botao {
  width: 300px;
  height: 30px;
  margin: 40px;
  font-size: 22px;
  background-color: rgb(20, 49, 20);
  color: white;
}
</style>