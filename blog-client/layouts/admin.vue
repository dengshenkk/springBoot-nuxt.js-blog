<template>
  <div>
    <el-container>
      <el-header style="background-color: pink;">Header</el-header>
      <!--<d-loading v-model="loading"></d-loading>-->
      <el-container>
        <el-aside width="200px">
          <el-row class="tac">
            <el-col :span="24">
              <d-nav></d-nav>
            </el-col>
          </el-row>
        </el-aside>
        <el-main>
          <nuxt/>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>
<script>
import DNav from '../components/admin/d-nav'
import DLoading from '../components/admin/d-loading'

export default {
  components: {DLoading, DNav},
  data() {
    return {
    }
  },
  mounted() {
    console.log(this.$store.state.loading)
  }
}
</script>

<style lang="scss" scoped>
  .el-main {
  }
</style>
