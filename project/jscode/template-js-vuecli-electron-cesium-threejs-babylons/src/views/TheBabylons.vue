
<template>
  <canvas id="renderCanvas"></canvas>
</template>

<script>
import {Engine,Scene,ArcRotateCamera,Vector3,HemisphericLight,PointLight,MeshBuilder} from "@babylonjs/core"
export default {
  data() {
    return {};
  },
  mounted() {
    var canvas = document.getElementById("renderCanvas"); // 得到canvas对象的引用
    var engine = new Engine(canvas, true); // 初始化 BABYLON 3D engine

    /******* Add the create scene function ******/
    var createScene = function () {
      // 创建一个场景scene
      var scene = new Scene(engine);

      // 添加一个相机，并绑定鼠标事件
      var camera = new ArcRotateCamera(
        "Camera",
        Math.PI / 2,
        Math.PI / 2,
        2,
        new Vector3(0, 0, 5),
        scene
      );
      camera.attachControl(canvas, true);

      // 添加一组灯光到场景
      // eslint-disable-next-line no-unused-vars
      var light1 = new HemisphericLight(
        "light1",
        new Vector3(1, 1, 0),
        scene
      );
      // eslint-disable-next-line no-unused-vars
      var light2 = new PointLight(
        "light2",
        new Vector3(0, 1, -1),
        scene
      );

      // 添加一个球体到场景中
      // eslint-disable-next-line no-unused-vars
      var sphere = MeshBuilder.CreateSphere(
        "sphere",
        { diameter: 2 },
        scene
      );

      return scene;
    };
    /******* End of the create scene function ******/

    var scene = createScene(); //Call the createScene function

    // 最后一步调用engine的runRenderLoop方案，执行scene.render()，让我们的3d场景渲染起来
    engine.runRenderLoop(function () {
      scene.render();
    });

    // 监听浏览器改变大小的事件，通过调用engine.resize()来自适应窗口大小
    window.addEventListener("resize", function () {
      engine.resize();
    });
  },
};
</script>

<style>
html,body,#app {
  overflow: hidden;
  width: 100%;
  height: 100%;
  margin: 0;
  padding: 0;
}
#renderCanvas {
  width: 100%;
  height: 100%;
  touch-action: none;
}
</style>
