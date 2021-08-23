// module.exports = {
//   // publicPath: './', // 公共,基本路径

//   // // 输出文件目录，不同的环境打不同包名
//   // outputDir: process.env.outputDir,
//   // // outputDir: process.env.NODE_ENV === "test" ? 'dist_test' : 'dist', 
//   // assetsDir: 'static', // 默认会在目录同时生成三个静态目录：js,css,img
//   // lintOnSave: false, // 关闭eslint代码检查
//   // filenameHashing: false, // 生成的静态资源名, 默认加了hash, 命名.后面的为hash：chunk-2d0aecf8.71e621e9
//   // // productionSourceMap:false,  // 生产环境下css 分离文件, sourceMap 文件
//   // // // webpack配置
//   // chainWebpack: (config) => {
//   // },
//   // configureWebpack: (config) => {
//   //   if (process.env.NODE_ENV === 'production') {
//   //     // 为生产环境修改配置...
//   //     config.mode = 'production'
//   //   } else {
//   //     // 为开发环境修改配置...
//   //     config.mode = 'development'
//   //   }
//   //   // Object.assign(config, {
//   //   //   // 开发生产共同配置
//   //   //   resolve: {
//   //   //     alias: {
//   //   //       '@': './src',
//   //   //     } // 别名配置
//   //   //   }
//   //   // })
//   // },
//   // productionSourceMap: false, // 生产环境是否生成 sourceMap 文件
//   // // css: {   
//   // //     extract: true,      // 是否使用css分离插件 ExtractTextPlugin
//   // //     sourceMap: false,   // 开启 CSS source maps        
//   // //     modules: false,     // 启用 CSS modules for all css / pre-processor files.
//   // //     // css 预设器配置项
//   // //     loaderOptions: {
//   // //         sass: {
//   // //             data: `@import "./src/assets/hotcss/px2rem.scss";`
//   // //         }
//   // //     }        
//   // // },
//   // devServer: {
//   //     port:8089,
//   //     host: "localhost",   // 0.0.0.0
//   //     open: true,          // 配置自动启动浏览器
//   //     https: false, 
//   //     hotOnly: false,
//   //     overlay: {
//   //         warnings: true,
//   //         errors: true
//   //     },
//   //     //  配置代理,解决跨域的问题, 只有一个代理
//   //     // proxy: null,
//   //     // proxy: 'http://api.mc.com',

//   //     proxy: {
//   //         '/api': {
//   //             target: 'http://192.168.3.215:8888',
//   //                 // 在本地会创建一个虚拟服务端，然后发送请求的数据，并同时接收请求的数据，这样服务端和服务端进行数据的交互就不会有跨域问题
//   //             changeOrigin: true, 
//   //             ws: true,
//   //             pathRewrite: {
//   //                 // 替换target中的请求地址，也就是说以后你在请求http://api.jisuapi.com/XXXXX这个地址的时候直接写成/api即可
//   //                  '^/api': '/' 
//   //             }
//   //         }
//   //     },
//   //     before: app => {},     // 第三方插件
//   // }
// }
const CopyWebpackPlugin = require("copy-webpack-plugin");
const webpack = require("webpack");
const path = require("path");

let cesiumSource = "./src/assets/cesium/Source";
console.log(process.env.NODE_ENV); // development（在终端输出）
console.log(process.env.BASE_URL);
module.exports = {
  publicPath: "./", // 公共,基本路径

  // 输出文件目录，不同的环境打不同包名（根据node环境相应.env配置）
  outputDir: process.env.outputDir,
  // outputDir: process.env.NODE_ENV === "test" ? 'dist_test' : 'dist',
  assetsDir: "static", // 默认会在目录同时生成三个静态目录：js,css,img
  lintOnSave: false, // 关闭eslint代码检查
  filenameHashing: false, // 生成的静态资源名, 默认加了hash, 命名.后面的为hash：chunk-2d0aecf8.71e621e9
  productionSourceMap: false, // 生产环境下css 分离文件, sourceMap 文件
  // webpack配置
  chainWebpack: () => {},
  configureWebpack: (config) => {
    if (process.env.NODE_ENV === "production") {
      // 为生产环境修改配置...
      config.mode = "production";
    } else {
      // 为开发环境修改配置...
      config.mode = "development";
    }
    // Object.assign(config, {
    //   // 开发生产共同配置
    //   resolve: {
    //     alias: {
    //       '@': './src',
    //     } // 别名配置
    //   }
    // })
  },
  productionSourceMap: false, // 生产环境是否生成 sourceMap 文件
  // css: {
  //     extract: true,      // 是否使用css分离插件 ExtractTextPlugin
  //     sourceMap: false,   // 开启 CSS source maps
  //     modules: false,     // 启用 CSS modules for all css / pre-processor files.
  //     // css 预设器配置项
  //     loaderOptions: {
  //         sass: {
  //             data: `@import "./src/assets/hotcss/px2rem.scss";`
  //         }
  //     }
  // },
  devServer: {
    port: 8083,
    host: "localhost", // 0.0.0.0
    open: true, // 配置自动启动浏览器
    https: false,
    hotOnly: false,
    overlay: {
      warnings: true,
      errors: true,
    },
    //  配置代理,解决跨域的问题, 只有一个代理
    // proxy: null,
    // proxy: 'http://api.mc.com',

    // proxy: {
    //     '/api': {
    //         target: 'http://192.168.3.215:8888',
    //             // 在本地会创建一个虚拟服务端，然后发送请求的数据，并同时接收请求的数据，这样服务端和服务端进行数据的交互就不会有跨域问题
    //         changeOrigin: true,
    //         ws: true,
    //         pathRewrite: {
    //             // 替换target中的请求地址，也就是说以后你在请求http://api.jisuapi.com/XXXXX这个地址的时候直接写成/api即可
    //              '^/api': '/'
    //         }
    //     }
    // },
    before: (app) => {}, // 第三方插件
  },
  configureWebpack: {
    output: {
      sourcePrefix: " ", // 1
    },
    amd: {
      // 2
      toUrlUndefined: true,
    },
    resolve: {
      alias: {
        // 'vue$': 'vue/dist/vue.esm.js',
        "@": path.resolve("src"),
        cesium: path.resolve(__dirname, cesiumSource), // 3
      },
    },
    plugins: [
      // 4
      new CopyWebpackPlugin([
      {
        from: path.join(cesiumSource, "Workers"),
        to: "Workers",
      }, ]),
      new CopyWebpackPlugin([
      {
        from: path.join(cesiumSource, "Assets"),
        to: "Assets",
      }, ]),
      new CopyWebpackPlugin([
      {
        from: path.join(cesiumSource, "Widgets"),
        to: "Widgets",
      }, ]),
      new CopyWebpackPlugin([
      {
        from: path.join(cesiumSource, "ThirdParty/Workers"),
        to: "ThirdParty/Workers",
      }, ]),
      new webpack.DefinePlugin({
        // 5
        CESIUM_BASE_URL: JSON.stringify("./"),
      }),
    ],
    module: {
      unknownContextCritical: /^.\/.*$/,
      unknownContextCritical: false, // 6
    },
  },
};
