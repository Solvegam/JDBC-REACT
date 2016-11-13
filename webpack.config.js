module.exports = {
    entry: [
        './src/main/js/App.js'
    ],
    output: {
        path: __dirname + '/src/main/webapp/',
        filename: "bundle.js"
    },
    module: {
        loaders: [{
            test: /\.jsx?$/,
            loader: 'babel',
        }]
    },
    devServer: {
        contentBase: __dirname + '/src/main/webapp/',
        port: 8060,
        colors: true,
        historyApiFallback: false,
        inline: false
    }
};