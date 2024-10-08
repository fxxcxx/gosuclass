<template>
  <VCard class="mx-auto pa-12 pb-8" elevation="4" rounded="lg">
    <div class="text-subtitle-1 text-medium-emphasis">강의 제목</div>
    <VTextField v-model="classTitle" density="compact" variant="outlined"></VTextField>

    <div class="text-subtitle-1 text-medium-emphasis">강의 설명</div>
    <VTextField v-model="classDescription" density="compact" variant="outlined"></VTextField>

    <div class="text-subtitle-1 text-medium-emphasis">기타1</div>
    <VTextField v-model="classEtc1" density="compact" variant="outlined"></VTextField>

    <div class="text-subtitle-1 text-medium-emphasis">기타2</div>
    <VTextField v-model="classEtc2" density="compact" variant="outlined"></VTextField>



    <VBtn class="mb-8" color="gray" size="large" variant="tonal" block @click="classCreate">
      Log In
    </VBtn>


  </VCard>
</template>

<script setup>
import { ref } from 'vue';
import { useRouter } from 'vue-router';

const router = useRouter();


const classTitle = ref("");
const classDescription = ref("");
const classEtc1 = ref("");
const classEtc2 = ref("");

const classCreate = () => {
  console.log(classTitle.value, classDescription.value, classEtc1.value, classEtc2.value);
  alert("강의 생성 완료 \n" + classTitle.value + "\n" + classDescription.value + "\n" + classEtc1.value + "\n" + classEtc2.value);
  router.push("/");
}

</script>

<style lang="scss" scoped>
.v-card {
  width: 100%;
  max-width: 900px;
}
</style>
