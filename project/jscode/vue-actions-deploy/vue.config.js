module.exports = {
  outputDir: 'dist',
  publicPath: process.env.NODE_ENV === 'production'
  ? '/vue-actions-deploy/'
  : '/',
  lintOnSave: true
}