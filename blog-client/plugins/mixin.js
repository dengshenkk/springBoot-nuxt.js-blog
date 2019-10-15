let baseMixin = {
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
