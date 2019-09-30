const proxyTable = require('../proxy');
const webpackConfig = require('./webpack');

const config = {
  env: '"development"',
  assetsSubDirectory: 'static',
  assetsPublicPath: '/',

  proxyTable: proxyTable,
  autoOpenBrowser: false,
  port: 3000,
}

config.webpackConfig = webpackConfig(config)

module.exports = config
