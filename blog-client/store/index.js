// export const state = () => ({
//   loading: true
// })
//
// export const mutations = {
//   toggleLoading(status) {
//     state.loading = status
//   }
// }

import Vuex from 'vuex'


export default () => {
  return new Vuex.Store({
    state: {
      loading: false
    },
    mutations: {
      toggleLoading(status) {
        state.loading = status
      }
    }
  })
}

