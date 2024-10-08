<template>
  <VRow>
    <VCol>
      <MainBanner />
    </VCol>
  </VRow>
  <VRow>
    <VCol>
      <EduCategory />
    </VCol>
  </VRow>

  <VRow>
    <VCol class="d-flex justify-center">
      <ClassCardList :title="'😀 이런강의는 어떠세요?'" />
    </VCol>
  </VRow>

  <VRow>
    <VCol class="d-flex justify-center">
      <ClassCardList :title="'⏳ 마감이 얼마 남지 않았어요'" />
    </VCol>
  </VRow>
</template>

<script setup>

</script>
