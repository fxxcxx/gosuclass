<template>
<v-row>
  <v-spacer></v-spacer>
  <v-col cols="6" class="d-flex justify-center py-10">
    <v-row>
    <v-col class="d-flex justify-center align-center"><span class="genius-edu-category-title">학습 카테고리</span></v-col>
    <v-col>
      <v-img src="@/assets/ico_bar_category_01.svg" alt="카테고리1" width="48" height="48" />
      <span class="genius-edu-category-subtitle">카테고리1</span>
    </v-col>

    <v-col>
      <v-img src="@/assets/ico_bar_category_02.svg" alt="카테고리2" width="48" height="48" />
      <span class="genius-edu-category-subtitle">카테고리2</span>
    </v-col>
    <v-col>
      <v-img src="@/assets/ico_bar_category_03.svg" alt="카테고리3" width="48" height="48" />
      <span class="genius-edu-category-subtitle">카테고리3</span>
    </v-col>
    <v-col>
      <v-img src="@/assets/ico_bar_category_04.svg" alt="카테고리4" width="48" height="48" />
      <span class="genius-edu-category-subtitle">카테고리4</span>
    </v-col>
    <v-col>
      <v-img src="@/assets/ico_bar_category_05.svg" alt="카테고리5" width="48" height="48" />
      <span class="genius-edu-category-subtitle">카테고리5</span>
    </v-col>
    </v-row>
  </v-col>
  <v-spacer></v-spacer>
</v-row>
</template>

<style scoped lang="sass">
.genius-edu-category-title
  font-size: 17px
  font-weight: 600
  color: #00000095
.genius-edu-category-subtitle
  font-size: 14px
  color: #000000
</style>

