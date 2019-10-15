import axios from './axios'

export function getArticle() {
  return axios({
    url: '/article/queryArticleAll',
    method: 'get'
  })
}

export function createArticle(data) {
  return axios({
    url: '/article/createArticle',
    method: 'post',
    data
  })
}

export function deleteArticle(articleId) {
  return axios({
    url: `/article/deleteArticleOne/${articleId}`,
    method: 'delete'
  })
}
