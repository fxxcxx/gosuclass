<template>

<p v-for="i in classes"> {{ i.className }}, {{ i.gosuName }}, {{ i.description }}
</p>
<p></p>
</template>

<script setup>

import { ref, onMounted } from 'vue';
import apiClient from '@/plugins/axios';

const classes = ref([]);

const fetchClasses = async () => {
  try {
    const response = await apiClient.get('/gosuClasses');
    classes.value = response.data._embedded.gosuClasses;
  } catch (error) {
    console.error('클래스 데이터를 가져오는 중 오류 발생:', error);
  }
};

onMounted(() => {
  fetchClasses();
});

</script>
