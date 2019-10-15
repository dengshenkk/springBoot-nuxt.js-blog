<template>
  <div class="createArticle-wrap">
    <d-btn-bar type="flex">
      <el-col style="display: flex;">
        <el-button @click="back">返回</el-button>
      </el-col>
      <el-col style="display: flex;justify-content: flex-end;">
        <el-button @click="submit">提交</el-button>
      </el-col>
    </d-btn-bar>

    <div class="content-box">
      <el-row>
        <el-col>
          <el-input v-model="article.title"></el-input>
          <el-input v-model="article.subtitle"></el-input>
        </el-col>
        <el-col>
          <el-select v-model="article.categoryType">
            <el-option
                v-for="(categoryItem, categoryIndex) of categoryList"
                :key="categoryIndex"
                :lable="categoryItem.categoryName"
                :value="categoryItem.categoryType">
            </el-option>
          </el-select>

          <el-select v-model="article.isTop">
            <el-option
                v-for="item in isTopList"
                :key="item.value"
                :label="item.label"
                :value="item.value">
            </el-option>
          </el-select>
        </el-col>
        <el-col>
          <mavon-editor v-model="article.content"/>
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
import DHandleBar from '../../../components/d-handleBar'
import DBtnBar from '../../../components/d-btnBar'
import {getCategoryList} from '../../../api/category'
import {createArticle} from '../../../api/article'

/**
 * create by    dengShen
 * createTime   2019/10/15 15:24:08
 */
if (process.client) {
  require('mavon-editor')
}
export default {
  components: {DBtnBar, DHandleBar},
  layout: 'admin',
  name: 'createArticle',
  props: {},
  computed: {},
  data() {
    return {
      routeQuery: this.$route.query,

      categoryList: [],
      isTopList: [{
        value: 1,
        label: '是'
      },
        {
          value: 0,
          label: '否'
        }],
      article: {
        title: '',
        categoryType: '',
        content: '',
        isTop: ''
      }
    }
  },
  async asyncData() {
    let {data} = await getCategoryList()
    console.log(data)
    return {categoryList: data.data}
  },
  created() {
  },
  mounted() {
    this.init()
  },
  methods: {
    init() {
      console.log(`createArticle is running...`)
    },
    back() {
      this.$router.go(-1)
    },
    submit() {
      console.log(this.article)
      createArticle(this.article).then(res => {
        this.$message.success(res.data.msg)
        this.back()
      })
    }
  }
}
</script>

<style lang="scss" scoped>
  .createArticle-wrap {

  }
</style>
