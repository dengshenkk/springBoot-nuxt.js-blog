import Axios from 'axios'
import {Message} from 'element-ui'

const http = Axios.create({
  baseURL: 'http://localhost:9999'
})
http.interceptors.request.use(req => {
  req.headers['Content-Type'] = 'application/json; charset=UTF-8'
  return req
})
http.interceptors.response.use(res => {
  if (res.data.code === '200') {
    console.log(res.data)
    return res
  } else {
    Message.error(res.data.msg)
    return Promise.reject(res.data.msg)
  }
})

export default http
