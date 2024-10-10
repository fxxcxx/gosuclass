<template>
<v-navigation-drawer app>


    <v-list dense>
      <v-list-item @click="">
        <v-list-item-title>과정 안내</v-list-item-title>
      </v-list-item>
      <v-list-item @click="">
        <v-list-item-title>과정 게시판</v-list-item-title>
      </v-list-item>
      <v-list-item @click="">
        <v-list-item-title>학습 일정</v-list-item-title>
      </v-list-item>
      <v-list-item @click="">
        <v-list-item-title>학습 콘텐츠</v-list-item-title>
      </v-list-item>
    </v-list>
  </v-navigation-drawer>

  <v-container>
    <v-row>
      <v-col>
    <v-sheet
      width="550"
      height="300"
      color="grey-lighten-2"
      class="d-flex align-center justify-center"
    >
      <span class="text-h6">이미지 준비중입니다</span>
    </v-sheet>
    </v-col>
    <v-col>
    <v-table>
      <template v-slot:default>
        <tbody>
          <tr>
            <td>학습명</td>
            <td>{{ classDetail.className }}</td>
          </tr>
          <tr>
            <td>학습분야</td>
            <td>-</td>
          </tr>
          <tr>
            <td>학습난이도</td>
            <td>-</td>
          </tr>
          <tr>
            <td>학습 내용</td>
            <td>{{ classDetail.description }}</td>
          </tr>
          <tr>
            <td>고수명</td>
            <td>{{ classDetail.gosuName }}</td>
          </tr>
          <tr>
            <td>수강인원</td>
            <td>{{ classDetail.personCount }}</td>
          </tr>
        </tbody>
      </template>
    </v-table>
    </v-col>
  </v-row>
  <v-row>
    <v-col class="d-flex justify-start">
      <v-btn v-if="reg_status != '신청됨'"  color="primary" class="me-2" @click="applyClass(id)">수강 신청</v-btn>
      <v-btn v-if="reg_status == '신청됨'"  color="primary" class="me-2" @click="">사전 평가</v-btn>
      <v-btn color="warning" class="me-2" @click="cancelClass(id)">수강 취소</v-btn>
    </v-col>

    <v-spacer></v-spacer>
    <v-col class="d-flex justify-end">
      <v-btn color="error" @click="deleteClass(id)">강의 삭제</v-btn>
    </v-col>
  </v-row>
  </v-container>
</template>

<script setup>
import { useRoute, useRouter } from 'vue-router'


const router = useRouter();

const route = useRoute()
const id = route.params.id
import apiClient from '@/plugins/axios';

const classDetail = ref({});

async function getGosuClass(id) {
  const response = await apiClient.get(`gosuClasses/${id}`);
  classDetail.value = response.data;
  console.log(classDetail.value);
  return response.data;
}
onMounted(() => {
  getGosuClass(id);
});

const registration = ref({});
const reg_status = ref('');
async function getRegistration(id) {
  const response = await apiClient.get(`registrations/${id}`, {

  });
  registration.value = response.data;
  console.log(registration.value);
  reg_status.value = registration.value._embedded.registrations[0].status;
  console.log(reg_status.value);
  return response.data;
}
onMounted(() => {
  getRegistration(id)
});

async function deleteClass(id) {
  try {
    const response = await apiClient.delete(`gosuClasses/${id}`);
    console.log(response);
    if (response.status === 204) {
      alert('강의가 성공적으로 삭제되었습니다.');
      router.push('/apply-class');
    } else {
      alert('강의 삭제에 실패했습니다. 다시 시도해주세요.');
    }
  } catch (error) {
    console.error('강의 삭제 중 오류 발생:', error);
    alert('강의 삭제 중 오류가 발생했습니다. 나중에 다시 시도해주세요.');
  }
}

async function applyClass(id) {
  try {
    const response = await apiClient.post(`registrations`, {
      classId: id,
      status: "신청됨"
    });
    console.log(response);
    if (response.status === 201) {
      alert('강의 수강 신청이 완료되었습니다.');
    } else {
      alert('강의 수강 신청에 실패했습니다. 다시 시도해주세요.');
    }
  } catch (error) {
    console.error('강의 수강 신청 중 오류 발생:', error);
    alert('강의 수강 신청 중 오류가 발생했습니다. 나중에 다시 시도해주세요.');
  }
}

async function cancelClass(id) {
  try {
    const response = await apiClient.delete(`registrations`);
    console.log(response);
  } catch (error) {
    console.error('강의 수강 취소 중 오류 발생:', error);
    alert('강의 수강 취소 중 오류가 발생했습니다. 나중에 다시 시도해주세요.');
  }
}
</script>

<style scoped>
/* 스타일을 여기에 추가하세요 */
</style>
