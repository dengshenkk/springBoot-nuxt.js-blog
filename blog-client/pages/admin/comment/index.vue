<template>
  <div class="index-wrap">
    <d-handle-bar @add="add"></d-handle-bar>
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
                       label="评论内容">
      </el-table-column>
      <el-table-column align="center"
                       prop="isAwesome"
                       label="是否神评"
                       width="80">
        <template slot-scope="scoped">
          <div>
            <span style="color: green;" v-if="scoped.row.isAwesome">是</span>
            <span style="color: red;" v-else>否</span>
          </div>
        </template>
      </el-table-column>
      <el-table-column align="center"
                       prop="isCheck"
                       label="审核状态"
                       width="80">
        <template slot-scope="scoped">
          <div>
            <span style="color: green;" v-if="scoped.row.isCheck">是</span>
            <span style="color: red;" v-else>否</span>
          </div>
        </template>
      </el-table-column>
      <el-table-column align="center"
                       prop="userName"
                       label="评论人"
                       width="100">
      </el-table-column>
      <el-table-column align="center"
                       prop="userEmail"
                       label="评论人邮箱"
                       width="180">
      </el-table-column>
      <el-table-column align="center"
                       prop="createTime"
                       label="创建时间"
                       width="100">
        <template slot-scope="scoped">
          <div> {{scoped.row.createTime}}</div>
        </template>
      </el-table-column>
      <el-table-column align="center"
                       prop=""
                       fixed="right"
                       width="200px"
                       label="操作">
        <template slot-scope="scope">
          <el-button type="primary" @click="detail(scope.row)">查看</el-button>
          <el-button type="danger" @click="remove(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-dialog title="评论" :visible.sync="dialogFormVisible">
      <el-form :model="form" label-width="100px">
        <el-form-item label="文章">
          <el-input v-model="form.articleId" autocomplete="off" disabled></el-input>
        </el-form-item>
        <el-form-item label="评论内容">
          <el-input v-model="form.content" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="评论人">
          <el-input v-model="form.userName" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="评论人邮箱">
          <el-input v-model="form.userEmail" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="是否审核">
          <el-select v-model="form.isCheck">
            <el-option label="是" :value="1"></el-option>
            <el-option label="否" :value="0"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="是否删除">
          <el-select v-model="form.isDelete">
            <el-option label="是" :value="1"></el-option>
            <el-option label="否" :value="0"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="是否神评">
          <el-select v-model="form.isAwesome">
            <el-option label="是" :value="1"></el-option>
            <el-option label="否" :value="0"></el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="submit">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>/**
 * create by    dengShen
 * createTime   2019/10/14 21:09:42
 */
import {formatDate} from '../../../utils/dateUtil'
import {deleteCommentById, getComment, updateComment} from '../../../api/comment'
import DHandleBar from '../../../components/d-handleBar'

export default {
  layout: 'admin',
  name: 'index',
  components: {DHandleBar},
  props: {},
  computed: {},
  data() {
    return {
      dialogFormVisible: false,
      form: {}
    }
  },
  async asyncData() {
    let tableData = {}
    await getComment().then(res => {
      tableData = res.data.data
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
      })
    },
    detail(row) {
      this.form = row
      this.dialogFormVisible = true
    },
    remove(row) {
      deleteCommentById(row.id).then(res => {
        console.log(res)
        this.$message.success(res.data.msg)
        this.init()
      })
    },
    add() {
      // this.dialogFormVisible = true
    },
    submit() {
      updateComment(this.form).then(res => {
        this.$message.success(res.data.msg)
        this.dialogFormVisible = false
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
