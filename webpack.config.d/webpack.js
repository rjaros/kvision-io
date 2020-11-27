config.resolve.modules.push("../../processedResources/js/main");

if (config.devServer) {
    config.devServer.hot = false;
    config.devtool = 'eval-cheap-source-map';
}
