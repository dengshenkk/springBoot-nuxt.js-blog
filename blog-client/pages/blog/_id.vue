<template>
  <div class="article-wrap">
    <div class="article-title">{{article.title}}<sub>{{article.subtitle}}</sub></div>
    <!--<section>{{article.content}}</section>-->
  </div>
</template>

<script>/**
 * create by    dengShen
 * createTime   2019/10/17 18:25:19
 */
import {getArticleById} from '../../api/article'
import DNav from '../../components/admin/d-nav'
import DHandleBar from '../../components/admin/d-handleBar'

export default {
  name: 'blogArticle',
  components: {DHandleBar, DNav},
  props: {},
  computed: {},
  data() {
    return {}
  },
  async asyncData({app, context}) {
    console.log(app.router.currentRoute.params, context)
    let {id} = app.router.currentRoute.params
    let articles = await getArticleById(id)
    console.log(articles.data)
    return {article: articles.data}
  },
  created() {
  },
  mounted() {
    this.init()
  },
  methods: {
    init() {
      console.log(`article is running...`)
    }
  }
}
</script>

<style lang="scss" scoped>
  .article-wrap {

  }
</style>
