import axios from './axios'

export function getArticle() {
  return axios({
    url: '/article/queryArticleAll',
    method: 'get'
  })
}
