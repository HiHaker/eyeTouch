require('./check-versions')()

var fs = require('fs')
var path = require('path')
var ora = require('ora')
var rm = require('rimraf')
var chalk = require('chalk')
var webpack = require('webpack')
var ejs = require('ejs')
var spinner = ora('building for production...')

var config = require('../config')('test')
var webpackConfig = config.webpackConfig
var assetsRoot = webpackConfig.output.path

spinner.start()

rm(assetsRoot, err => {
  if (err) throw err
  webpack(webpackConfig, function (err, stats) {
    if (err) throw err
    process.stdout.write(stats.toString({
      colors: true,
      modules: false,
      children: false,
      chunks: false,
      chunkModules: false
    }) + '\n\n')
    spinner.stop()

    spinner = ora('make html files...')
    spinner.start()

    var namedChunks = stats.compilation.namedChunks;
    var options = stats.compilation.options;
    var htmlDir = path.join(__dirname, '..', 'dist')
    Object.keys(webpackConfig.entry).forEach(function(entry){
      var templatePath = path.join(__dirname, '..', 'template', `${entry}.ejs`)
      var defaultTemplatePath = path.join(__dirname, '..', 'template', 'default.ejs')
      var template = '';
      if (fs.existsSync(templatePath)) {
        template = templatePath
      } else if (fs.existsSync(defaultTemplatePath)) {
        template = defaultTemplatePath
      }
      template = fs.readFileSync(template, 'utf8')
      try {
        if (!fs.existsSync(htmlDir)) {
          fs.mkdirSync(htmlDir);
        }
        fs.writeFileSync(
          path.join(htmlDir, 'index.html'),
          ejs.render(template, {
            publicPath: options.output.publicPath,
            entry: entry,
            index: namedChunks[entry].files[0].replace(/(^js\/)|(\.js$)/g, ''),
            manifest: namedChunks['manifest'].files[0],
            vendor: namedChunks['vendor'].files[0],
          })
        );
      } catch (e) {
        console.log(chalk.red(e.message))
        console.log(chalk.red(e.stack))
      }
    })
    spinner.stop()
    console.log(chalk.cyan('  Build complete.\n'))
  })
})
