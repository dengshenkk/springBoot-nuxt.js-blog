<template>
  <div class="d-btnBar-wrap">
    <el-row v-bind="$attrs" v-on="$listeners">
      <slot></slot>
    </el-row>
  </div>
</template>

<script>
/**
 * create by    dengShen
 * createTime   2019/10/15 16:28:48
 */
export default {
  name: 'd-btnBar',
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
      console.log(`d-btnBar is running...`)
    }
  }
}
</script>

<style lang="scss" scoped>
  .d-btnBar-wrap {

  }
</style>
