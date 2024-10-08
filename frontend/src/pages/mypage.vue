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
    const response = await fetch('https://8088-fxxcxx-gosuclass-wchc49249p0.ws-us116.gitpod.io/gosuClasses');
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
