<template>
  <div class="index-wrap">
    <d-handle-bar @add="add"></d-handle-bar>
    <el-table
        :data="tableData"
        style="width: 100%">
      <el-table-column align="center"
                       prop="categoryName"
                       label="分类名称"
                       width="180">
      </el-table-column>
      <el-table-column align="center"
                       prop="categoryType"
                       label="分类类型"
                       width="180">
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
          <el-button type="primary" @click="detail(scope.row)">查看</el-button>
          <el-button type="danger" @click="remove(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>


    <el-dialog title="分类" :visible.sync="dialogFormVisible">
      <el-form :model="form">
        <el-form-item label="分类名称">
          <el-input v-model="form.categoryName" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="分类类型(数字)">
          <el-input v-model="form.categoryType" autocomplete="off"></el-input>
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
import {createCategory, getCategoryList, removeCategory, updateCategory} from '../../../api/category'
import DHandleBar from '../../../components/admin/d-handleBar'

export default {
  layout: 'admin',
  name: 'index',
  components: {DHandleBar},
  props: {},
  computed: {},
  data() {
    return {
      dialogFormVisible: false,
      form: {
        categoryName: '',
        categoryType: ''
      },
      status: 'create'
    }
  },
  async asyncData() {
    let tableData = {}
    await getCategoryList().then(res => {
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
    async init() {
      console.log(`index is running...`)
      await getCategoryList().then(res => {
        this.tableData = res.data.data
      })
    },
    async submit() {
      let {categoryName, categoryType} = this.form
      if (this.status === 'update' && this.form.id) {
        await updateCategory({id: this.form.id, categoryName, categoryType}).then(res => {
          this.$message.success(res.data.msg)
        })
      } else {
        await createCategory({categoryName, categoryType}).then(res => {
          this.$message.success(res.data.msg)
        })
      }
      this.dialogFormVisible = false
      this.form = {}
      this.init()
    },
    detail(row) {
      this.form = row
      this.dialogFormVisible = true
      this.status = 'update'
    },
    add() {
      this.dialogFormVisible = true
      this.status = 'create'
    },
    remove(row) {
      console.log(row)
      removeCategory(row.id).then(res => {
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
