<template>
  <div class="blog-wrap">
    blog layout
    <nuxt/>
  </div>
</template>

<script>
/**
 * create by    dengShen
 * createTime   2019/10/17 18:31:59
 */
export default {
  name: 'blog',
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
      console.log(`blog is running...`)
    }
  }
}
</script>

<style lang="scss" scoped>
  .blog-wrap {

  }
</style>
