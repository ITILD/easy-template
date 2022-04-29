<template>
  <div>
    <div id="theMatrix"></div>
    <div>小王子</div>
  </div>
</template>

<script>
console.log("cesium");
//引入cesium

import * as Cesium from "../assets/cesium/Source/Cesium.js";
// import * as Cesium from "../assets/cesium/Build/Cesium/Cesium.js";

import "../assets/cesium/Source/Widgets/widgets.css";

export default {
  data: () => ({}),
  // 生命周期 加载后
  mounted() {
    let viewer = new Cesium.Viewer("theMatrix", {
      geocoder: false,
      homeButton: false,
      sceneModePicker: false,
      baseLayerPicker: false,
      navigationHelpButton: false,
      animation: false, //动画控制不显示
      //   creditContainer: "credit",
      timeline: false, //时间线
      fullscreenButton: false, //全屏按钮不显示
      vrButton: false
    });
    //去除版权信息
    viewer._cesiumWidget._creditContainer.style.display = "none";
    //帧率
    viewer.scene.debugShowFramesPerSecond = true;
    
  }
};
</script>

<style lang="scss">
html,
body {
  margin: 0;
  height: 100%;
}

#theMatrix {
  /* 纵向拉伸 */
  height: 100vh;
}
</style>
