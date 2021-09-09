import { http } from './config'

export default {

    listar:() => {
        return http.get('cadastro')
    },

    buscaUnico:(produto) => {
        return http.get('cadastro/{id}', produto.id)
    },

    salvar:(produto) => {
        return http.post('cadastro', produto)
    },

    atualizar:(produto) => {
        return http.put('cadastro', produto)
    },

    apagar:(produto) => {
        return http.delete('cadastro', { data: produto })
    },

}