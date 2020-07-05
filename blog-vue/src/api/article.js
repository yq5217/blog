import request from '@/utils/request'

export function fetchList(data) {
  return request({
    url: '/article/findInfoAll',
    method: 'post',
    data
  })
}

export function fetchArticle(id) {
  return request({
    url: '/article/findById',
    method: 'post',
    params: { id }
  })
}

export function saveArticle(data) {
  return request({
    url: '/article/saveArticle',
    method: 'post',
    data
  })
}
