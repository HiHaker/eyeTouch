(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-36263f96"],{3983:function(t,s,e){"use strict";var a=function(){var t=this,s=t.$createElement,e=t._self._c||s;return e("div",{attrs:{id:"userList"}},t._l(t.arrayList,function(s){return e("div",{staticClass:"userList-li"},[e("div",{staticClass:"user"},[e("div",{staticClass:"userInfo"},[e("div",{staticClass:"avatar"},[e("img",{attrs:{src:s.avatar}})]),e("div",{staticClass:"name-signature"},[e("div",{staticClass:"name"},[t._v(t._s(s.nickname.slice(0,6)))]),e("div",{staticClass:"signature"},[t._v(t._s(s.profile.slice(0,8)))])])]),e("div",{staticClass:"attent"},[e("el-button",{attrs:{size:"mini",type:"primary"}},[t._v("关注TA")])],1)])])}),0)},i=[],n={name:"userList",data:function(){return{}},props:{arrayList:Array}},r=n,u=(e("b885"),e("2877")),c=Object(u["a"])(r,a,i,!1,null,null,null);s["a"]=c.exports},5530:function(t,s,e){"use strict";var a=e("8312"),i=e.n(a);i.a},8312:function(t,s,e){},8575:function(t,s,e){},b885:function(t,s,e){"use strict";var a=e("8575"),i=e.n(a);i.a},d4f9:function(t,s,e){"use strict";e.r(s);var a=function(){var t=this,s=t.$createElement,e=t._self._c||s;return e("div",{attrs:{id:"detail"}},[e("div",{staticClass:"title"},[t._v("我的粉丝")]),e("user-list",{attrs:{arrayList:t.userList}})],1)},i=[],n=e("3983"),r=e("c24f"),u={name:"myFanses",data:function(){return{user_ID:this.$store.state.userInfo.id,userList:[],userInfo:{}}},methods:{getMyFanses:function(){var t=this;Object(r["e"])({user_ID:this.$route.query.id}).then(function(s){t.userList=s.data.detailMsg.data})}},components:{UserList:n["a"]},created:function(){this.getMyFanses()},beforeMount:function(){document.documentElement.scrollTop=0}},c=u,l=(e("5530"),e("2877")),o=Object(l["a"])(c,a,i,!1,null,null,null);s["default"]=o.exports}}]);