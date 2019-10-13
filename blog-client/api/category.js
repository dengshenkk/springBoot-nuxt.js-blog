import axios from './axios'

export function getCategoryList() {
  return axios({
    url: '/category/queryCategory',
    method: 'get'
  })
}
