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

————————————————
原文作者：zmxyzmxy1234
转自链接：https://learnku.com/articles/46298
版权声明：著作权归作者所有。商业转载请联系作者获得授权，非商业转载请保留以上作者信息和原文链接。