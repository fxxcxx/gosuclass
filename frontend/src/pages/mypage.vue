<template>

<VContainer>
  <VRow>
    <VCol class="d-flex justify-start">
      <span class="text-h6">✏ 내가 신청한 강의</span>
    </VCol>
  </VRow>
  <VRow>
    <VCol class="d-flex justify-start overflow-x-auto">
      <div class="d-flex">
        <template v-for="(cl, index) in classes">
          <ClassCard2 @click="goToClassDetail(index)" :imageSrc="'https://picsum.photos/seed/' + index+100 + '/550/250'" :title="cl.className" class="me-4" />
        </template>
      </div>
    </VCol>
  </VRow>
  <VRow>
    <VCol class="d-flex justify-start">
      <span class="text-h6">📒 내가 개설한 강의</span>
    </VCol>
  </VRow>
  <VRow>
    <VCol class="d-flex justify-start overflow-x-auto">
      <div class="d-flex">
        <template v-for="(cl, index) in classes">
          <ClassCard2 @click="goToClassDetail(index)" :imageSrc="'https://picsum.photos/seed/' + index + '/550/250'" :title="cl.className" class="me-4" />
        </template>
      </div>
    </VCol>
  </VRow>
  </VContainer>
</template>

<script setup>

import { ref, onMounted } from 'vue';
import apiClient from '@/plugins/axios';
import { useRouter } from 'vue-router';

const router = useRouter();

const imageSrc = ref();

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

const goToClassDetail = (id) => {
  router.push(`/class-detail/${id}`);
};
</script>

<style lang="scss" scoped>
.v-container {
  max-width: 1400px;
}

.text-h6 {
  font-weight: 700;
}

.class-card-list {
  display: flex;
  flex-wrap: wrap;
  gap: 20px;
  justify-content: center;
}
</style>
