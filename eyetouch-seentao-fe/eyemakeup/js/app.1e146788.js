(function(n){function e(e){for(var r,o,i=e[0],u=e[1],s=e[2],p=0,h=[];p<i.length;p++)o=i[p],a[o]&&h.push(a[o][0]),a[o]=0;for(r in u)Object.prototype.hasOwnProperty.call(u,r)&&(n[r]=u[r]);l&&l(e);while(h.length)h.shift()();return c.push.apply(c,s||[]),t()}function t(){for(var n,e=0;e<c.length;e++){for(var t=c[e],r=!0,o=1;o<t.length;o++){var i=t[o];0!==a[i]&&(r=!1)}r&&(c.splice(e--,1),n=u(u.s=t[0]))}return n}var r={},o={app:0},a={app:0},c=[];function i(n){return u.p+"js/"+({}[n]||n)+"."+{"chunk-0564ea4c":"f1e78eda","chunk-0c241a14":"ba976fe1","chunk-1daad4d0":"afbe531f","chunk-38cd7b8b":"8f0adf25","chunk-6a3b3767":"be905c4c","chunk-3617c760":"ef1f66e6","chunk-36263f96":"9667f652","chunk-537731fc":"9e008c3b","chunk-625b6fff":"bf0407b3","chunk-6ed6f5b5":"464dd7f8","chunk-70bf2036":"6088c4b7","chunk-76d1be98":"dd328d8b","chunk-98a63bf0":"44650c9c","chunk-9e4f1794":"0e0a8ff4","chunk-a1f5f32a":"78a8e4bd","chunk-b9f1237a":"aa7f5fa1","chunk-bcb87a64":"e0c53036","chunk-dbfe0cb6":"ac184697","chunk-e08c5f80":"e6722047"}[n]+".js"}function u(e){if(r[e])return r[e].exports;var t=r[e]={i:e,l:!1,exports:{}};return n[e].call(t.exports,t,t.exports,u),t.l=!0,t.exports}u.e=function(n){var e=[],t={"chunk-0564ea4c":1,"chunk-0c241a14":1,"chunk-1daad4d0":1,"chunk-38cd7b8b":1,"chunk-6a3b3767":1,"chunk-3617c760":1,"chunk-36263f96":1,"chunk-537731fc":1,"chunk-625b6fff":1,"chunk-6ed6f5b5":1,"chunk-70bf2036":1,"chunk-76d1be98":1,"chunk-98a63bf0":1,"chunk-9e4f1794":1,"chunk-a1f5f32a":1,"chunk-b9f1237a":1,"chunk-bcb87a64":1,"chunk-dbfe0cb6":1,"chunk-e08c5f80":1};o[n]?e.push(o[n]):0!==o[n]&&t[n]&&e.push(o[n]=new Promise(function(e,t){for(var r="css/"+({}[n]||n)+"."+{"chunk-0564ea4c":"c804687c","chunk-0c241a14":"5e3f87a9","chunk-1daad4d0":"ef182880","chunk-38cd7b8b":"2500f957","chunk-6a3b3767":"28754ed4","chunk-3617c760":"3dadb5ff","chunk-36263f96":"5ce11018","chunk-537731fc":"587f78b8","chunk-625b6fff":"146fe2ec","chunk-6ed6f5b5":"d223febe","chunk-70bf2036":"6ba280ed","chunk-76d1be98":"5ce11018","chunk-98a63bf0":"c804687c","chunk-9e4f1794":"ee3777e1","chunk-a1f5f32a":"39e31a83","chunk-b9f1237a":"c5396ba1","chunk-bcb87a64":"94fe325f","chunk-dbfe0cb6":"758a9f10","chunk-e08c5f80":"3e355277"}[n]+".css",a=u.p+r,c=document.getElementsByTagName("link"),i=0;i<c.length;i++){var s=c[i],p=s.getAttribute("data-href")||s.getAttribute("href");if("stylesheet"===s.rel&&(p===r||p===a))return e()}var h=document.getElementsByTagName("style");for(i=0;i<h.length;i++){s=h[i],p=s.getAttribute("data-href");if(p===r||p===a)return e()}var l=document.createElement("link");l.rel="stylesheet",l.type="text/css",l.onload=e,l.onerror=function(e){var r=e&&e.target&&e.target.src||a,c=new Error("Loading CSS chunk "+n+" failed.\n("+r+")");c.code="CSS_CHUNK_LOAD_FAILED",c.request=r,delete o[n],l.parentNode.removeChild(l),t(c)},l.href=a;var d=document.getElementsByTagName("head")[0];d.appendChild(l)}).then(function(){o[n]=0}));var r=a[n];if(0!==r)if(r)e.push(r[2]);else{var c=new Promise(function(e,t){r=a[n]=[e,t]});e.push(r[2]=c);var s,p=document.createElement("script");p.charset="utf-8",p.timeout=120,u.nc&&p.setAttribute("nonce",u.nc),p.src=i(n),s=function(e){p.onerror=p.onload=null,clearTimeout(h);var t=a[n];if(0!==t){if(t){var r=e&&("load"===e.type?"missing":e.type),o=e&&e.target&&e.target.src,c=new Error("Loading chunk "+n+" failed.\n("+r+": "+o+")");c.type=r,c.request=o,t[1](c)}a[n]=void 0}};var h=setTimeout(function(){s({type:"timeout",target:p})},12e4);p.onerror=p.onload=s,document.head.appendChild(p)}return Promise.all(e)},u.m=n,u.c=r,u.d=function(n,e,t){u.o(n,e)||Object.defineProperty(n,e,{enumerable:!0,get:t})},u.r=function(n){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(n,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(n,"__esModule",{value:!0})},u.t=function(n,e){if(1&e&&(n=u(n)),8&e)return n;if(4&e&&"object"===typeof n&&n&&n.__esModule)return n;var t=Object.create(null);if(u.r(t),Object.defineProperty(t,"default",{enumerable:!0,value:n}),2&e&&"string"!=typeof n)for(var r in n)u.d(t,r,function(e){return n[e]}.bind(null,r));return t},u.n=function(n){var e=n&&n.__esModule?function(){return n["default"]}:function(){return n};return u.d(e,"a",e),e},u.o=function(n,e){return Object.prototype.hasOwnProperty.call(n,e)},u.p="",u.oe=function(n){throw console.error(n),n};var s=window["webpackJsonp"]=window["webpackJsonp"]||[],p=s.push.bind(s);s.push=e,s=s.slice();for(var h=0;h<s.length;h++)e(s[h]);var l=p;c.push([0,"chunk-vendors"]),t()})({0:function(n,e,t){n.exports=t("56d7")},"07a4":function(n,e,t){"use strict";var r,o=t("bd86"),a=t("2b0e"),c=t("2f62");a["default"].use(c["a"]),e["a"]=new c["a"].Store({state:{userInfo:{id:"-1",login_name:"",nickName:""},postStatus:0,viewUserId:""},mutations:(r={},Object(o["a"])(r,"userInfo",function(n,e){n.userInfo=e}),Object(o["a"])(r,"postStatus",function(n,e){n.postStatus=e}),Object(o["a"])(r,"viewUserId",function(n,e){n.viewUserId=e}),r),actions:{getUserInfo:function(n,e){var t=n.commit;t("userInfo",e)},getPostStatus:function(n,e){var t=n.commit;t("postStatus",e)},getViewUserId:function(n,e){var t=n.commit;t("viewUserId",e)}}})},"56d7":function(n,e,t){"use strict";t.r(e);t("cadf"),t("551c"),t("f751"),t("097d");var r=t("2b0e"),o=t("bc3a"),a=t.n(o),c={},i=a.a.create(c);i.interceptors.request.use(function(n){return n},function(n){return Promise.reject(n)}),i.interceptors.response.use(function(n){return n},function(n){return Promise.reject(n)}),Plugin.install=function(n,e){n.axios=i,window.axios=i,Object.defineProperties(n.prototype,{axios:{get:function(){return i}},$axios:{get:function(){return i}}})},r["default"].use(Plugin);Plugin;var u=function(){var n=this,e=n.$createElement,t=n._self._c||e;return t("div",{attrs:{id:"app"}},[t("el-container",[t("el-header",[t("g-header")],1),t("el-main",[t("router-view")],1),t("el-footer",[t("g-footer")],1)],1)],1)},s=[],p=function(){var n=this,e=n.$createElement,r=n._self._c||e;return r("div",{attrs:{id:"g-header"}},[r("el-row",[r("el-col",{attrs:{span:2}},[r("div",{staticClass:"logo"},[r("router-link",{attrs:{to:"/index"}},[r("img",{attrs:{src:t("9d64"),alt:"logo"}})])],1)]),r("el-col",{attrs:{span:6}},[r("div",{staticClass:"search"},[r("div",{staticClass:"input"},[r("el-input",{attrs:{size:"small",width:"90%",placeholder:"搜索您想要的内容···","suffix-icon":"el-icon-search"},model:{value:n.input,callback:function(e){n.input=e},expression:"input"}}),r("div",{staticClass:"hoverRecommendCon"},[r("div",{staticClass:"hoverRecommend"},[r("div",{staticClass:"hotSearch"},[r("div",{staticClass:"h-title"},[n._v("热门搜索")]),r("ul",n._l(n.headerHotSearchList,function(e){return r("li",[n._v(n._s(e))])}),0)]),r("div",{staticClass:"youLike"},[r("div",{staticClass:"y-title"},[n._v("猜你喜欢")]),r("ul",n._l(n.headerYouLikeList,function(e){return r("li",[n._v(n._s(e))])}),0)])])])],1)])]),r("el-col",{attrs:{span:12}},[r("div",{staticClass:"nav"},[r("ul",[r("router-link",{attrs:{to:"/index"}},[r("li",[n._v("首页")])]),r("router-link",{attrs:{to:"/community"}},[r("li",[n._v("社区")])]),r("router-link",{attrs:{to:"/mall/mallIndex"}},[r("li",[n._v("商城")])])],1)])]),n.isLogin?n._e():r("el-col",{attrs:{span:4}},[r("div",{staticClass:"me-1"},[r("span",{staticClass:"login",on:{click:n.toLoginPage}},[n._v("登录")]),n._v(" / \n        "),r("span",{staticClass:"register",on:{click:n.toRegisterPage}},[n._v("注册")])])]),n.isLogin?r("el-col",{attrs:{span:4}},[r("div",{staticClass:"me-2",on:{click:function(e){return n.toMine()}}},[r("div",{staticClass:"avatar-name"},[r("div",{staticClass:"avatar"},[r("img",{attrs:{src:n.$store.state.userInfo.avatar}})]),r("div",{staticClass:"nickName"},[n._v("\n            "+n._s(n.$store.state.userInfo.nickname)+"\n          ")])]),r("div",{staticClass:"exit",on:{click:function(e){return e.stopPropagation(),n.exit(e)}}},[n._v("\n          退出\n        ")])])]):n._e()],1)],1)},h=[],l=t("c24f"),d=t("c107"),m={name:"g-header",data:function(){return{input:"",userInfo:{},userInfo2:{},headerHotSearchList:d["a"],headerYouLikeList:d["b"]}},watch:{},computed:{isLogin:function(){return this.userInfo=this.$store.state.userInfo,"-1"!=this.userInfo.id&&this.userInfo.id}},methods:{getInfo:function(n){var e=this;Object(l["g"])({user_ID:n}).then(function(n){e.userInfo=n.data.detailMsg.data[0],e.$store.dispatch("getUserInfo",n.data.detailMsg.data[0]),localStorage.setItem("userInfo",JSON.stringify(n.data.detailMsg.data[0]))})},toMine:function(){this.$router.push({name:"Mine",query:{id:this.$store.state.userInfo.id}})},toLoginPage:function(){this.$router.push({name:"Login"})},toRegisterPage:function(){this.$router.push({name:"Register"})},exit:function(){var n=this;this.$confirm("确定退出登录?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){n.$store.state.userInfo={},localStorage.removeItem("userInfo"),n.$message({type:"success",message:"退出登录!"})})}},components:{},mounted:function(){var n=JSON.parse(localStorage.userInfo).id;this.$store.dispatch("getViewUserId",n),this.getInfo(n)}},f=m,b=(t("5e2f"),t("2877")),g=Object(b["a"])(f,p,h,!1,null,null,null),k=g.exports,v=function(){var n=this,e=n.$createElement,t=n._self._c||e;return t("div",{attrs:{id:"g-footer"}},[t("el-row",[t("el-col",{attrs:{span:24}},[t("div",{staticClass:"footer"},[t("p",{staticClass:"copyright"},[n._v("Copyright © 2019 eyemakeup. All rights reserved.")])])])],1)],1)},y=[],E={name:"g-footer",data:function(){return{}},methods:{},components:{},beforeMount:function(){}},x=E,_=(t("ea59"),Object(b["a"])(x,v,y,!1,null,null,null)),w=_.exports,C=(function(n,e,t){var r=[];function o(){u(".heart{width: 10px;height: 10px;position: fixed;background: #f00;transform: rotate(45deg);-webkit-transform: rotate(45deg);-moz-transform: rotate(45deg);}.heart:after,.heart:before{content: '';width: inherit;height: inherit;background: inherit;border-radius: 50%;-webkit-border-radius: 50%;-moz-border-radius: 50%;position: absolute;}.heart:after{top: -5px;}.heart:before{left: -5px;}"),c(),a()}function a(){for(var n=0;n<r.length;n++)r[n].alpha<=0?(e.body.removeChild(r[n].el),r.splice(n,1)):(r[n].y--,r[n].scale+=.004,r[n].alpha-=.013,r[n].el.style.cssText="left:"+r[n].x+"px;top:"+r[n].y+"px;opacity:"+r[n].alpha+";transform:scale("+r[n].scale+","+r[n].scale+") rotate(45deg);background:"+r[n].color);requestAnimationFrame(a)}function c(){var e="function"===typeof n.οnclick&&n.onclick;n.onclick=function(n){e&&e(),i(n)}}function i(n){var t=e.createElement("div");t.className="heart",r.push({el:t,x:n.clientX-5,y:n.clientY-5,scale:1,alpha:1,color:s()}),e.body.appendChild(t)}function u(n){var t=e.createElement("style");t.type="text/css";try{t.appendChild(e.createTextNode(n))}catch(r){t.styleSheet.cssText=n}e.getElementsByTagName("head")[0].appendChild(t)}function s(){return"rgb("+~~(255*Math.random())+","+~~(255*Math.random())+","+~~(255*Math.random())+")"}n.requestAnimationFrame=function(){return n.requestAnimationFrame||n.webkitRequestAnimationFrame||n.mozRequestAnimationFrame||n.oRequestAnimationFrame||n.msRequestAnimationFrame||function(n){setTimeout(n,1e3/60)}}(),o()}(window,document),{name:"App",components:{GHeader:k,GFooter:w}}),P=C,B=(t("5c0b"),Object(b["a"])(P,u,s,!1,null,null,null)),I=B.exports,S=t("8c4f");r["default"].use(S["a"]);var j=new S["a"]({routes:[{path:"/login",name:"Login",component:function(){return t.e("chunk-6ed6f5b5").then(t.bind(null,"9ed6"))}},{path:"/register",name:"Register",component:function(){return t.e("chunk-0c241a14").then(t.bind(null,"d5c2"))}},{path:"/index",name:"Index",component:function(){return t.e("chunk-3617c760").then(t.bind(null,"37f9"))}},{path:"/index/styleMigration",name:"StyleMigration",component:function(){return t.e("chunk-e08c5f80").then(t.bind(null,"2ee1"))}},{path:"/community",name:"Community",component:function(){return Promise.all([t.e("chunk-1daad4d0"),t.e("chunk-38cd7b8b")]).then(t.bind(null,"e412"))}},{path:"/community/postDetails",name:"PostDetails",component:function(){return Promise.all([t.e("chunk-1daad4d0"),t.e("chunk-6a3b3767")]).then(t.bind(null,"0a57"))}},{path:"/searchDetail",name:"MSearchDetail",component:function(){return t.e("chunk-537731fc").then(t.bind(null,"75c6"))}},{path:"/mall",name:"Mall",component:function(){return t.e("chunk-bcb87a64").then(t.bind(null,"3966"))},children:[{path:"/mall/mallIndex",name:"MallIndex",component:function(){return t.e("chunk-625b6fff").then(t.bind(null,"93b5"))}},{path:"/mall/searchDetail",name:"SearchDetail",component:function(){return t.e("chunk-a1f5f32a").then(t.bind(null,"ca31"))}},{path:"/mall/productDetail",name:"ProductDetail",component:function(){return t.e("chunk-9e4f1794").then(t.bind(null,"4094"))}}]},{path:"/mine",name:"Mine",component:function(){return t.e("chunk-70bf2036").then(t.bind(null,"b5b1"))},children:[{path:"/mine/myPosts",name:"MyPosts",component:function(){return t.e("chunk-98a63bf0").then(t.bind(null,"9c50"))}},{path:"/mine/myCollections",name:"MyCollections",component:function(){return t.e("chunk-dbfe0cb6").then(t.bind(null,"0b07"))}},{path:"/mine/myFanses",name:"MyFanses",component:function(){return t.e("chunk-36263f96").then(t.bind(null,"d4f9"))}},{path:"/mine/myFocus",name:"MyFocus",component:function(){return t.e("chunk-76d1be98").then(t.bind(null,"5e2e"))}},{path:"/mine/myLikes",name:"MyLikes",component:function(){return t.e("chunk-0564ea4c").then(t.bind(null,"8685"))}},{path:"/mine/myProfile",name:"MyProfile",component:function(){return t.e("chunk-b9f1237a").then(t.bind(null,"94c8"))}}],redirect:"/mine/myPosts"},{path:"*",redirect:"/index"}]}),M=t("07a4"),A=t("5c96"),L=t.n(A);t("0fae");r["default"].use(L.a);var O=t("77ed"),F=t.n(O);r["default"].use(F.a),r["default"].config.productionTip=!1,r["default"].prototype.$store=M["a"],new r["default"]({router:j,store:M["a"],render:function(n){return n(I)}}).$mount("#app")},"5c0b":function(n,e,t){"use strict";var r=t("5e27"),o=t.n(r);o.a},"5e27":function(n,e,t){},"5e2f":function(n,e,t){"use strict";var r=t("9c3f"),o=t.n(r);o.a},"9c3f":function(n,e,t){},"9d64":function(n,e,t){n.exports=t.p+"img/logo.04303e35.png"},c107:function(n,e,t){"use strict";t.d(e,"a",function(){return r}),t.d(e,"b",function(){return o}),t.d(e,"c",function(){return a}),t.d(e,"d",function(){return c}),t.d(e,"f",function(){return i}),t.d(e,"g",function(){return u}),t.d(e,"e",function(){return s});var r=["学化妆","新妆容","清新妆容","小萝莉","超可爱","气质范儿","","","","","","","","",""],o=["","","","","","","","","","",""],a=["眼影","性价比","眼妆","眼线笔","小清新","网红款","提高肤色","焕发气质","柔软","保湿滋润","女王","顺滑","平价","隐形","蜂蜜眼影","遮瑕","明星同款","保湿无色"],c=["小清新","貂毛美睫","遮瑕","防水抗油","自然持久","蜂蜜眼影","南瓜色","幻彩彩妆盘","明星同款","自然防真"],i={navs1:["沙漠玫瑰","网红款","九色","幻彩彩妆盘","四色","樱桃盘","日落盘","大地色","限量款","南瓜色","白盘哑光","圣诞专款","衰败城市款","蜂蜜眼影","零触感","裸色","限量","海外正品","蓝色冰狼大地","光影星河盘","中国风","珠光大地","柔幻星纱","探险家盘","璀璨星空魅黑","高光盘","绿缘萝","厌世闪粉","大地橘色衰","抖音款","懒人橘","人鱼姬色","孕妇专用","初学者专用","米潮四色","暖色调","敦煌博物馆合作款"],navs2:["广角羽扇S型","自然持久","加密加长","纤长卷翘","炫黑","惊艳打底","猎豹艳炫","魅润","网红款","防水抗油","惊艳特长","双头经典","摩天翘","花样美姬","梦幻泪眼","立体明炯","深邃","抖音同款","梦幻芭蕾大眼款火焰鸟精细","大眼甜心"],navs3:["油皮亲妈","持久","干皮救星","保湿","防晒","遮瑕","平价","网红款","致美榛妍","奶油肌","明星同款","焕发气质","提高肤色","雾感","白金级奢华","亮肤","红BB","水润","象牙白","锁妆","自然色","暖象牙","粉米色","清晰无痕","健康舒缓","磨皮小金盖","黄调","喷头式"],navs4:["自然防真","浓密卷翘","短款","不辣眼","柔软","扁型","貂毛美睫","编织柔软","手工版","日系款","韩款","隐形款","套装","古琦假睫毛","初学者款","学生系","素颜假睫毛","滑垫胶","水貂丝","夜店魅惑妆"],navs5:["限量","保湿滋润","不易脱色","倾慕哑光","烂番茄色","细闪","丝绒持久","蜜染","牛血色","女王","特烈焰幻","小羊皮","萝卜丁","经典正色","子弹头","杨树林","YSL","圣罗兰","纪梵希","正红色","小辣椒","阿玛尼","405","斩男色","法式红","丰泽","套装","孕妇专用","学生党必备","复古玫红","情书少女","缎光","乡思色"],navs6:["持久","浓黑耐汗","不晕染","顺滑","滋色","网红款","自然","非胶笔","如胶似漆","初学者款","易上色","预定款","硬头细速干","黑色","棕色","初学者款","学生款","银管","弹力眼线水笔","升级款","自动款","限量版"],navs7:["平价","控油","强定妆","保湿无色","蜜粉","持久","桃花轻蜜粉","幻彩流星粉球","隐形"]},u=[{image:"http://pymhh35l8.bkt.clouddn.com/recommendList/1.jpg",name:"花西子花隐星穹雕花口持久唇膏",link:"https://item.taobao.com/item.htm?spm=a230r.1.14.15.203c3c0aWCuPza&id=602045541090&ns=1&abbucket=3#detail",price:"129"},{image:"http://pymhh35l8.bkt.clouddn.com/recommendList/2.jpg",name:"MAC/魅可立体绒粉饼提亮粉",link:"https://detail.tmall.com/item.htm?spm=a230r.1.14.1.29d55cb8zqEW2g&id=568721065032&cm_id=140105335569ed55e27b&abbucket=3",price:"340"},{image:"http://pymhh35l8.bkt.clouddn.com/recommendList/3%281%29.jpg",name:"欧莱雅三合一眉笔女不晕染正品",link:"https://detail.tmall.com/item.htm?spm=a230r.1.14.27.3183385cByiqOW&id=520712697378&ns=1&abbucket=3",price:"120"},{image:"http://pymhh35l8.bkt.clouddn.com/recommendList/4.jpg",name:"欧莱雅美眸深邃极细眼线笔",link:"https://detail.tmall.com/item.htm?spm=a230r.1.14.57.5e9372b3vHK8op&id=14542079879&ns=1&abbucket=3&skuId=18175129065",price:"120"},{image:"http://pymhh35l8.bkt.clouddn.com/recommendList/5.jpg",name:"NYX16色眼影盘防水珠光闪粉火",link:"https://detail.tmall.hk/hk/item.htm?id=583132721239&ut_sk=1.XKXEP+BI3HgDAAwGQeiRNdRn_21380790_1571568301765.TaoPassword-QQ.1&sourceType=item&price=119&origin_price=299&suid=3E15036C-2217-4D92-8BB0-4AB7650D6640&un=272bbc6e0cee4e5bacb7a888e4a1d6ac&share_crt_v=1&spm=a2159r.13376460.0.0&sp_tk=JFRYdTVZcWxZWEJmJA==&cpp=1&shareurl=true&short_name=h.eK17uLn&sm=c4f4f0&app=chrome",price:"119"}],s=[{id:"http://pymhh35l8.bkt.clouddn.com/%E5%9B%BE%E7%89%873.png",course:"<h4>欧美风大地色日常妆容教程 | 新年愿望是惊艳全场   </h4>                                                               \n      <h4>眼妆：</h4>\n      <p>光影星河九色眼影盘 04 金沙</p>\n      <p>日常的大地系配色中暗藏几个出彩的珠光和闪片色，不挑眼型的一盘～</p>\n      <p>1.哑光自然棕色Cork大范围打底</p>\n      <p>2.珠光红棕色Broken brick在双眼皮褶皱的后二分之一处和下眼睑晕染，眼尾顺眼下眼睑弧度微挑</p>\n      <p>3.珠光浅金棕色Clay从上眼睑的四分之一处和下眼睑的二分之一处向后小面积晕染，打造层次感</p>\n      <p>4.亮粉铜色Quicksand眼皮中前部提亮</p>\n      <h4>底妆：</h4>\n      <p>无痕持妆粉底液 P20</p>\n      <p>新配方新质地，特别适合油皮和混油皮~</p>\n      <h4>🌟带妆测试：</h4>\n      <p>1.持妆：4-5h的时候纸巾按压一下T区去油，基本上7-8h带妆是OK的</p>\n      <p>2.遮瑕：泛红的痘痘和深色的痘印斑遮不住，一般瑕疵能够遮掉7-80%</p>\n      <p>3.保湿：混干皮没有卡粉，偏油肌肤应该能更贴合，沙漠干皮需要做好保湿打底哦~</p>\n      "},{id:"http://pymhh35l8.bkt.clouddn.com/hhh/%E5%9B%BE%E7%89%871.png",course:'<h4>妆前：</h4>\n        <p>妆前敷了片新入的面膜, 面膜纸比较薄, 敷完了脸上水润润滴, 精华液也挺多哒, 比较保湿, 上妆也更服帖一点啦, 不会卡粉啥的。</p>\n\n        <h4>眼影：</h4>\n        <p>这次画的偏冷色系的眼妆</p>\n        <p>1. 先打底</p>\n        <p>2. 棕色铺眼皮晕染</p>\n        <p>3. 沾少量灰色涂在双眼皮褶内晕染</p>\n        <p>4. 还是刚刚的灰色, 只涂下眼尾的小三角</p>\n        <image fit="cover" src="http://pymhh35l8.bkt.clouddn.com/makeupcourse/%E5%9B%BE%E7%89%878.png"/>\n        <image fit="cover" src="http://pymhh35l8.bkt.clouddn.com/makeupcourse/%E5%9B%BE%E7%89%874.png"/>\n        \n        <h4>眼线：</h4>\n        <p>还是从眼尾拖出一条</p></p>\n        <p>不一样的是,要再沾取深棕色眼影在下眼皮的眼头画眼线</p>\n        <image fit="cover" src="http://pymhh35l8.bkt.clouddn.com/makeupcourse/%E5%9B%BE%E7%89%875.png">\n        </image>\n\n        <h4>卧蚕：</h4>\n        <p>记得用眉笔在卧蚕下方 描一下下</p>\n        <image fit="cover" src="http://pymhh35l8.bkt.clouddn.com/makeupcourse/%E5%9B%BE%E7%89%877.png">\n        </image>\n\n        <h4>腮红：</h4>\n        <p>今天画的是眼下腮红喔</p></p>\n        <p>着重涂在眼周围一圈 画在图上啦</p>\n\n        <h4>口红：</h4>\n        <p>涂跟我们紫色腮红相配一点的</p>\n        <p>果汁感满满的火龙果M503络红绣 玫红色的夏天涂玫红真的敲显白的 哇介个质地涂了hen润</p>\n        <p>薄涂咬唇又hen少女~ 白皮涂了更好看~</p>\n        <image fit="cover" src="http://pymhh35l8.bkt.clouddn.com/makeupcourse/%E5%9B%BE%E7%89%876.png">\n        </image>'},{id:"http://pymhh35l8.bkt.clouddn.com/111123.jpg",course:'<h4>妆前：</h4>\n      <p>妆前敷了片新入的面膜, 面膜纸比较薄, 敷完了脸上水润润滴, 精华液也挺多哒, 比较保湿, 上妆也更服帖一点啦, 不会卡粉啥的。</p>\n\n      <h4>眼影：</h4>\n      <p>这次画的偏冷色系的眼妆</p>\n      <p>1. 先打底</p>\n      <p>2. 棕色铺眼皮晕染</p>\n      <p>3. 沾少量灰色涂在双眼皮褶内晕染</p>\n      <p>4. 还是刚刚的灰色, 只涂下眼尾的小三角</p>\n      <image fit="cover" src="http://pymhh35l8.bkt.clouddn.com/makeupcourse/%E5%9B%BE%E7%89%878.png"/>\n      <image fit="cover" src="http://pymhh35l8.bkt.clouddn.com/makeupcourse/%E5%9B%BE%E7%89%874.png"/>\n      \n      <h4>眼线：</h4>\n      <p>还是从眼尾拖出一条</p></p>\n      <p>不一样的是,要再沾取深棕色眼影在下眼皮的眼头画眼线</p>\n      <image fit="cover" src="http://pymhh35l8.bkt.clouddn.com/makeupcourse/%E5%9B%BE%E7%89%875.png">\n      </image>\n\n      <h4>卧蚕：</h4>\n      <p>记得用眉笔在卧蚕下方 描一下下</p>\n      <image fit="cover" src="http://pymhh35l8.bkt.clouddn.com/makeupcourse/%E5%9B%BE%E7%89%877.png">\n      </image>\n\n      <h4>腮红：</h4>\n      <p>今天画的是眼下腮红喔</p></p>\n      <p>着重涂在眼周围一圈 画在图上啦</p>\n\n      <h4>口红：</h4>\n      <p>涂跟我们紫色腮红相配一点的</p>\n      <p>果汁感满满的火龙果M503络红绣 玫红色的夏天涂玫红真的敲显白的 哇介个质地涂了hen润</p>\n      <p>薄涂咬唇又hen少女~ 白皮涂了更好看~</p>\n      <image fit="cover" src="http://pymhh35l8.bkt.clouddn.com/makeupcourse/%E5%9B%BE%E7%89%876.png">\n      </image>\n      '},{id:"http://pymhh35l8.bkt.clouddn.com/111mmmm.jpg",course:"<h4>可爱感UPPP眉上刘海日系妆容！霓虹杂志同款</p>\n\n      <h4>底妆部分</h4>\n      <p>不仅是粉底液要选对适合自己的，上妆工具也很影响妆感喔！</p>\n      <p>波比布朗清透持妆粉底液，质感轻雾面，适合我的混干肤质</p>\n      <p>上妆JUNO&Co美妆蛋，配合粉底液使用妆感是柔焦无暇的</p>\n      <p>而且遮瑕效果真的很棒，少量粉底液就能用全脸，像鼻翼处的毛孔和轻微闭口用尖尖处修饰遮盖掉就很棒啦！</p>\n      <p>使用JUNO美妆蛋的时候最好用水泡5次，完全浸湿，用纸巾稍微印干用。</p>\n\n      <p>需要快速点按推开，底妆就能细腻无暇了。</p>\n\n      <h4>眉毛部分</h4>\n      <p>先用棕色眉粉填充一遍，再用红色眼影扫上一遍</p>\n      <p>稍微延长眉尾，眉毛粗粗的可爱感提升不少！！！</p>\n\n      <h4>眼妆部分</h4>\n      <p>上眼皮和卧蚕部分各晕染上图中色块，卧蚕真的很重要！</p>\n      <p>用眼线笔自然延长一点点眼尾，刷上睫毛膏</p>\n\n      <h4>腮红部分</h4>\n      <p>眼下大部分晕染连着鼻子中间一起扫上</p>\n      <p>腮红颜色挑选最好是橘色系</p>\n      "},{id:"http://pymhh35l8.bkt.clouddn.com/111%E5%9B%BE%E7%89%871.png",course:"<h4>妆容教程 | 又酷又仙·高冷摩卡色妆容·</h4>\n\n      <h4>底妆 | 兰蔻新持妆粉底液 po-01</h4>\n\n      <h4>眼影 | kATE 骨干眼影 BR-6</h4>\n      <p>KATE骨干眼影已经很出名叻 我开始化妆的时候就用过 这盘是哑光棕调配色 大气不浮夸 很耐看 比较好画出自然又深邃的眼窝 粉质软糯好上色</p>\n\n      <h4>口红 | 完美日记 小红钻107 牛血色</h4>\n\n      <h4>妆前乳 | blank me</h4>\n      <p>略带润色的妆前乳 轻薄好推开 最近一直用这个作为妆前打底 妆容更加服帖持久</p>\n\n      <h4>高光 | 香奈儿限定狮子高光</h4>\n\n      <h4>睫毛膏 | kissme</h4>\n      "},{id:"http://pymhh35l8.bkt.clouddn.com/1.jpg",course:"<h4>韩系女团妆容</h4>\n      <h4>此类韩系浓妆可以抓一些重点：</h4>\n\n      <p>1.眉毛要有眉峰，平眉多韩剧小姐姐风格但我更喜欢这种女团风嘻嘻</p>\n\n      <p>2.眼妆大范围晕染，一定要画内眼线这样结合显得眼睛深邃吸睛，睫毛不够可以假睫毛凑，我上睫毛还好下睫毛全靠画😂扎心了（眼线液笔画）</p>\n\n      <p>3.口红要浓烈！</p>\n\n      <p>欧美妆喜欢巨挑的眉毛和浓的眼妆眼线睫毛，然而经常会出现搭配裸色口红还要把嘴画出边界显得丰满的那种</p>\n\n      <p>韩系就不一样了浓烈的眼妆搭配深色唇色更抓眼球，不会头重脚轻整个妆容比较和谐，日韩系浅唇色多为搭配日常眼妆～</p>\n\n      <h4>🧚‍♀️用到的单品：</h4>\n\n      <p>底妆：bobbibrown虫草</p>\n\n      <p>眉毛：kate 眉粉</p>\n\n      <p>睫毛眼线：kissme</p>\n\n      <p>高光：becca moonstone</p>\n\n      <p>口红：sixtory 25</p>\n      "},{id:"http://pymhh35l8.bkt.clouddn.com/11134.jpg",course:"<h4>橘子果冻女孩|秋日超显白温暖妆容教程</h4>\n\n      <p>玻璃感的眼妆和唇妆是妆容的重点，颜色的选择都特别显白，完全不挑皮，此外还会使用高光打造韩式底妆的光泽感。</P>\n\n      <h4>edr眼妆：Heimish-Coral Essay</h4>\n\n      <p>在韩国闲逛的时候看到这个盘，试了试色就果断买了。配色真是少女感十足，太适合秋天了赶紧拿出来给大家撸个妆，哑光色粉质细腻，亮片色也很有质感。</P>\n\n      <p>画法：用淡珊瑚色铺满眼皮，再用奶橘色加深眼尾，最后用亮片色涂在眼皮中央作为点睛之笔(玻璃感的重点哦)。</P>\n\n      <h4>edr唇妆：colorpop mama+Laction丰唇棒</h4>\n\n      <p>为营造温暖感，选择棕红色唇釉colourpop 的MAMA。这只唇釉本身是哑光质地，超级拔干，奈何颜色真的太显白太好看了！搭配润唇产品都非常合适。\n\n      丰唇棒一直被我用来润唇，偶然发现与口红叠加出的玻璃果冻唇太好看噜，和make up forever 的双头唇釉的用法一样。</P>\n\n      <p>画法：唇釉点涂于唇中用棉棒晕开，涂上丰唇棒，嘟嘟唇一秒呈现！</P>\n\n      <h4>edr高光：hourglass 色号diffused light</h4>\n\n      <p>腮红用的是眼影盘中的淡珊瑚色，扫在太阳穴至眼下，轻轻带过鼻梁营造可爱的妆感。</P>\n\n      <h4>edr遮瑕 美宝莲橡皮擦100</h4>\n\n      <h4>edr定妆 香堤卡粉饼</h4>\n\n      <h4>edr眼妆腮红 Heimish-Coral Essay</h4>\n\n      <h4>edr睫毛膏 Kate睫毛打底➕恋爱魔镜</h4>\n\n      <h4>edr唇妆 colorpop mama+Laction丰唇棒</h4>\n\n      <h4>edr高光 hourglass 色号diffused light</h4>\n      "},{id:"",course:"<h4>眼妆教程 | ✨单眼皮也能驾驭韩系女团妆</h4>\n\n      <h4>眼影 | oden's eye Freja仙女盘</h4>\n      <p>新晋仙女网红盘 六色哑光六色珠光</p>\n      <p>没有一块是用不到的颜色 太实用了</p>\n      <p>色彩饱和度超级高 非常好上色 尤其是左下角的橙色和玫色 绝了简直</p>\n      <p>粉质软糯 在手臂上的延展性非常好 上眼也不会结块 我爱了</p>\n      <p>秋冬必备色系它都有了 还不赶紧囤起来！</p>\n\n      <h4>高光 | oden's eye 四色高光盘</h4>\n      <p>这盘的光泽感相当自然</p>\n      <p>搭配不同的妆容可以用不同颜色的高光</p>\n\n      <h4>口红 | Colourpop evilqueen</h4>\n      <p>cpp的正红色真的好美 无人能敌</p>\n      <p>这支带一点点玫红调 太好看了5555</p>\n\n      <h4>粉底 | Hera 17N1</h4>\n      <p>被sobong种草买的 事实证明 他真的太好用了</p>\n      <p>遮暇力巨好！！而且后期会和肌肤融合的特别棒！一天都不怎么脱妆！</p>\n\n      <h4>腮红 | Zenn win win</h4>\n      <p>可爱的嫩粉色</p>\n      "}]},c24f:function(n,e,t){"use strict";t.d(e,"i",function(){return c}),t.d(e,"h",function(){return i}),t.d(e,"a",function(){return u}),t.d(e,"j",function(){return s}),t.d(e,"f",function(){return p}),t.d(e,"d",function(){return h}),t.d(e,"c",function(){return l}),t.d(e,"b",function(){return d}),t.d(e,"e",function(){return m}),t.d(e,"g",function(){return f}),t.d(e,"k",function(){return b});var r=t("bc3a"),o=t.n(r),a=t("e490"),c=function(n){return o()({url:a["a"]+"/myuser/myuser/insertSelective",method:"post",data:n})},i=function(n){return o()({url:a["a"]+"/user/user/login",method:"post",data:n})},u=function(n){return o()({url:a["a"]+"/relation/relation/insertSelective",method:"post",data:n})},s=function(n){return o()({url:a["a"]+"/relation/relation/deleteByFansIdAndFollowsId",method:"delete",params:n})},p=function(n){return o()({url:a["a"]+"/community/community/getUsersAllPosts",method:"get",params:n})},h=function(n){return o()({url:a["a"]+"/community/community/getAllPostsFavorite",method:"get",params:n})},l=function(n){return o()({url:a["a"]+"/mall/mall/getAllCommodityFavorites",method:"get",params:n})},d=function(n){return o()({url:a["a"]+"/user/user/getAllFans",method:"get",params:n})},m=function(n){return o()({url:a["a"]+"/user/user/getAllFollows",method:"get",params:n})},f=function(n){return o()({url:a["a"]+"/user/user/getUserById",method:"get",params:n})},b=function(n){return o()({url:a["a"]+"/myuser/myuser/updateSelective",method:"post",data:n})}},d192:function(n,e,t){},e490:function(n,e,t){"use strict";t.d(e,"a",function(){return r});var r="http://eyemakeup.e2d1f38a-d663-43e3-b62e-3eb86df16574.dev.app.yyuap.com/eyetouch-seentao-be"},ea59:function(n,e,t){"use strict";var r=t("d192"),o=t.n(r);o.a}});