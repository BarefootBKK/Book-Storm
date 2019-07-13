const appState = {
  state: {
    isLoading: false,
    signUpStep: 0,
  },
  mutations: {
    SET_IS_LOADING: (state, loading) => {
      state.isLoading = loading
    },
    SET_SIGN_UP_STEP: (state, step) => {
      state.signUpStep = step
    }
  },
  actions: {
    setIsLoading({commit}, loading) {
      commit('SET_IS_LOADING', loading)
    },
    setNextSignUpStep({commit}, step) {
      commit('SET_SIGN_UP_STEP', step)
    }
  }
}

export default appState
