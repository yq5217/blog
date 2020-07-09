import request from '@/utils/request'

export function savefile(data) {
  return request({
    url: '/file/savefile',
    method: 'post',
    data
  })
}
