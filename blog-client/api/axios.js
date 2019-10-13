import Axios from 'axios'

const http = Axios.create({
  baseURL: 'http://localhost:9999'
})

http.interceptors.request.use(req => {
  return req
})
http.interceptors.response.use(res => {
  return res
})

export default http
