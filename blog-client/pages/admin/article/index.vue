<template>
  <div class="index-wrap">
    <d-handle-bar @add="add" @query="query"></d-handle-bar>
    <el-table
        :data="tableData"
        style="width: 100%">
      <el-table-column align="center"
                       prop="title"
                       label="文章标题"
                       width="180">
      </el-table-column>
      <el-table-column align="center"
                       prop="subtitle"
                       label="副标题"
                       width="180">
      </el-table-column>
      <el-table-column align="center"
                       prop="categoryType"
                       label="分类类型"
                       width="180">
      </el-table-column>
      <el-table-column align="center"
                       prop="isTop"
                       label="是否置顶"
                       width="180">
        <template slot-scope="scope">
          <div>{{scope.row.isTop ? '是': '否'}}</div>
        </template>
      </el-table-column>
      <el-table-column align="center"
                       prop="createTime"
                       label="创建时间">
        <template slot-scope="scoped">
          <div> {{scoped.row.createTime | filterData('full')}}</div>
        </template>
      </el-table-column>
      <el-table-column align="center"
                       prop=""
                       label="操作">
        <template slot-scope="scope">
          <el-button type="primary" @click="detailArticle(scope.row)">查看</el-button>
          <el-button type="danger" @click="removeArticle(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>/**
 * create by    dengShen
 * createTime   2019/10/14 21:09:42
 */
import {deleteArticle, getArticleAll} from '../../../api/article'
import DHandleBar from '../../../components/d-handleBar'

export default {
  layout: 'admin',
  name: 'index',
  components: {DHandleBar},
  props: {},
  computed: {},
  data() {
    return {
      tableData1: []
    }
  },
  async asyncData() {
    let tableData = {}
    await getArticleAll().then(res => {
      tableData = res.data.data
    })

    return {tableData}
  },
  created() {
  },
  mounted() {
  },
  methods: {
    init() {
      console.log(`index is running...`)
      getArticleAll().then(res => {
        this.tableData = res.data.data
      })
    },
    add() {
      console.log('add')
      this.$router.push({name: 'admin-article-articleId', params: {articleId: 0}})
    },
    query() {
      console.log('query')
    },
    removeArticle(row) {
      deleteArticle(row.id).then(res => {
        this.$message.success(res.data.msg)
        this.init()
      })
    },
    detailArticle(row) {
      this.$router.push({name: 'admin-article-articleId', params: {articleId: row.id}})
    }
  }
}
</script>

<style lang="scss" scoped>
  .index-wrap {

  }
</style>
