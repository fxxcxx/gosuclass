<template>
  <v-data-table :headers="headers" :items="items" @dblclick:row="handleRowClick"></v-data-table>
</template>

<script setup>
import apiClient from '@/plugins/axios';
import { useRouter } from 'vue-router';

const router = useRouter();

const items = ref([]);
const headers = ref([
  { title: 'No', value: 'classId', align: 'start', sortable: false, visible: false },
  { title: '분야', value: 'category' },
  { title: '난이도', value: 'difficulty' },
  { title: '클래스명', value: 'className' },
  { title: '고수명', value: 'gosuName' },
  { title: '모집기간', value: 'recruitmentPeriod' },
  { title: '학습기간', value: 'learningPeriod' },
  { title: '학습시간', value: 'learningTime' },
  { title: '상태', value: 'status' }
]);

const handleRowClick = (item, row) => {
  console.log('Row clicked:', item);
  console.log('row:', row.internalItem.raw.classId);
  router.push(`/class-detail/${row.internalItem.raw.classId}`);
};

const fetchItems = async () => {
  try {
    const response = await apiClient.get('/gosuClasses');



    for (const item of response.data._embedded.gosuClasses) {
      const classId = item._links.self.href.split('/').pop();

      const categories = ['프로그래밍', '디자인', '마케팅', '외국어', '음악', '요리', '운동', '재테크'];
      const randomCategory = categories[Math.floor(Math.random() * categories.length)];

      const difficulties = ['상', '중', '하'];
      const randomDifficulty = difficulties[Math.floor(Math.random() * difficulties.length)];

      const currentDate = new Date();
      const randomDays = Math.floor(Math.random() * 30) + 1; // 1일부터 30일 사이의 랜덤한 일수
      const endDate = new Date(currentDate.getTime() + randomDays * 24 * 60 * 60 * 1000);
      const formattedEndDate = `~${endDate.getFullYear()}-${String(endDate.getMonth() + 1).padStart(2, '0')}-${String(endDate.getDate()).padStart(2, '0')}`;
      const randomRecruitmentPeriod = formattedEndDate;

      // 학습 기간 랜덤 생성
      const learningStartDate = new Date(endDate.getTime() + 24 * 60 * 60 * 1000); // 모집 종료일 다음날부터 시작
      const learningDuration = Math.floor(Math.random() * 60) + 30; // 30일부터 90일 사이의 랜덤한 학습 기간
      const learningEndDate = new Date(learningStartDate.getTime() + learningDuration * 24 * 60 * 60 * 1000);

      const formatDate = (date) => {
        return `${date.getFullYear()}-${String(date.getMonth() + 1).padStart(2, '0')}-${String(date.getDate()).padStart(2, '0')}`;
      };

      const randomLearningPeriod = `${formatDate(learningStartDate)}~${formatDate(learningEndDate)}`;

      // 학습 시간 랜덤 생성
      // 학습 시간 랜덤 생성 (100시간 이하)
      const randomLearningTime = Math.floor(Math.random() * 100) + 1;

      // 상태 랜덤 생성
      const statuses = ['모집중', '모집완료'];
      const randomStatus = statuses[Math.floor(Math.random() * statuses.length)];

      items.value.push({
        classId: classId,
        category: randomCategory,
        difficulty: randomDifficulty,
        className: item.className,
        gosuName: item.gosuName,
        recruitmentPeriod: randomRecruitmentPeriod,
        learningPeriod: randomLearningPeriod,
        learningTime: randomLearningTime,
        status: randomStatus
      });
    }
  } catch (error) {
    console.error('Error fetching items:', error);
  }
};

onMounted(() => {
  fetchItems();
});

  // const items = [
  //   {
  //     분야: 'African Elephant',
  //     난이도: 'Loxodonta africana',
  //     클래스명: 'Herbivore',
  //     고수명: 'Savanna, Forests',
  //     모집기간: 'Savanna, Forests',
  //     학습기간: 'Savanna, Forests',
  //     학습시간: 'Savanna, Forests',
  //     상태: "모집중"
  //   },
  //   // ... more items
  // ]
</script>
