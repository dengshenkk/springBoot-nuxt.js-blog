<template>
  <div class="d-nav-wrap">
    <el-menu
        default-active="2"
        class="el-menu-vertical-demo"
        router
        @open="handleOpen"
        @close="handleClose">
      <el-menu-item v-for="(item, index) of routerData" :key="index" :index="item.path">
        <i :class="[item.iconClass]"></i>
        <span slot="title">{{item.name}}</span>
      </el-menu-item>
    </el-menu>
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
      routerData: [
        {
          name: '分类',
          path: '/admin/category',
          iconClass: 'el-icon-menu'
        },
        {
          name: '文章',
          path: '/admin/article',
          iconClass: 'el-icon-document'
        },
        {
          name: '评论',
          path: '/admin/comment',
          iconClass: 'el-icon-reading'
        }
      ]
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
    },
    handleOpen() {

    },
    handleClose() {}
  }
}
</script>

<style lang="scss" scoped>
  .d-nav-wrap {

  }
</style>
