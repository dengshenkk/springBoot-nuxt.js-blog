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
                :label="categoryItem.categoryName"
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
import DHandleBar from '../../../components/admin/d-handleBar'
import DBtnBar from '../../../components/admin/d-btnBar'
import {getCategoryList} from '../../../api/category'
import {createArticle, getArticleById, updateArticle} from '../../../api/article'

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
      test: '',
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
  async asyncData({app}) {
    let categoryList = await getCategoryList()
    let article = {}
    let status = 'create'
    if (app.context.params.articleId) {
      status = 'update'
      article = await getArticleById(app.context.params.articleId)
    }
    console.log(categoryList.data.data)
    console.log(article.data.data)
    return {categoryList: categoryList.data.data, article: article.data.data, status}

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
      this.categoryList.forEach(item => {
        if (item.categoryName === this.article.categoryName) {
          this.article.categoryType = item.categoryType
        }
      })
      if (this.status === 'update') {
        updateArticle(this.article).then(res => {
          this.$message.success(res.data.msg)
          this.back()
        })
      } else {
        createArticle(this.article).then(res => {
          this.$message.success(res.data.msg)
          this.back()
        })
      }


    }
  }
}
</script>

<style lang="scss" scoped>
  .createArticle-wrap {

  }
</style>
