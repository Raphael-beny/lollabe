<template>
  <main>
    <h1>Cadastre um novo produto</h1>
    <div class="container">
      <form class="formulario">
        <div class="form-group">
          <label for="nome">Nome</label>
          <input
            type="text"
            class="form-control"
            id="nome"
            placeholder="Nome do produto"
            v-model="produto.nome"
          />
        </div>
        <div class="selecao">
          <label for="tipo" ><a href="/tipos">Tipo </a></label>
          <v-select
            v-model="produto.tipo"
            class="form-control"
            id="tipo"
            label="descricao"
            :options="tipos"
          ></v-select>
        </div>
        <div class="form-group">
          <label for="codigo">Código</label>
          <input
            type="number"
            class="form-control"
            id="codigo"
            v-model="produto.codigo"
            placeholder="Código do produto"
          />
        </div>
        <div class="form-group">
          <label for="preco">Preço</label>
          <input
            type="number"
            min="0"
            step="0.01"
            data-number-to-fixed="2"
            data-number-stepfactor="100"
            class="form-control currency"
            id="preco"
            placeholder="Preço do produto"
            v-model="produto.preco"
          />
        </div>
        <div class="form-group">
          <label for="descricao">Descrição</label>
          <input
            type="text"
            class="form-control"
            id="descricao"
            placeholder="Descrição do produto"
            v-model="produto.descricao"
          />
        </div>
        <div class="form-group">
          <label for="imagePicker">Foto:</label>
          <input class="form-control" type="file" id="imagePicker" />
        </div>
        <input class="botao" type="button" @click="salvar()" value="Enviar" />
        <a
          href="/Produtos"
          class="btn btn-primary btn-sm"
          role="button"
          aria-pressed="true"
          >Voltar para a lista</a
        >
      </form>

      <table class="tabela">
        <thead>
          <tr>
            <th>Nome</th>
            <th>Codigo</th>
            <th>Preço</th>
            <th>Descição</th>
            <th>Foto</th>
            <th>Ações</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="produto of produtos" :key="produto.id">
            <td>{{ produto.nome }}</td>
            <td>{{ produto.codigo }}</td>
            <td>R$ {{ produto.preco }}</td>
            <td>{{ produto.descricao }}</td>
            <td><img style='width:50px; height:50px;' id='base64image' :src="gerarLink(produto)"/></td>
            <td>
              <button
                @click="editar(produto)"
              >
                <i class="alterar">Alteração</i>
              </button>
              <button
                @click="remover(produto)"
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
import Produto from "@/services/produtos.js";
import Tipo from "@/services/tipos.js";

export default {
  name: "Cadastros",

  data() {
    return {
      produto: {
        nome: "",
        descricao: "",
        codigo: "",
        preco: "",
        foto: "",
        tipo: "",
      },
      produtos: [],
      errors: [],
      tipos: [],
    };
  },

  mounted() {
    this.listarTipos();
    this.listarProdutos();
  },

  methods: {
    gerarLink(produto){
      return `data:image/jpeg;base64, ${produto.foto}`;
    },

    salvar() {
      var produto = null;
      var foto = null;
      var formData = null;
      if(!this.produto.id){
      produto = {
        nome: document.querySelector("#nome").value,
        codigo: document.querySelector("#codigo").value,
        preco: document.querySelector("#preco").value,
        descricao: document.querySelector("#descricao").value,
      };
      foto = document.querySelector("#imagePicker").files[0];

      formData = new FormData();
      formData.append("produtoJson", JSON.stringify(produto));
      formData.append("foto", foto);

      fetch("http://localhost:8080/cadastro", {
        method: "POST",
        body: formData,
      })
        .then((response) => {
          this.listarProdutos();
          this.listarTipos();
          if (!response.ok)
            throw new Error("não foi possível completar cadastro");

          return response.text();
        })
        .then((data) => alert(data));

      }
      else{
        produto = {
        nome: document.querySelector("#nome").value,
        codigo: document.querySelector("#codigo").value,
        preco: document.querySelector("#preco").value,
        descricao: document.querySelector("#descricao").value,
        id: this.produto.id,
      };
      foto = document.querySelector("#imagePicker").files[0];

      formData = new FormData();
      formData.append("produtoJson", JSON.stringify(produto));
      formData.append("foto", foto);

      fetch("http://localhost:8080/cadastro", {
        method: "POST",
        body: formData,
      })
        .then((response) => {
          if (!response.ok)
            throw new Error("não foi possível completar cadastro");

          return response.text();
        })
        .then((data) => alert(data));
      }
      this.listarProdutos();
      this.listarTipos();
    },

    listarTipos() {
      Tipo.listar().then((resposta) => {
        this.tipos = resposta.data;
      });
    },

    listarProdutos() {
      Produto.listar().then((resposta) => {
        this.produtos = resposta.data;
      });
    },

    editar(produto) {
      this.produto = produto;
    },

    remover(produto) {
      if (confirm("Deseja excluir o produto?")) {
        Produto.apagar(produto)
          .then(() => {
            this.errors = [];
            alert("Produto apagado com sucesso!");
            this.listarProdutos();
            this.listarTipos();
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

main{
    align-items: center;
    height: auto;
}



.tabela {
  width: 100%;
  text-align: center;
  border: black;
  height: 400px;
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

.selecao {
  height: 100px;
  font-size: 22px;
  display: flex;
  align-items: center;
}

.form{
  display: flex;
}

.form-control {
  width: 300px;
  height: 30px;
  margin: 20px;
}

.botao {
  width: 300px;
  height: 30px;
  margin: 40px;
  font-size: 22px;
  background-color: rgb(20, 49, 20);
  color: white;
}

@media (min-width:700px){
    
    .form-control{
        max-width: 350px;
        box-sizing: border-box;
        background-repeat: no-repeat;
        background-position: top 1.25rem left 2.5rem;
    }

    .formulario{
        display: flex;
        flex-direction: row;
        flex-wrap: wrap;
        justify-content: space-evenly;
    }

}


</style>