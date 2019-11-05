<template>
  <div class="article-wrap">
    <header class="header"></header>
    <div class="main">
      <div class="article-title">
        {{article.title}}
        <sub>{{article.subtitle}} / {{article.createTime | filterDate('full')}}</sub>
      </div>
      <!--<section class="article-content" v-html="article.content">-->
      <section class="article-content">
        <div v-html="article.content"></div>
      </section>
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
import marked from 'marked'

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
    let result = await getArticleById(id)
    let article = result.data.data
    console.log(article.content)
    article.content = marked(article.content)
    console.log(article.content)
    return {article: article}
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

<style>

  .markdown-here-wrapper {
  }

  /* To add site specific rules, you can use the `data-md-url` attribute that we
     add to the wrapper element. Note that rules like this are used depending
     on the URL you're *sending* from, not the URL where the recipient views it.
  */
  /* .markdown-here-wrapper[data-md-url*="mail.yahoo."] ul { color: red; } */

  pre, code {
    font-family: Avenir, "PingFangSC-Light";

  }

  code {
    background-color: #f8f8f8;
    padding: 0.2em 0.5em;
    color:#c7254e;
    font-size: 0.9em;
    border-radius: 2px;
    display: inline; /* added to fix Yahoo block display of inline code */
    white-space: pre-wrap;
  }

  pre {
    font-size: 1em;
    line-height: 1.2em;
  }

  pre code {
    white-space: pre;
    overflow: auto; /* fixes issue #70: Firefox/Thunderbird: Code blocks with horizontal scroll would have bad background colour */
    padding: 0.5em 0.7em;
    display: block !important; /* added to counteract the Yahoo-specific `code` rule; without this, code blocks in Blogger are broken */
  }

  /* In edit mode, Wordpress uses a `* { font: ...;} rule+style that makes highlighted
  code look non-monospace. This rule will override it. */
  .markdown-here-wrapper[data-md-url*="wordpress."] code span {
    font: inherit;
  }

  /* Wordpress adds a grey background to `pre` elements that doesn't go well with
  our syntax highlighting. */
  .markdown-here-wrapper[data-md-url*="wordpress."] pre {
    background-color: transparent;
  }

  /* This spacing has been tweaked to closely match Gmail+Chrome "paragraph" (two line breaks) spacing.
  Note that we only use a top margin and not a bottom margin -- this prevents the
  "blank line" look at the top of the email (issue #243).
  */
  p{
    /* !important is needed here because Hotmail/Outlook.com uses !important to
       kill the margin in <p>. We need this to win. */
    font-family: Avenir, "PingFangSC-Light" !important;
    font-size: 15px !important;
    color: #333 !important;
    line-height: 1.8em !important;
    letter-spacing: 0.1em !important;
    margin: 1em 1em !important; /* 增加段落边距 */
    text-align: justify !important;
  }

  table, dl, blockquote, q, ul, ol {
    margin: 1.2em 0em;
  }

  ul, ol {
    padding-left: 0em;
    margin: 1.2em 2em;

  }

  li{
    margin: 0.2em 0;
    font-family: Avenir, "PingFangSC-Light" !important;
    font-size: 15px !important;
    color: #333 !important;
    line-height: 1.8em !important;
    letter-spacing: 0.1em !important;
    margin: 0.2em 0.2em !important;
  }

  ul li {
    margin: 0.2em 0;
    font-family: Avenir, "PingFangSC-Light" !important;
    font-size: 15px !important;
    color: #333 !important;
    line-height: 1.8em !important;
    letter-spacing: 0.1em !important;
    margin: 0.2em 0.2em !important;
  }

  /* Smaller spacing for sub-lists */
  ul ul, ul ol, ol ul, ol ol {
    margin: 0;
    padding-left: 1em;
  }

  /* Use Roman numerals for sub-ordered-lists. (Like Github.) */
  ol ol, ul ol {
    list-style-type: circle;
  }

  /* Use letters for sub-sub-ordered lists. (Like Github.) */
  ul ul ol, ul ol ol, ol ul ol, ol ol ol {
    list-style-type: square;
  }

  dl {
    padding: 0;
  }

  dl dt {
    font-size: 1em;
    font-weight: bold;
    font-style: italic;
  }

  dl dd {
    margin: 0 0 1em;
    padding: 0 1em;
  }

  blockquote, q {
    border-left: 10px solid #3bb8af;
    border-radius: 10px 0 0 10px;
    /* background-color: #fafafa;*/
    padding: 0em; /* 删除内边距 */
    margin: 0em 1em;
    color: #777;
    quotes: none;
  }


  strong, b{
    color: #3bb8af;
  }


  /* 设置引用文本颜色 */
  blockquote p {
    color: rgb(119, 117, 117) !important
  }

  blockquote::before, blockquote::after, q::before, q::after {
    content: none;
  }

  h1, h2, h3, h4, h5, h6 {
    margin: 1.3em 0 1em;
    padding: 10px;
    font-weight: bold;
    letter-spacing: 0.1em !important;
  }

  h1 {
    font-size: 1.7em;
    border-bottom: 1px solid #ddd;
    color: black;
  }

  h2 {
    font-size: 1.4em;
    text-align: center;
    border-bottom: 1px solid #eee;
    color: #3bb8af;
  }

  h3 {
    font-size: 1.3em;
  }

  h4 {
    font-size: 1.2em;
  }

  h5 {
    font-size: 1em;
  }

  h6 {
    font-size: 1em;
    color: #777;
  }

  table {
    border-collapse: collapse;
    border-spacing: 0;
    font-size: .8em;
    border: 0;
    font-family: Avenir, "PingFangSC-Light";
  }

  tbody {
    margin: 0;
    padding: 0;
    border: 0;
  }

  table tr {
    border: 0;
    border-top: 1px solid #CCC;
    background-color: white;
    margin: 0;
    padding: 0;

  }

  table tr:nth-child(2n) {
    background-color: #F8F8F8;
  }

  table tr th, table tr td {
    font-size: 0.8em;
    border: 1px solid #CCC;
    margin: 0;
    padding: 0.5em 1em;
  }

  table tr th {
    font-weight: bold;
    background-color: #F0F0F0;
  }
</style>

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
      background-color: rgba(10, 10, 10, 0.5);
      background-color: #f0f0f0;
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
