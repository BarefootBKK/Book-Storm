export const setStore = (key, value) => {
  if (!key) return
  if (typeof value !== 'string') {
    value = JSON.stringify(value)
  }

  window.localStorage.setItem(key, value)
}

export const getStore = (key) => {
  if (!key) return
  // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
  // 别忘了转成 json，保存的是 string
  // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
  let data = window.localStorage.getItem(key)
  try {
    data = JSON.parse(data)
  } catch (e) {

  }
  return data
}

export const removeStore = (key) => {
  if (!key) return
  window.localStorage.removeItem(key)
}

export const clearStore = () => {
  window.localStorage.clear()
}
