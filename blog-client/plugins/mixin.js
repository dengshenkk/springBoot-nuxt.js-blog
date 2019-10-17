import {formatDate} from '../utils/dateUtil'

let baseMixin = {
  filters: {
    filterData(value, type) {
      return formatDate(value, type)
    },
    capitalize: function (value) {
      if (!value) return ''
      value = value.toString()
      return value.charAt(0).toUpperCase() + value.slice(1)
    }
  },
  methods: {
    /**
     * 回退上n步
     * @param go {number} 回退步数
     */
    back(go = -1) {
      this.$router.go(go)
    }
  }
}


export default baseMixin
