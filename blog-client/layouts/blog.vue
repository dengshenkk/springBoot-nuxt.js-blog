<template>
  <div class="blog-wrap" :style="{background: 'url('+require('~/assets/star-min.jpg')+')'}">
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
    }
  }
}
</script>

<style lang="scss" scoped>
  .blog-wrap {
    width: 100%;
    max-width: 100%;
    height: 100vh;
    min-height: 100vh;
    overflow: hidden;
  }
</style>
