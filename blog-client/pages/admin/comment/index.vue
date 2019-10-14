<template>
  <div class="index-wrap">
    <d-handle-bar></d-handle-bar>
    <el-table
        :data="tableData"
        style="width: 100%">
      <el-table-column
          prop="articleId"
          label="评论文章"
          width="180">
      </el-table-column>
      <el-table-column
          prop="content"
          label="评论内容"
          width="180">
      </el-table-column>
      <el-table-column
          prop="isAwesome"
          label="是否神评"
          width="180">
      </el-table-column>
      <el-table-column
          prop="isCheck"
          label="审核状态"
          width="180">
      </el-table-column>
      <el-table-column
          prop="userName"
          label="评论人"
          width="180">
      </el-table-column>
      <el-table-column
          prop="userEmail"
          label="评论人邮箱"
          width="180">
      </el-table-column>
      <el-table-column
          prop="createTime"
          label="创建时间">
      </el-table-column>
      <el-table-column
          prop=""
          width="200px"
          label="操作">
        <template slot-scope="scope">
          <el-button type="primary">查看</el-button>
          <el-button type="danger">删除</el-button>
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
import {getComment} from '../../../api/comment'
import DHandleBar from '../../../components/d-handleBar'

export default {
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
      console.log(this.tableData)
    }
  }
}
</script>

<style lang="scss" scoped>
  .index-wrap {

  }
</style>
