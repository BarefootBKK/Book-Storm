export function usernameRule (rule, value, callback) {
  if (!(/^[A-Za-z0-9]+$/.test(value.trim()))) {
    callback(new Error('请输入正确的用户名（英文字母或数字）'))
  } else if (value.length > 21 || value.length < 6) {
    callback(new Error('用户名长度在6到20之间'))
  }
  callback()
}

export function passwordRule (rule, value, callback) {
  if (value.length < 6) {
    callback(new Error('密码不能小于6位'))
  }
  callback()
}

export function emailRule (rule, value, callback) {
  if (!(/^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/.test(value.trim())) || value.length < 5) {
    callback(new Error('邮箱格式错误！'))
  }
  callback()
}
