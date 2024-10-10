// src/plugins/axios.js
import axios from 'axios';

const apiClient = axios.create({
  baseURL: 'http://20.249.197.95:8080',  // 공통 base URL
  headers: {
    'Content-Type': 'application/json',
  },
});

export default apiClient;
