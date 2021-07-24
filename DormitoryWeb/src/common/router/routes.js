const homechild = [
    {
        path:'/user/sys_admin',
        name:'userSys_admin',
        component: () => import('@/views/user/sys_admin.vue')
    },
    {
        path:'/user/admintousu',
        name:'useradmintousu',
        component: () => import('@/views/user/admintousu.vue')
    },
    {
        path:'/user/student',
        name:'userStudent',
        component: () => import('@/views/user/student.vue')
    },
    {
        path:'/user/admin',
        name:'userAdmin',
        component: () => import('@/views/user/admin.vue')
    },
    {
        path:'/user/adminDorm',
        name:'userAdminDorm',
        component: () => import('@/views/user/adminDorm.vue')
    },
    {
        path:'/user/adminStu',
        name:'userAdminStu',
        component: () => import('@/views/user/adminStu.vue')
    },
    {
        path:'/user/repairer',
        name:'userRepairer',
        component: () => import('@/views/user/repairer.vue')
    },
    {
        path:'/user/deliever',
        name:'userdeliever',
        component: () => import('@/views/user/deliever.vue')
    },
    {
        path:'/user/teacher',
        name:'userteacher',
        component: () => import('@/views/user/teacher.vue')
    },
    {
        path:'/user/scorer',
        name:'userscorer',
        component: () => import('@/views/user/scorer.vue')
    },

    {
        path:'/messageinfo/studentinfo',
        name:'studentinfo',
        component: () => import('@/views/messageinfo/studentinfo.vue')
    },

    {
        path:'/messageinfo/delieverrecord',
        name:'delieverrecord',
        component: () => import('@/views/messageinfo/delieverrecord.vue')
    },

    {
        path:'/messageinfo/repairrecord',
        name:'repairrecord',
        component: () => import('@/views/messageinfo/repairrecord.vue')
    },

    {
        path:'/messageinfo/tousurecord',
        name:'tousurecord',
        component: () => import('@/views/messageinfo/tousurecord.vue')
    },
    {
        path:'/messageinfo/userinfo',
        name:'userinfo',
        component: () => import('@/views/messageinfo/userinfo.vue')
    },
    {
        path:'/messageinfo/userinfo2',
        name:'userinfo2',
        component: () => import('@/views/messageinfo/userinfo2.vue')
    },
    {
        path:'/messageinfo/userinfo3',
        name:'userinfo3',
        component: () => import('@/views/messageinfo/userinfo3.vue')
    },
    {
        path:'/messageinfo/userinfo4',
        name:'userinfo4',
        component: () => import('@/views/messageinfo/userinfo4.vue')
    },
    {
        path:'/messageinfo/allinfo',
        name:'allinfo',
        component: () => import('@/views/messageinfo/allinfo.vue')
    },
    {
        path:'/messageinfo/changerecord',
        name:'changerecord',
        component: () => import('@/views/messageinfo/changerecord.vue')
    },
    {
        path:'/security/changedorm',
        name:'changedorm',
        component: () => import('@/views/security/changedorm.vue')
    },
    
];

const loginchild = [
    {
        path: '/security/login',
        name: 'Login',
        component: () => import('@/views/security/login.vue')
    },
    {
        path: '/security/loginByNetid',
        name: 'LoginNetId',
        component: () => import('@/views/security/loginByNetid.vue')
    },
]


const routes = [

    //访问路由“/”,自动重定向到"/home"
    {
        path: '/',
        redirect: '/security/login'
    },
    {
        path:'/security/register',
        name:'Register',
        component: () => import('@/views/security/register.vue')
    },
    {
        path:'/security/loginHome',
        name:'loginHome',
        component: () => import('@/views/security/loginHome.vue'),
        children:loginchild
    },
    {
        path:'/security/changePwd',
        name:'changePwd',
        component: () => import('@/views/security/changePwd.vue')
    },
    {
        path: '/home',
        name: 'Home',
        component: () => import('@/views/home/home.vue'),
        children:homechild
    },
    {
        path: '/404',
        name: "NotFound",
        component: () => import('@/views/404.vue')
    },
    {
        path:'/security/complete',
        name:'securityComplete',
        component: () => import('@/views/security/complete.vue')
    },

    

];

export const existsRoute = (path) => {
    for (let i = 0; i < routes.length; i++) {
        const r = routes[i];
        if (r.path == path) {
            return true;
        }
        if (r.children && r.children.length) {
            for (let k = 0; k < r.children.length; k++) {
                const sr = r.children[k];
                if (sr.path == path) {
                    return true;
                }
            }
        }
    }
    return false;
};

export default routes;