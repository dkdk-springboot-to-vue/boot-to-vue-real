import { createRouter, createWebHistory } from "vue-router";
import TheMainView from "../views/TheMainView.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "main",
      component: TheMainView,
    },
    {
      path: "/board",
      name: "board",
      component: () => import("../views/TheBoardView.vue"),
      redirect: { name: "article-list" },
      children: [
        {
          path: "list",
          name: "article-list",
          component: () => import("@/components/board/BoardList.vue"),
        },
        {
          path: "view/:articleno",
          name: "article-view",
          component: () => import("@/components/board/BoardDetail.vue"),
        },
      ],
    },

    {
      path: "/member",
      name: "member",
      component: () => import("../views/TheMemberView.vue"),
      redirect: { name: "member-register" },
      children: [
        {
          path: "register",
          name: "member-register",
          component: () => import("@/components/member/MemberRegister.vue"),
        },
        {
          path: "login",
          name: "member-login",
          component: () => import("@/components/member/MemberLogin.vue"),
        },
        {
          path: "logined",
          name: "member-logined",
          component: () => import("@/components/member/MemberLogined.vue"),
        },
        {
          path: "find",
          name: "member-find",
          component: () => import("@/components/member/MemberFind.vue"),
        },
      ],
    },
  ],
});

export default router;
