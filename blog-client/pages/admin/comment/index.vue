<template>
  <div class="index-wrap">
    <d-handle-bar></d-handle-bar>
    <el-table
        :data="tableData"
        style="width: 100%">
      <el-table-column align="center"
                       fixed="left"
                       prop="articleId"
                       label="评论文章"
                       width="180">
      </el-table-column>
      <el-table-column align="center"
                       prop="content"
                       label="评论内容"
                       width="180">
      </el-table-column>
      <el-table-column align="center"
                       prop="isAwesome"
                       label="是否神评"
                       width="180">
      </el-table-column>
      <el-table-column align="center"
                       prop="isCheck"
                       label="审核状态"
                       width="180">
      </el-table-column>
      <el-table-column align="center"
                       prop="userName"
                       label="评论人"
                       width="180">
      </el-table-column>
      <el-table-column align="center"
                       prop="userEmail"
                       label="评论人邮箱"
                       width="180">
      </el-table-column>
      <el-table-column align="center"
                       prop="createTime"
                       label="创建时间">
      </el-table-column>
      <el-table-column align="center"
                       prop=""
                       fixed="right"
                       width="200px"
                       label="操作">
        <template slot-scope="scope">
          <el-button type="primary" @click="detail(scope.row.id)">查看</el-button>
          <el-button type="danger" @click="remove(scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>/**
 * create by    dengShen
 * createTime   2019/10/14 21:09:42
 */
import {formatDate} from '../../../utils/dateUtil'
import {deleteCommentById, getComment} from '../../../api/comment'
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
    await getComment().then(res => {
      tableData = res.data.data
    })
    tableData.forEach(item => {
      item.createTime = formatDate(item.createTime)
    })
    return {tableData}
  },
  created() {
  },
  mounted() {
    this.init()
  },
  methods: {
    init() {
      console.log(`index is running...`)
      getComment().then(res => {
        this.tableData = res.data.data
        this.tableData.forEach(item => {
          item.createTime = formatDate(item.createTime, 'full')
        })
      })
    },
    detail(commentId) {

    },
    remove(commentId) {
      deleteCommentById(commentId).then(res => {
        console.log(res)
        this.$message.success(res.data.msg)
        this.init()
      })
    }
  }
}
</script>

<style lang="scss" scoped>
  .index-wrap {

  }
</style>
