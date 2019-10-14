import axios from './axios'

/**
 * 获取分类
 */
export function getCategoryList() {
  return axios({
    url: '/category/queryCategory',
    method: 'get'
  })
}

/**
 * 新增分类
 * @param data
 */
export function createCategory(data) {
  console.log(data)
  return axios({
    method: 'post',
    url: '/category/createCategory',
    data
  })
}

export function removeCategory(data) {
  return axios({
    method: 'delete',
    url: `/category/deleteCategory/${data}`
  })
}




