<template>
  <VCard class="mx-auto pa-12 pb-8" elevation="4" rounded="lg">

    <div class="text-subtitle-1 text-medium-emphasis">강의 제목</div>
    <VTextField v-model="className" density="compact" variant="outlined"></VTextField>

    <div class="text-subtitle-1 text-medium-emphasis">강사 이름</div>
    <VTextField v-model="gosuName" density="compact" variant="outlined"></VTextField>

    <div class="text-subtitle-1 text-medium-emphasis">강의 설명</div>
    <VTextField v-model="description" density="compact" variant="outlined"></VTextField>

    <div class="text-subtitle-1 text-medium-emphasis">사전평가 문항</div>
    <VRow>
      <VCol cols="9">
        <VTextField v-model="preExamQuestion" label="문제" density="compact" variant="outlined"></VTextField>
      </VCol>
      <VCol>
        <VTextField v-model="preExamAnswer" label="답" density="compact" variant="outlined"></VTextField>
      </VCol>
      <VCol cols="1">
      <VBtn color="primary" @click="addPreExam">추가</VBtn>
    </VCol>
    </VRow>

    <ul>
      <li v-for="(item, index) in preExam" :key="index">
        <span style="font-weight: bold;">문제</span> : {{ JSON.parse(item).question }}, <span style="font-weight: bold;">답</span> : {{ JSON.parse(item).answer }}
      </li>
    </ul>

    <div class="text-subtitle-1 text-medium-emphasis">사후평가 문항</div>
    <VRow>
      <VCol cols="9">
        <VTextField v-model="afterExamQuestion" label="문제" density="compact" variant="outlined"></VTextField>
      </VCol>
      <VCol>
        <VTextField v-model="afterExamAnswer" label="답" density="compact" variant="outlined"></VTextField>
      </VCol>
      <VCol cols="1">
          <VBtn color="primary" @click="addAfterExam">추가</VBtn>
      </VCol>
    </VRow>
    <ul>
      <li v-for="(item, index) in afterExam" :key="index">
        <span style="font-weight: bold;">문제</span> : {{ JSON.parse(item).question }}, <span style="font-weight: bold;">답</span> : {{ JSON.parse(item).answer }}
      </li>
    </ul>


    <VBtn class="mb-8 mt-8" color="gray" size="large" variant="tonal" block @click="classCreate">
      강의 개설
    </VBtn>

    <VBtn class="mb-8 mt-8" color="gray" size="small" variant="tonal" block @click="generateRandomData">
      테스트용 랜덤 강의 개설
    </VBtn>


  </VCard>
</template>

<script setup>
import { ref } from 'vue';
import { useRouter } from 'vue-router';
import apiClient from '@/plugins/axios';
import { faker } from '@faker-js/faker';

const router = useRouter();


const className = ref("");
const gosuName = ref("");
const description = ref("");
const preExam = ref([]);
const afterExam = ref([]);
const preExamQuestion = ref("");
const preExamAnswer = ref("");
const afterExamQuestion = ref("");
const afterExamAnswer = ref("");


const addPreExam = () => {
  if (preExamQuestion.value.trim() !== "" && preExamAnswer.value.trim() !== "") {
    const preExamItem = JSON.stringify({ question: preExamQuestion.value, answer: preExamAnswer.value });
    preExam.value.push(preExamItem);
    preExamQuestion.value = "";
    preExamAnswer.value = "";
  }
};

const addAfterExam = () => {
  if (afterExamQuestion.value.trim() !== "" && afterExamAnswer.value.trim() !== "") {
    const afterExamItem = JSON.stringify({ question: afterExamQuestion.value, answer: afterExamAnswer.value });
    afterExam.value.push(afterExamItem);
    afterExamQuestion.value = "";
    afterExamAnswer.value = "";
  }
};

const classCreate = () => {
  apiClient.post('gosuClasses', {
      className: className.value,
      gosuName: gosuName.value,
      description: description.value,
      preExam: preExam.value,
      afterExam: afterExam.value,
      personCount: 0
  })
  .then(response => {
    alert(className.value + " 강의를 개설 성공했습니다.");
    router.push("/");
  })
  .catch(error => {
    console.error('Error posting data:', error);
  });

}
const generateRandomData = async () => {
  const randomData = [];

  for (let i = 0; i < 10; i++) {
    const className = faker.lorem.words(3);
    const gosuName = faker.person.fullName();
    const description = faker.lorem.sentence();
    const preExam = Array.from({ length: 3 }, () => JSON.stringify({
      question: faker.lorem.sentence(),
      answer: faker.lorem.word()
    }));
    const afterExam = Array.from({ length: 3 }, () => JSON.stringify({
      question: faker.lorem.sentence(),
      answer: faker.lorem.word()
    }));

    try {
      const response = await apiClient.post('gosuClasses', {
      className: className,
      gosuName: gosuName,
      description: description,
      preExam: preExam,
      afterExam: afterExam,
      personCount: 0
  });
      console.log(`${className} 강의 개설 성공:`, response.data);
    } catch (error) {
      console.error(`Error posting ${className}:`, error);
    }
  }


};
</script>

<style lang="scss" scoped>
.v-card {
  width: 100%;
  max-width: 900px;
}
</style>
