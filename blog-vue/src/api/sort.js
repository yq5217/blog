import request from '@/utils/request'

export function fetchSortList() {
  return request({
    url: '/sort/findall',
    method: 'post'
  })
}

