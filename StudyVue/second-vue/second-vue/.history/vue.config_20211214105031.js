module.exports = {
 devServer:{
 host: 'localhost', // Vue开发项目启动域名
   port: 8080, // 端口
   https: false, // 是否是https
   open:false,
   proxy:{
         '/apiDev':{
             target: 'http://api.zmxy.com', // 后端API
               changeOrigin: true,
               pathRewrite:{
                     '^/apiDev':'' // 以apiDev作为前缀
               }
         }
     }
 }
}
