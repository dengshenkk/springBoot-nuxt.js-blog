import Vue from 'vue'
import mavonEditor from 'mavon-editor'
// markdown-it对象：md.s_markdown, md => mavonEditor实例
//                 or
//                 mavonEditor.markdownIt
import 'mavon-editor/dist/css/index.css'




// import other plugin
import  './element-ui'
import baseMixin from './mixin'
Vue.mixin(baseMixin)
Vue.use(mavonEditor)
