import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
  routes: [
    // 登录页
    {
      path: '/login',
      name: 'Login',
      component: () => import('@/views/login')
    },
    // 注册页
    {
      path: '/register',
      name: 'Register',
      component: () => import('@/views/register')
    },
    // 首页
    {
      path: '/index',
      name: 'Index',
      component: () => import('@/views/index')
    },
    // 图像风格迁移页
    {
      path: '/index/styleMigration',
      name: 'StyleMigration',
      component: () => import('@/views/index/styleMigration')
    },
    // 社区页
    {
      path: '/community',
      name: 'Community',
      component: () => import('@/views/community')
    },
    // 帖子详情页
    {
      path: '/community/postDetails',
      name: 'PostDetails',
      component: () => import('@/views/community/postDetails')
    },
    // 商城页
    {
      path: '/mall',
      name: 'Mall',
      component: () => import('@/views/mall'),
      children: [
        // 商城首页
        {
          path: '/mall/mallIndex',
          name: 'MallIndex',
          component: () => import('@/views/mall/mallIndex')
        },
        // 搜索详情页
        {
          path: '/mall/searchDetail',
          name: 'SearchDetail',
          component: () => import('@/views/mall/searchDetail')
        },
        // 商品详情页
        {
          path: '/mall/productDetail',
          name: 'ProductDetail',
          component: () => import('@/views/mall/productDetail')
        }
      ]
    },
    // 个人中心页
    {
      path: '/mine',
      name: 'Mine',
      component: () => import('@/views/mine'),
      children: [
        // 我的帖子页
        {
          path: '/mine/myPosts',
          name: 'MyPosts',
          component: () => import('@/views/mine/myPosts')
        },
        // 我的收藏页
        {
          path: '/mine/myCollections',
          name: 'MyCollections',
          component: () => import('@/views/mine/myCollections')
        },
        // 我的粉丝页
        {
          path: '/mine/myFanses',
          name: 'MyFanses',
          component: () => import('@/views/mine/myFanses')
        },
        // 我的关注页
        {
          path: '/mine/myFocus',
          name: 'MyFocus',
          component: () => import('@/views/mine/myFocus')
        },
        // 我的喜欢页
        {
          path: '/mine/myLikes',
          name: 'MyLikes',
          component: () => import('@/views/mine/myLikes')
        },
        // 我的资料页
        {
          path: '/mine/myProfile',
          name: 'MyProfile',
          component: () => import('@/views/mine/myProfile')
        }
      ]
    },
    {
      path: '*',
      redirect: '/index'
    }
  ]
})
