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
      <v-btn v-if="!isApplied"  color="primary" class="me-2" @click="applyClass(id)">수강 신청</v-btn>
      <v-btn v-else-if="!isExamApplied" color="primary" class="me-2" @click="dialog = true">사전 평가</v-btn>
      <v-btn v-else color="primary" class="me-2" disabled>사전 평가 제출완료</v-btn>
      <v-btn color="warning" class="me-2" @click="cancelClass(id)">수강 취소</v-btn>
    </v-col>

    <v-spacer></v-spacer>
    <v-col class="d-flex justify-end">
      <v-btn color="green" class="me-2" @click="">수강생 정보</v-btn>

      <v-btn color="error" @click="deleteClass(id)">강의 삭제</v-btn>
    </v-col>
  </v-row>
  </v-container>

  <v-dialog
      v-model="dialog"
      width="auto"
    >
      <v-card
        max-width="1000"
        prepend-icon="mdi-check-circle"
        title="사전평가"
      >
      <div class="pa-3">
        <template v-for="i in classDetail.preExam">
          <v-row>
            <v-col cols="12">
              <p>문제</p>
              <h3>
                {{ JSON.parse(i).question }}
              </h3>
            </v-col>
            <v-col cols="12">
              <p>답</p>
              <VTextField>

              </VTextField>
            </v-col>
          </v-row>
        </template>
      </div>
        <template v-slot:actions>
          <v-btn
            class="ms-auto"
            color="success"
            text="제출"
            @click="examApply()"
          ></v-btn>
        </template>
      </v-card>
    </v-dialog>
</template>

<script setup>
import { useRoute, useRouter } from 'vue-router'

const dialog = ref(false);
const router = useRouter();

const isApplied = ref(false);

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
  const response = await apiClient.get(`registrations/class/${id}`, {

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
      getGosuClass(id);
      isApplied.value = true;
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

    const registData = await apiClient.get(`registrations`);
    console.log(registData);
    const registId = registData.data._embedded.registrations[0]._links.self.href.split('/').pop();


    const response = await apiClient.delete(`registrations/${registId}`);
    console.log(response);
    if (response.status === 204) {
      alert('강의 수강 취소가 완료되었습니다.');
      getGosuClass(id);
      isApplied.value = false;
      isExamApplied.value = false;
    }
  } catch (error) {
    console.error('강의 수강 취소 중 오류 발생:', error);
    alert('강의 수강 취소 중 오류가 발생했습니다. 나중에 다시 시도해주세요.');
  }
}

const isExamApplied = ref(false);
async function examApply() {
  isExamApplied.value = true;
  dialog.value = false;
}
</script>

<style scoped>
/* 스타일을 여기에 추가하세요 */
</style>
