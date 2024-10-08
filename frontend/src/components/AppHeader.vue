<template>
  <v-app-bar elevation="0" class="">
    <v-container class="genius-header-container">
      <v-row>
        <router-link to="/" class="d-flex align-center">
          <v-img src="@/assets/logo-w2.png" width="140" class="mr-12" />
        </router-link>

        <router-link to="/mypage">
          <v-btn variant="text" color="primary">마이페이지</v-btn>
        </router-link>
        <router-link to="/apply-class">
          <v-btn variant="text" color="black">강의신청</v-btn>
        </router-link>


        <router-link to="/create-class">
          <v-btn variant="text" color="black">강의개설</v-btn>
        </router-link>
        <v-spacer></v-spacer>
        <v-btn variant="text" color="black">로그아웃</v-btn>

      </v-row>
    </v-container>
  </v-app-bar>
</template>

<script setup>

</script>

<style scoped lang="scss">
.v-app-bar {
  border-bottom: 1px solid #e0e0e0;
}

.genius-header-container {
  max-width: 1400px;
}
</style>
