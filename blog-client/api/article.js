import axios from './http'

export function getArticleAll() {
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


export function getArticleById(id) {
  return axios({
    url: `/article/queryArticle/${id}`,
    method: 'get'
  })
}

/**
 * 更新
 * @param data
 */
export function updateArticle(data) {
  return axios({
    url: '/article/updateArticle',
    method: 'post',
    data
  })
}
