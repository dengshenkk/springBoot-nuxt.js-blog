<template>
  <div class="article-wrap">
    <header class="header"></header>
    <div class="main">
      <div class="article-title">
        {{article.title}}
        <sub>{{article.subtitle}} / {{article.createTime | filterDate('full')}}</sub>
      </div>
      <section class="article-content" v-html="article.content"></section>
    </div>
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
  layout: 'blog',
  components: {DHandleBar, DNav},
  props: {},
  computed: {},
  data() {
    return {}
  },
  async asyncData({params}) {
    let {id} = params
    let articles = await getArticleById(id)
    return {article: articles.data.data}
  },
  created() {
  },
  mounted() {
    this.init()
  },
  methods: {
    init() {
    }
  }
}
</script>

<style lang="scss" scoped>
  .article-wrap {
    margin: 0 auto;
    height: 100%;
    overflow: scroll;
    position: relative;

    .header {
      background-color: transparent;
      width: 100%;
      height: 100px;
      position: fixed;
      top: 0;
      z-index: 999;
    }

    .main {
      width: 980px;
      background-color: #000;
      margin: 100px auto;
      word-break: break-all;
      white-space: pre-wrap;
      padding: 24px;

      .article-title {
        display: flex;
        align-items: center;
        height: 44px;
        font-size: 24px;
        font-weight: bold;

        sub {
          margin-left: 12px;
          font-size: 14px;
          font-weight: normal;
          color: #f2f2f2;
        }
      }
    }
  }
</style>
