import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vite.dev/config/
export default defineConfig({
  plugins: [vue()],
  // 固定代理写法
  server: {
    proxy: {
      '/api': {
        target: 'http://localhost:8080',
      }
    }
  }
})
