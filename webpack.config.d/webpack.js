config.resolve.modules.push("../../processedResources/js/main");

if (config.devServer) {
    config.devServer.hot = false;
    config.devServer.stats = {
        warnings: false
    };
    config.devServer.clientLogLevel = 'error';
    config.devtool = 'eval-cheap-source-map';
}
