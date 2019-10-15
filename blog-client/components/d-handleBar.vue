<template>
  <div class="d-handleBar-wrap">
    <el-row type="flex" justify="space-between" v-if="isBack">
      <el-col :span="24" style="display: flex;justify-content: flex-end;">
        <el-button type="primary" @click="$router.go(-1)">返回</el-button>
      </el-col>
    </el-row>
    <el-row type="flex" justify="space-between" v-else>
      <el-col>
        <el-button type="primary" @click="add">新增</el-button>
      </el-col>

      <el-col :span="8" style="display: flex;justify-content: flex-end">
        <el-button type="info" @click="query">查询</el-button>
      </el-col>
    </el-row>
  </div>
</template>

<script>
/**
 * create by    dengShen
 * createTime   2019/10/14 23:22:13
 */
export default {
  name: 'd-handleBar',
  props: {
    isBack: {
      type: Boolean,
      default: () => false
    }
  },
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
      console.log(`d-handleBar is running...`)
    },
    add() {
      this.$emit('add')
    },
    query() {
      this.$emit('query')
    }
  }
}
</script>

<style lang="scss" scoped>
  .d-handleBar-wrap {

  }
</style>
