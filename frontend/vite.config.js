import { fileURLToPath, URL } from "node:url";

import { defineConfig } from "vite";
import vue from "@vitejs/plugin-vue";

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue()],
  resolve: {
    alias: {
      "@": fileURLToPath(new URL("./src", import.meta.url)),
    },
  },
  build: {
    outDir: "../src/main/resources/static",
  }, // 빌드 결과물이 생성되는 경로
  server: {
    proxy: {
      "/api": "http://localhost:80",
    }, // proxy 설정
  },
});
