<template>
  <div class="article-wrap">
    blog test
  </div>
</template>

<script>
/**
 * create by    dengShen
 * createTime   2019/10/17 18:25:19
 */
export default {
  name: 'article',
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
      console.log(`article is running...`)
    }
  }
}
</script>

<style lang="scss" scoped>
  .article-wrap {

  }
</style>
