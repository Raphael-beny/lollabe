import { http } from './config'

export default {

    listar:() => {
        return http.get('tipo')
    },

    buscaUnico:(tipo) => {
        return http.get('tipo/{id}', tipo.id)
    },

    salvar:(tipo) => {
        return http.post('tipo', tipo)
    },

    atualizar:(tipo) => {
        return http.put('tipo', tipo)
    },

    apagar:(tipo) => {
        return http.delete('tipo', { data: tipo })
    },

}