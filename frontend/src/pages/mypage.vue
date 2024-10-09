<template>

<p v-for="i in classes"> {{ i.className }}, {{ i.gosuName }}, {{ i.description }}
</p>
<p></p>
</template>

<script setup>

import { ref, onMounted } from 'vue';

const classes = ref([]);

const fetchClasses = async () => {
  try {
    const response = await fetch('https://20.249.197.95/gosuClasses');
    if (!response.ok) {
      throw new Error('클래스 데이터를 가져오는 중 오류 발생');
    }
    const data = await response.json();
    classes.value = data._embedded.gosuClasses;
  } catch (error) {
    console.error('클래스 데이터를 가져오는 중 오류 발생:', error);
  }
};

onMounted(() => {
  fetchClasses();
});

</script>
