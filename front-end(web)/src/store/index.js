import Vue from 'vue'
import Vuex from 'vuex'

import user from './modules/user'
import portal from './modules/portal'
import appState from './modules/appState'
import book from './modules/book'
import getters from './getters'

Vue.use(Vuex)

const store = new Vuex.Store({
  modules: {
    user,
    portal,
    appState,
    book
  },
  getters
})

export default store
