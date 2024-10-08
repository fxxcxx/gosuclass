<template>
  <v-footer height="60" app>
    <v-container class="genius-footer-container">
    <v-row class="">
      <v-col class="">
          <p class='genius-footer-text'>(주)케이티 경기도 성남시 분당구 불정로 90 (정자동 206번지)</p>
          <p class='genius-footer-text'>Copyright ⓒ2020 kt corp. All rights reserved.</p>
        </v-col>
        <v-col class="">
          <p class='genius-footer-text'>플랫폼 Help Desk 1588-3391 (1 > 1)</p>
          <p class='genius-footer-text'>(운영시간 : 평일 09시 ~ 18시)</p>
        </v-col>
        <v-col class='d-flex justify-end'>
          <v-btn variant="outlined" color="black" size="small" class="me-2">
          오픈소스 라이선스
        </v-btn>
        <v-btn variant="outlined" color="black" size="small" class="me-2">
          개인정보 처리방침
        </v-btn>
      </v-col>
    </v-row>
  </v-container>
  </v-footer>
</template>

<script setup>
</script>

<style scoped lang="sass">
.v-footer
  border-top: 1px solid #e0e0e0
.genius-footer-container
  max-width: 1400px
.genius-footer-text
  font-size: 12px
  color: #666666
  letter-spacing: -0.8px
</style>
