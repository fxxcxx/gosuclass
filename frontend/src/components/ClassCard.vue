<template>
  <div class="card" @mouseover="isHovered = true" @mouseleave="isHovered = false">
    <img class="image" src="@/assets/example-class1.jpg" alt="자바 프로그래밍" />
    <div class="title">자바 프로그래밍</div>
    <div class="footer">
      <span>10840</span>
      <span>초급</span>
      <button class="badge">자율</button>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue';

const isHovered = ref(false);
</script>

<style scoped>
.card {
  width: 320px;
  border: 1px solid #ccc;
  border-radius: 8px;
  overflow: hidden;
  transition: box-shadow 0.3s ease;
}

.card:hover {
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
}

.normal-state {
  text-align: center;
  padding: 10px;
}

.image {
  width: 100%;
  height: auto;
}

.title {
  font-size: 20px;
  font-weight: bold;
  margin: 10px 0;
}

.footer {
  display: flex;
  justify-content: space-between;
  padding: 0 10px;
}

.badge {
  background-color: #007bff;
  color: white;
  border: none;
  border-radius: 12px;
  padding: 5px 10px;
  font-size: 12px;
}

.hover-state {
  background-color: #333;
  color: white;
  padding: 15px;
  text-align: center;
}

.hover-title {
  font-size: 22px;
  font-weight: bold;
  margin-bottom: 10px;
}

.hover-content {
  font-size: 14px;
  line-height: 1.5;
}
</style>
