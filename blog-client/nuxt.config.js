// import 'element-ui/lib/theme-chalk/index.css'
module.exports = {
  /*
  ** Headers of the page
  */
  head: {
    title: 'blog-client',
    meta: [
      {charset: 'utf-8'},
      {name: 'viewport', content: 'width=device-width, initial-scale=1'},
      {hid: 'description', name: 'description', content: 'Nuxt.js project'}
    ],
    link: [
      {rel: 'icon', type: 'image/x-icon', href: '/favicon.ico'}
    ]
  },
  modules: [
    '@nuxtjs/proxy'
  ],
  proxy: {
    '/api': {
      target: 'http://localhost:9999',
      pathRewrite: {
        '^/api': '/'
      }
    }
  },
  // 全局css
  css: ['reset.css', '~/assets/css/reset.css'],
  /*
  ** Customize the progress bar color
  */
  loading: {color: '#3B8070'},

  plugins: [{src: '~/plugins/index', ssr: false}],
  /*
  ** Build configuration
  */
  build: {
    vendor: ['element-ui'],
    /*
    ** Run ESLint on save
    */
    extend(config, {isDev, isClient}) {
      if (isDev && isClient) {
        config.module.rules.push({
          enforce: 'pre',
          test: /\.(js|vue)$/,
          loader: 'eslint-loader',
          exclude: /(node_modules)/
        })
      }
    }
  }
}

