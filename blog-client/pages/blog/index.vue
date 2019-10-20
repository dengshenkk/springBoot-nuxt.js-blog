<template>
  <div class="index-wrap">
    <d-loading v-model="loading"></d-loading>
    <section class="blog-banner"></section>
    <section class="blog-article">
      <div class="blog-article-left">1211111</div>
      <div class="blog-article-content">
        <article :class="['blog-article-item']" @mouseover="mouseOver" @mouseout="mouseOut" v-for="(article, index) of articles" :key="index">
          <div class="blog-head">{{article.title}} <sub>{{article.subtitle}}/{{article.createTime }}</sub></div>
          <div class="blog-content"></div>
        </article>
      </div>

      <div class="blog-article-right">444333333333</div>
    </section>
  </div>
</template>

<script>
import DLoading from '../../components/admin/d-loading'
import {getArticleAll} from '../../api/article'

/**
 * create by    dengShen
 * createTime   2019/10/17 18:26:05
 */
export default {
  components: {DLoading},
  layout: 'blog',
  name: 'index',
  props: {},
  computed: {},
  data() {
    return {
      routeQuery: this.$route.query,
      loading: true
    }
  },
  async asyncData({app, context}) {
    let articles = await getArticleAll()
    return {articles: articles.data.data}
  },
  created() {
  },
  mounted() {
    this.init()
  },
  methods: {
    init() {
      console.log(`123index is running...`)
      console.log(this.articles)
      this.$nextTick(() => {
        setTimeout(() => {
          this.loading = false
        }, 1000)
      })
    },
    mouseOver(e) {
      [...e.srcElement.parentElement.children].forEach(item => {
        item.style.filter = 'blur(2px)'
      })
      e.target.style.filter = 'none'
      e.target.style.transform = 'scale(1.1, 1.1)'
      // e.target.classList.add('hover')
    },
    mouseOut(e) {
      [...e.srcElement.parentElement.children].forEach(item => {
        item.style.filter = 'none'
        e.target.style.transform = 'scale(0,0)'
        // e.target.removeClass('hover')
      })

    }
  }
}
</script>

<style lang="scss" scoped>
  @mixin bdrs($border) {
    -webkit-border-radius: $border;
    -moz-border-radius: $border;
    border-radius: $border;
  }

  .index-wrap {
    width: 100%;
    height: 100vh;
    overflow: auto;

    .blog-banner {
      height: 100px;
      background-color: transparent;
    }

    .blog-article {
      width: 80%;
      margin: 0 auto;
      display: flex;
      justify-content: space-between;

      .blog-article-left {
        width: 200px;
        margin-right: 24px;
        background-color: pink;
      }

      .blog-article-right {
        width: 200px;
        margin-left: 24px;
        background-color: blue;
      }

      .blog-article-content {
        flex: 1;
        height: 100vh;
        overflow: auto;
        background-color: deepskyblue;
        padding: 24px;

        .blog-article-item {
          background-color: deeppink;
          @include bdrs(4px);
          color: #fff;
          min-height: 200px;
          margin-bottom: 24px;
          transition: all 0.5s;
          padding: 24px;

          .hover {
            transform: scale(1.1, 1.1);
          }
        }
      }
    }
  }
</style>
