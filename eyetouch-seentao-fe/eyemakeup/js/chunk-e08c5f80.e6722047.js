(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-e08c5f80"],{"02f4":function(t,e,n){var r=n("4588"),i=n("be13");t.exports=function(t){return function(e,n){var a,o,c=String(i(e)),s=r(n),u=c.length;return s<0||s>=u?t?"":void 0:(a=c.charCodeAt(s),a<55296||a>56319||s+1===u||(o=c.charCodeAt(s+1))<56320||o>57343?t?c.charAt(s):a:t?c.slice(s,s+2):o-56320+(a-55296<<10)+65536)}}},"0390":function(t,e,n){"use strict";var r=n("02f4")(!0);t.exports=function(t,e,n){return e+(n?r(t,e).length:1)}},"0bfb":function(t,e,n){"use strict";var r=n("cb7c");t.exports=function(){var t=r(this),e="";return t.global&&(e+="g"),t.ignoreCase&&(e+="i"),t.multiline&&(e+="m"),t.unicode&&(e+="u"),t.sticky&&(e+="y"),e}},"11e9":function(t,e,n){var r=n("52a7"),i=n("4630"),a=n("6821"),o=n("6a99"),c=n("69a8"),s=n("c69a"),u=Object.getOwnPropertyDescriptor;e.f=n("9e1e")?u:function(t,e){if(t=a(t),e=o(e,!0),s)try{return u(t,e)}catch(n){}if(c(t,e))return i(!r.f.call(t,e),t[e])}},1325:function(t,e,n){"use strict";n.d(e,"b",function(){return r}),n.d(e,"a",function(){return i});n("55dd"),n("3b2b"),n("a481");Date.prototype.Format=function(t){var e={"M+":this.getMonth()+1,"d+":this.getDate(),"h+":this.getHours(),"m+":this.getMinutes(),"s+":this.getSeconds(),"q+":Math.floor((this.getMonth()+3)/3)};for(var n in/(y+)/.test(t)&&(t=t.replace(RegExp.$1,(this.getFullYear()+"").substr(4-RegExp.$1.length))),e)new RegExp("("+n+")").test(t)&&(t=t.replace(RegExp.$1,1==RegExp.$1.length?e[n]:("00"+e[n]).substr((""+e[n]).length)));return t};var r=function(){for(var t=[],e="0123456789abcdef",n=0;n<36;n++)t[n]=e.substr(Math.floor(16*Math.random()),1);t[14]="4",t[19]=e.substr(3&t[19]|8,1),t[8]=t[13]=t[18]=t[23]="-";var r=t.join("");return r},i=function(){return(new Date).Format("yyyy-MM-dd hh:mm:ss")}},"214f":function(t,e,n){"use strict";n("b0c5");var r=n("2aba"),i=n("32e9"),a=n("79e5"),o=n("be13"),c=n("2b4c"),s=n("520a"),u=c("species"),l=!a(function(){var t=/./;return t.exec=function(){var t=[];return t.groups={a:"7"},t},"7"!=="".replace(t,"$<a>")}),d=function(){var t=/(?:)/,e=t.exec;t.exec=function(){return e.apply(this,arguments)};var n="ab".split(t);return 2===n.length&&"a"===n[0]&&"b"===n[1]}();t.exports=function(t,e,n){var p=c(t),m=!a(function(){var e={};return e[p]=function(){return 7},7!=""[t](e)}),f=m?!a(function(){var e=!1,n=/a/;return n.exec=function(){return e=!0,null},"split"===t&&(n.constructor={},n.constructor[u]=function(){return n}),n[p](""),!e}):void 0;if(!m||!f||"replace"===t&&!l||"split"===t&&!d){var g=/./[p],h=n(o,p,""[t],function(t,e,n,r,i){return e.exec===s?m&&!i?{done:!0,value:g.call(e,n,r)}:{done:!0,value:t.call(n,e,r)}:{done:!1}}),v=h[0],y=h[1];r(String.prototype,t,v),i(RegExp.prototype,p,2==e?function(t,e){return y.call(t,this,e)}:function(t){return y.call(t,this)})}}},"2ee1":function(t,e,n){"use strict";n.r(e);var r=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{attrs:{id:"styleMigration"}},[n("div",{staticClass:"container"},[n("div",{staticClass:"sectionA"},[t._m(0),n("div",{staticClass:"myPicture"},[n("div",{staticClass:"title"}),n("div",{staticClass:"temp"},[n("div",{staticClass:"temp-left"},[n("div",{staticClass:"tempSelect"},[n("div",{staticClass:"head"},[t._v("选择您想要融合的眼妆")]),n("ul",{staticClass:"images"},t._l(t.myImages,function(e,r){return n("li",{class:{li_active:e==t.imageUrl1}},[n("img",{attrs:{src:e.id},on:{click:function(e){return t.selectImage(r)}}})])}),0),n("div",{staticClass:"pagenation"},[n("el-pagination",{attrs:{small:"",layout:"prev, pager, next",total:50}})],1),n("div",{staticClass:"selectPictrue"},[n("div",{staticClass:"tip"},[t._v("没有喜欢的？选择图片上传")]),n("el-upload",{attrs:{action:t.upload_qiniu_url,data:t.qiniuData,limit:1,"before-upload":t.beforeUpload1,"on-success":t.handleSuccess2,"on-error":t.handleError1}},[n("el-button",{attrs:{size:"mini",type:"primary"}},[t._v("点击上传")])],1)],1)])]),n("div",{staticClass:"temp-image"},[n("div",{staticClass:"my-image"},[n("img",{attrs:{src:t.imageUrl1,alt:""}})]),n("div",{staticClass:"obj-image"},[n("img",{attrs:{src:t.imageUrl2,alt:""}})]),n("div",{staticClass:"submit"},[n("el-button",{directives:[{name:"loading",rawName:"v-loading.fullscreen.lock",value:t.fullscreenLoading,expression:"fullscreenLoading",modifiers:{fullscreen:!0,lock:!0}}],attrs:{type:"primary",size:"small","element-loading-text":"玩命生成中···"},on:{click:t.getMergeImage}},[t._v("生成眼妆")])],1)]),n("div",{staticClass:"temp-right"},[n("div",{staticClass:"head"},[t._v("上传您的美照")]),n("div",{staticClass:"dragUpload"},[n("el-upload",{staticClass:"upload-demo",attrs:{drag:"",action:t.upload_qiniu_url,data:t.qiniuData,limit:1,"before-upload":t.beforeUpload1,"on-success":t.handleSuccess1,"on-error":t.handleError1,"on-remove":t.removeImage}},[n("i",{staticClass:"el-icon-upload"}),n("div",{staticClass:"el-upload__text"},[t._v("将图片拖到此处,或"),n("em",[t._v("点击上传")])]),n("div",{staticClass:"el-upload__tip",attrs:{slot:"tip"},slot:"tip"},[t._v("只能上传jpg/png文件，且不超过500kb")])])],1)])])]),t.isShowResult?n("div",{staticClass:"result"},[n("div",{staticClass:"result-left"},[n("div",{staticClass:"result-title"},[t._v("妆容迁移结果")]),n("div",{staticClass:"result-image"},[n("el-image",{attrs:{src:t.resultImage,lazy:"",fit:"cover"}})],1),n("div",{staticClass:"cosrecommend"},[n("div",{staticClass:"tip"},[t._v("\n              为您推荐对应妆品:\n            ")]),n("ul",t._l(t.recommendList,function(e){return n("li",{on:{click:function(n){return t.toUrl(e.link)}}},[n("div",{staticClass:"image"},[n("el-image",{attrs:{src:e.image,lazy:"",fit:"cover"}})],1),n("div",{staticClass:"title"},[t._v(t._s(e.name))])])}),0)])]),n("div",{staticClass:"result-right"},[n("div",{staticClass:"title"},[t._v("妆容教程")]),n("div",{staticClass:"teaching",domProps:{innerHTML:t._s(t.course)}})])]):t._e()])]),n("div",{staticClass:"return",on:{click:t.returnLastPage}},[n("el-button",{attrs:{icon:"el-icon-arrow-left",circle:"",title:"返回上一页"}})],1)])},i=[function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"example"},[n("div",{staticClass:"title"}),n("div",{staticClass:"pic1"},[n("img",{attrs:{src:"http://pymhh35l8.bkt.clouddn.com/static/10.jpg"}})]),n("div",{staticClass:"pic2"},[n("img",{attrs:{src:"http://pymhh35l8.bkt.clouddn.com/111mmmm.jpg"}})]),n("div",{staticClass:"pic3"},[n("img",{attrs:{src:"http://pymhh35l8.bkt.clouddn.com/static/a.png"}})])])}],a=(n("7f7f"),n("bc3a")),o=n.n(a),c=n("e490"),s=function(){return o()({url:c["a"]+"/myimg/myimg/list",method:"get"}).then(function(t){return console.log(t.data.detailMsg.data.content),t.data.detailMsg.data.content}).catch(function(t){t&&console.log(t)})},u=function(t){return o()({url:"https://fengblog.xyz:3029/message/getMergeImage",method:"post",data:t})},l=n("caf6"),d=n("1325"),p=n("c107"),m={name:"styleMigration",data:function(){return{imageList:[],qiniuData:{key:"",token:""},upload_qiniu_url:"http://upload-z2.qiniup.com",upload_qiniu_addr:"http://pymhh35l8.bkt.clouddn.com/",cosImageList:["http://pymhh35l8.bkt.clouddn.com/%E5%9B%BE%E7%89%873.png","http://pymhh35l8.bkt.clouddn.com/111123.jpg","http://pymhh35l8.bkt.clouddn.com/111mmmm.jpg","http://pymhh35l8.bkt.clouddn.com/111%E5%9B%BE%E7%89%871.png","http://pymhh35l8.bkt.clouddn.com/1.jpg","http://pymhh35l8.bkt.clouddn.com/11134.jpg"],course:'\n        <h4>妆前：</h4>\n        <p>妆前敷了片新入的面膜, 面膜纸比较薄, 敷完了脸上水润润滴, 精华液也挺多哒, 比较保湿, 上妆也更服帖一点啦, 不会卡粉啥的。</p>\n\n        <h4>眼影：</h4>\n        <p>这次画的偏冷色系的眼妆</p>\n        <p>1. 先打底</p>\n        <p>2. 棕色铺眼皮晕染</p>\n        <p>3. 沾少量灰色涂在双眼皮褶内晕染</p>\n        <p>4. 还是刚刚的灰色, 只涂下眼尾的小三角</p>\n        <image fit="cover" src="http://pymhh35l8.bkt.clouddn.com/makeupcourse/%E5%9B%BE%E7%89%878.png"/>\n        <image fit="cover" src="http://pymhh35l8.bkt.clouddn.com/makeupcourse/%E5%9B%BE%E7%89%874.png"/>\n        \n        <h4>眼线：</h4>\n        <p>还是从眼尾拖出一条</p></p>\n        <p>不一样的是,要再沾取深棕色眼影在下眼皮的眼头画眼线</p>\n        <image fit="cover" src="http://pymhh35l8.bkt.clouddn.com/makeupcourse/%E5%9B%BE%E7%89%875.png">\n        </image>\n\n        <h4>卧蚕：</h4>\n        <p>记得用眉笔在卧蚕下方 描一下下</p>\n        <image fit="cover" src="http://pymhh35l8.bkt.clouddn.com/makeupcourse/%E5%9B%BE%E7%89%877.png">\n        </image>\n\n        <h4>腮红：</h4>\n        <p>今天画的是眼下腮红喔</p></p>\n        <p>着重涂在眼周围一圈 画在图上啦</p>\n\n        <h4>口红：</h4>\n        <p>涂跟我们紫色腮红相配一点的</p>\n        <p>果汁感满满的火龙果M503络红绣 玫红色的夏天涂玫红真的敲显白的 哇介个质地涂了hen润</p>\n        <p>薄涂咬唇又hen少女~ 白皮涂了更好看~</p>\n        <image fit="cover" src="http://pymhh35l8.bkt.clouddn.com/makeupcourse/%E5%9B%BE%E7%89%876.png">\n        </image>\n        \n        ',imageUrl1:"",imageUrl2:"",tempImage:"",resultImage:"",isShowResult:!1,fullscreenLoading:!1,dialogImageUrl:"",recommendList:p["g"],myImages:p["e"]}},computed:{showResultImage:function(){return this.resultImage}},methods:{returnLastPage:function(){this.$router.go(-1)},getImageList:function(){var t=this;s().then(function(e){t.imageList=e})},selectImage:function(t){this.imageUrl1=p["e"][t].id,this.course=p["e"][t].course},getMergeImage:function(){var t=this;this.fullscreenLoading=!0,u({api_key:"v5vCY2FcYL5hk4oucP8_7u2pgVnPYjJB",api_secret:"zHPtWAcDzd3MFObqI4ml8aevnwJ95wsV",template_url:this.imageUrl2,merge_url:this.imageUrl1}).then(function(e){t.tempImage=e.data.result,setTimeout(function(){t.resultImage=t.tempImage,t.isShowResult=!0,t.fullscreenLoading=!1,t.$message.success("生成成功!"),console.log(t.resultImage)},5e3)})},beforeUpload1:function(t){this.qiniuData.key=Object(d["b"])()+t.name;var e="image/jpeg"===t.type,n="image/png"===t.type,r=t.size/1024/1024<5;return e||n?r?void 0:(this.$message.error("图片大小不能超过 5MB!"),!1):(this.$message.error("图片只能是 JPG/PNG 格式!"),!1)},handleSuccess1:function(t,e){this.imageUrl2=this.upload_qiniu_addr+t.key},handleSuccess2:function(t,e){this.imageUrl1=this.upload_qiniu_addr+t.key},handleError1:function(t){this.$message({message:"上传失败",duration:2e3,type:"warning"})},removeImage:function(){this.imageUrl=""},toUrl:function(t){window.open(t,"_blank")}},components:{},created:function(){var t=this;this.getImageList(),Object(l["m"])().then(function(e){t.qiniuData.token=e.data,console.log(t.qiniuData.token)})},beforeMount:function(){document.documentElement.scrollTop=0}},f=m,g=(n("d638"),n("2877")),h=Object(g["a"])(f,r,i,!1,null,null,null);e["default"]=h.exports},"2f21":function(t,e,n){"use strict";var r=n("79e5");t.exports=function(t,e){return!!t&&r(function(){e?t.call(null,function(){},1):t.call(null)})}},"3b2b":function(t,e,n){var r=n("7726"),i=n("5dbc"),a=n("86cc").f,o=n("9093").f,c=n("aae3"),s=n("0bfb"),u=r.RegExp,l=u,d=u.prototype,p=/a/g,m=/a/g,f=new u(p)!==p;if(n("9e1e")&&(!f||n("79e5")(function(){return m[n("2b4c")("match")]=!1,u(p)!=p||u(m)==m||"/a/i"!=u(p,"i")}))){u=function(t,e){var n=this instanceof u,r=c(t),a=void 0===e;return!n&&r&&t.constructor===u&&a?t:i(f?new l(r&&!a?t.source:t,e):l((r=t instanceof u)?t.source:t,r&&a?s.call(t):e),n?this:d,u)};for(var g=function(t){t in u||a(u,t,{configurable:!0,get:function(){return l[t]},set:function(e){l[t]=e}})},h=o(l),v=0;h.length>v;)g(h[v++]);d.constructor=u,u.prototype=d,n("2aba")(r,"RegExp",u)}n("7a56")("RegExp")},"520a":function(t,e,n){"use strict";var r=n("0bfb"),i=RegExp.prototype.exec,a=String.prototype.replace,o=i,c="lastIndex",s=function(){var t=/a/,e=/b*/g;return i.call(t,"a"),i.call(e,"a"),0!==t[c]||0!==e[c]}(),u=void 0!==/()??/.exec("")[1],l=s||u;l&&(o=function(t){var e,n,o,l,d=this;return u&&(n=new RegExp("^"+d.source+"$(?!\\s)",r.call(d))),s&&(e=d[c]),o=i.call(d,t),s&&o&&(d[c]=d.global?o.index+o[0].length:e),u&&o&&o.length>1&&a.call(o[0],n,function(){for(l=1;l<arguments.length-2;l++)void 0===arguments[l]&&(o[l]=void 0)}),o}),t.exports=o},"55dd":function(t,e,n){"use strict";var r=n("5ca1"),i=n("d8e8"),a=n("4bf8"),o=n("79e5"),c=[].sort,s=[1,2,3];r(r.P+r.F*(o(function(){s.sort(void 0)})||!o(function(){s.sort(null)})||!n("2f21")(c)),"Array",{sort:function(t){return void 0===t?c.call(a(this)):c.call(a(this),i(t))}})},"5dbc":function(t,e,n){var r=n("d3f4"),i=n("8b97").set;t.exports=function(t,e,n){var a,o=e.constructor;return o!==n&&"function"==typeof o&&(a=o.prototype)!==n.prototype&&r(a)&&i&&i(t,a),t}},"5f1b":function(t,e,n){"use strict";var r=n("23c6"),i=RegExp.prototype.exec;t.exports=function(t,e){var n=t.exec;if("function"===typeof n){var a=n.call(t,e);if("object"!==typeof a)throw new TypeError("RegExp exec method returned something other than an Object or null");return a}if("RegExp"!==r(t))throw new TypeError("RegExp#exec called on incompatible receiver");return i.call(t,e)}},"7f7f":function(t,e,n){var r=n("86cc").f,i=Function.prototype,a=/^\s*function ([^ (]*)/,o="name";o in i||n("9e1e")&&r(i,o,{configurable:!0,get:function(){try{return(""+this).match(a)[1]}catch(t){return""}}})},"8b97":function(t,e,n){var r=n("d3f4"),i=n("cb7c"),a=function(t,e){if(i(t),!r(e)&&null!==e)throw TypeError(e+": can't set as prototype!")};t.exports={set:Object.setPrototypeOf||("__proto__"in{}?function(t,e,r){try{r=n("9b43")(Function.call,n("11e9").f(Object.prototype,"__proto__").set,2),r(t,[]),e=!(t instanceof Array)}catch(i){e=!0}return function(t,n){return a(t,n),e?t.__proto__=n:r(t,n),t}}({},!1):void 0),check:a}},9093:function(t,e,n){var r=n("ce10"),i=n("e11e").concat("length","prototype");e.f=Object.getOwnPropertyNames||function(t){return r(t,i)}},a481:function(t,e,n){"use strict";var r=n("cb7c"),i=n("4bf8"),a=n("9def"),o=n("4588"),c=n("0390"),s=n("5f1b"),u=Math.max,l=Math.min,d=Math.floor,p=/\$([$&`']|\d\d?|<[^>]*>)/g,m=/\$([$&`']|\d\d?)/g,f=function(t){return void 0===t?t:String(t)};n("214f")("replace",2,function(t,e,n,g){return[function(r,i){var a=t(this),o=void 0==r?void 0:r[e];return void 0!==o?o.call(r,a,i):n.call(String(a),r,i)},function(t,e){var i=g(n,t,this,e);if(i.done)return i.value;var d=r(t),p=String(this),m="function"===typeof e;m||(e=String(e));var v=d.global;if(v){var y=d.unicode;d.lastIndex=0}var b=[];while(1){var _=s(d,p);if(null===_)break;if(b.push(_),!v)break;var x=String(_[0]);""===x&&(d.lastIndex=c(p,a(d.lastIndex),y))}for(var k="",E=0,C=0;C<b.length;C++){_=b[C];for(var I=String(_[0]),w=u(l(o(_.index),p.length),0),M=[],S=1;S<_.length;S++)M.push(f(_[S]));var B=_.groups;if(m){var j=[I].concat(M,w,p);void 0!==B&&j.push(B);var P=String(e.apply(void 0,j))}else P=h(I,p,w,M,B,e);w>=E&&(k+=p.slice(E,w)+P,E=w+I.length)}return k+p.slice(E)}];function h(t,e,r,a,o,c){var s=r+t.length,u=a.length,l=m;return void 0!==o&&(o=i(o),l=p),n.call(c,l,function(n,i){var c;switch(i.charAt(0)){case"$":return"$";case"&":return t;case"`":return e.slice(0,r);case"'":return e.slice(s);case"<":c=o[i.slice(1,-1)];break;default:var l=+i;if(0===l)return n;if(l>u){var p=d(l/10);return 0===p?n:p<=u?void 0===a[p-1]?i.charAt(1):a[p-1]+i.charAt(1):n}c=a[l-1]}return void 0===c?"":c})}})},aae3:function(t,e,n){var r=n("d3f4"),i=n("2d95"),a=n("2b4c")("match");t.exports=function(t){var e;return r(t)&&(void 0!==(e=t[a])?!!e:"RegExp"==i(t))}},b0c5:function(t,e,n){"use strict";var r=n("520a");n("5ca1")({target:"RegExp",proto:!0,forced:r!==/./.exec},{exec:r})},caf6:function(t,e,n){"use strict";n.d(e,"a",function(){return c}),n.d(e,"b",function(){return s}),n.d(e,"c",function(){return u}),n.d(e,"h",function(){return l}),n.d(e,"j",function(){return d}),n.d(e,"i",function(){return p}),n.d(e,"l",function(){return m}),n.d(e,"g",function(){return f}),n.d(e,"n",function(){return g}),n.d(e,"p",function(){return h}),n.d(e,"d",function(){return v}),n.d(e,"o",function(){return y}),n.d(e,"e",function(){return b}),n.d(e,"f",function(){return _}),n.d(e,"k",function(){return x}),n.d(e,"m",function(){return k});var r=n("bc3a"),i=n.n(r),a=n("e490"),o=n("07a4"),c=function(t){return i()({url:a["a"]+"/post/post/insertSelective",method:"post",data:t})},s=function(t){return i()({url:a["a"]+"/pimage/pimage/insertSelective",method:"post",data:t})},u=function(t){return i()({url:a["a"]+"/pvideo/pvideo/insertSelective",method:"post",data:t})},l=function(){return i()({url:a["a"]+"/community/community/getAllPostsLogin",method:"get",params:{user_ID:o["a"].state.userInfo.id||"-1"}}).then(function(t){return console.log(t),t.data.detailMsg.data}).catch(function(t){t&&console.log(t)})},d=function(t){return i()({url:a["a"]+"/community/community/getAllPostsByTypeLogin",method:"get",params:t})},p=function(t){return i()({url:a["a"]+"/community/community/getAllPostsByStyleLogin",method:"get",params:t})},m=function(t){return i()({url:a["a"]+"/community/community/getPostByIdLogin",method:"get",params:t})},f=function(t){return i()({url:a["a"]+"/community/community/deletePostById",method:"delete",params:t})},g=function(t){return i()({url:a["a"]+"/plikes/plikes/insertSelective",method:"post",data:t})},h=function(t){return i()({url:a["a"]+"/plikes/plikes/deleteByUserIdAndPostId",method:"delete",params:t})},v=function(t){return i()({url:a["a"]+"/pfavorites/pfavorites/insertSelective",method:"post",data:t})},y=function(t){return i()({url:a["a"]+"/pfavorites/pfavorites/deleteByUserIdAndPostId",method:"delete",params:t})},b=function(t){return i()({url:a["a"]+"/pcomments/pcomments/insertSelective",method:"post",data:t})},_=function(t){return i()({url:a["a"]+"/pcomments/pcomments/deleteById",method:"delete",params:t})},x=function(t){return i()({url:a["a"]+"/community/community/getCommunityMessage",method:"get",params:t})},k=function(){return i()({url:"https://fengblog.xyz:3029/message/getQiniuToken",method:"get"})}},d478:function(t,e,n){},d638:function(t,e,n){"use strict";var r=n("d478"),i=n.n(r);i.a}}]);