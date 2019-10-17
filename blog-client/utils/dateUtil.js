export function formatDate(time, type = 'date') {
  if (!time) {
    return ''
  }
  let result = null
  let date = new Date(Number(time))
  let Y = date.getFullYear()
  let M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1)
  let D = date.getDate() < 10 ? '0' + date.getDate() : date.getDate()
  let h = date.getHours() < 10 ? '0' + date.getHours() : date.getHours()
  let m = date.getMinutes() < 10 ? '0' + date.getMinutes() : date.getMinutes()
  let s = date.getSeconds() < 10 ? '0' + date.getSeconds() : date.getSeconds()
  switch (type) {
    case 'date':
      result = `${Y}-${M}-${D}`
      break
    case 'time':
      result = `${h}:${m}:${s}`
      break
    case 'full':
      result = `${Y}-${M}-${D} ${h}:${m}:${s}`
      break
    default:
      return `${Y}-${M}-${D}`
  }
  return result
}
