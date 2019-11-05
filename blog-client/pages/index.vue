<template>
  <div class="index-wrap">
    <d-loading v-model="loading"></d-loading>
    <section class="blog-banner"></section>
    <section class="blog-article">
      <div class="blog-article-left"></div>
      <div class="blog-article-content">
        <article class="blog-article-item"
                 @mouseover="mouseOver(article,index)"
                 @mouseout="mouseOut(article,index)"
                 v-for="(article, index) of articles"
                 :key="index">
          <div class="blog-head">
            {{article.title}}
            <sub>{{article.subtitle}} / {{article.createTime | filterDate('full')}}</sub>
          </div>
          <div class="blog-content" v-html="article.content"></div>
          <nuxt-link :to="{name: 'blog-id', params: {id: article.id}}">
            <div class="blog-mark" >
              <!--@click="articleDetail(article)"-->
              <div class="mark"></div>
              <span class="text">详细</span>
            </div>
          </nuxt-link>
        </article>
      </div>

      <div class="blog-article-right"></div>
    </section>
  </div>
</template>

<script>
import DLoading from '../components/admin/d-loading'
import {getArticleAll} from '../api/article'

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
      loading: true,
      isHover: false
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
      this.$nextTick(() => {
        setTimeout(() => {
          this.loading = false
        }, 1000)
      })
    },
    articleDetail(article) {
      this.$router.push({name: 'blog-id', params: {id: article.id}})
    },
    mouseOver(article, index) {
      article.isHover = true
    },
    mouseOut(article, index) {
      article.isHover = true
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
    display: flex;
    flex-direction: column;

    .blog-banner {
      flex: 0 0 100px;
      background-color: transparent;
    }

    .blog-article {
      flex: 1;
      display: flex;
      justify-content: space-between;
      overflow: scroll;

      .blog-article-left {
        min-width: 200px;
        max-width: 400px;
        margin-right: 24px;
      }

      .blog-article-right {
        width: 200px;
        margin-left: 24px;
      }

      .blog-article-content {
        flex: 1;
        overflow: auto;
        padding: 64px;
        cursor: pointer;

        .blog-article-item {
          @include bdrs(4px);
          color: #fff;
          min-height: 200px;
          max-height: 200px;
          overflow: hidden;
          margin-bottom: 44px;
          transition: all 0.5s;
          padding: 24px;
          border: 1px solid #fff;
          position: relative;
          .blog-head {
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

          &:hover {
            box-shadow: (0 0px 10px #fff);
            transition: all 1s;
            transform: scale(1.1, 1.1);
            filter: none;
            .blog-mark{
              display: inline-block;
            }
          }

          .blog-mark {
            display: none;
            position: absolute;
            left: 0;
            bottom: 0;
            right: 0;
            height: 48px;
            background: linear-gradient(-45deg, #ee7752, #e73c7e, #23a6d5, #23d5ab);
            background-size: 400% 400%;

            &:hover {
              animation: gradientBG 5s ease infinite;
            }

            @keyframes gradientBG {
              0% {
                background-position: 0% 50%;
              }
              50% {
                background-position: 100% 50%;
              }
              100% {
                background-position: 0% 50%;
              }
            }

            .text {
              position: absolute;
              left: 50%;
              top: 50%;
              -webkit-transform: translate(-50%, -50%);
              -moz-transform: translate(-50%, -50%);
              -ms-transform: translate(-50%, -50%);
              -o-transform: translate(-50%, -50%);
              transform: translate(-50%, -50%);
              z-index: 22;
              filter: none;
            }
          }
        }
      }
    }
  }
</style>
