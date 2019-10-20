<template>
  <div class="blog-header-wrap">

  </div>
</template>

<script>
/**
 * create by    dengShen
 * createTime   2019/10/18 11:02:29
 */
export default {
  name: 'blog-header',
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
      console.log(`blog-header is running...`)
    }
  }
}
</script>

<style lang="scss" scoped>
  .blog-header-wrap {

  }
</style>
