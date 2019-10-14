import axios from './axios'

export function getComment() {
  return axios({
    url: '/comment/queryCommentAll',
    method: 'get'
  })
}
