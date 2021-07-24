<template>
  <a-config-provider :locale="locale">
    <router-view></router-view>
  </a-config-provider>
</template>

<script setup>
import locale from "ant-design-vue/es/locale/zh_CN";
</script>

<style>
html{
  height: 100%; 
}
body {
  /* height: 100%; */
  margin: 0px;
  padding: 0px;
}
#app {
  /* font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: left;
  height: 100%; */
  width: 100%;
  height: 100%;

  min-width: 900px;
  min-height: 500px;

  overflow: auto;/*产生滚动条*/

  background-image: url("medium/background.gif");
  background-repeat:no-repeat;
  background-position: center;
  background-size:100% 100%;
  background-attachment: fixed;
}
</style>
