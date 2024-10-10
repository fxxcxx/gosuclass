<template>
  <VContainer>
    <VRow>
      <VCol cols="12" class="d-flex justify-start">
        <span class="text-h6">{{ title }}</span>
      </VCol>
    </VRow>

    <VRow>
      <VCol cols="12" class="class-card-list">
        <ClassCard />
        <ClassCard />
        <ClassCard />
        <ClassCard />
      </VCol>
    </VRow>
  </VContainer>
</template>

<script setup>

const props = defineProps({
  title: {
    type: String,
    required: true
  }
});

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
