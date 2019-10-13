<template>
  <div class="d-nav-wrap">
123
  </div>
</template>

<script>
/**
 * create by    dengShen
 * createTime   2019/10/13 12:46:46
 */
export default {
  name: 'd-nav',
  props: {},
  computed: {},
  data() {
    return {
      routeQuery: this.$route.query
    }
  },
  created() {
  },
  mounted() {
    this.init()
  },
  methods: {
    init() {
      console.log(`d-nav is running...`)
    }
  }
}
</script>

<style lang="scss" scoped>
  .d-nav-wrap {

  }
</style>
