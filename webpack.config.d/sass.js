config.module.rules.push({ test: /\.s[ac]ss$/, use: ["style-loader", { loader: "css-loader", options: {sourceMap: false} }, "sass-loader" ] });

