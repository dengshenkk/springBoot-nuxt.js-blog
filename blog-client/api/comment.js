import axios from './axios'

/**
 * 获取评论列表
 */
export function getComment() {
  return axios({
    url: '/comment/queryCommentAll',
    method: 'get'
  })
}


export function deleteCommentById(commentId) {
  return axios({
    url: `/comment/deleteComment/${commentId}`,
    method: 'delete'
  })
}


export function updateComment(data) {
  return axios({
    url: `/comment/updateComment/${data.id}`,
    method: 'post',
    data
  })
}
