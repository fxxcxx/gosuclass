<template>
  <VRow>
    <VCol>
      <GosuBanner></GosuBanner>
    </VCol>
  </VRow>
  <VContainer max-width="1400px">
    <v-data-table :items="items"></v-data-table>
  </VContainer>

</template>

<script setup>
  const items = [
    {
      분야: 'African Elephant',
      난이도: 'Loxodonta africana',
      클래스명: 'Herbivore',
      고수명: 'Savanna, Forests',
      모집기간: 'Savanna, Forests',
      학습기간: 'Savanna, Forests',
      학습시간: 'Savanna, Forests',
      상태: "모집중"
    },
    // ... more items
  ]
</script>
