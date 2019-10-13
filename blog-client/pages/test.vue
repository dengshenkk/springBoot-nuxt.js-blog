<template>
  <div>
    <h1>姓名：{{info.name}}</h1>
    <h2>年龄：{{info.age}}</h2>
    <h2>兴趣：{{info.interest}}</h2>
    <h1>{{category}}</h1>
  </div>
</template>
<script>
import axios from 'axios'
import {getCategoryList} from '../api/category'

export default {
  data() {
    return {
      name: 'hello World'
    }
  },
  async asyncData() {
    console.log(1)
    // let {data} = await axios.get('https://api.myjson.com/bins/8gdmr')
    let data = {test: true}
    let category = {}
    await getCategoryList().then(res => {
      console.log(res.data)
      category = res.data
    })

    console.log(2)
    return {info: data, category}
  }
}
</script>
