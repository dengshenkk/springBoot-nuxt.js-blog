<template>
  <div class="index-wrap">
    blog index
  </div>
</template>

<script>
/**
 * create by    dengShen
 * createTime   2019/10/17 18:26:05
 */
export default {
  layout: 'blog',
  name: 'index',
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
      console.log(`index is running...`)
    }
  }
}
</script>

<style lang="scss" scoped>
  .index-wrap {

  }
</style>
