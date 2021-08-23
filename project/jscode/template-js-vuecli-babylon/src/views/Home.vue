<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png" />
    <HelloWorld msg="world2test" />
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from "@/components/HelloWorld.vue";
// import HelloWorld from "@/component";

export default {
  name: "Home",
  components: {
    HelloWorld,
  },
};
</script>
