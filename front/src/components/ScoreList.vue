<template>
  <div class="score-list">
    <h1 class="score-list-title">Score</h1>
    <table class="score-list-table">
      <tr class="score-list-table-row" v-for="(score, index) in scores" v-bind:key="score.mobileId">
        <td class="score-list-table-index">{{ index }}.</td>
        <td class="score-list-table-name">{{ score.name }}#{{ score.mobileId }}</td>
        <td class="score-list-table-value">{{ score.value }}</td>
      </tr>
    </table>
  </div>
</template>

<script>
export default {
  name: "ScoreList",
  props: {
    scores: {
      type: Array,
      required: true,
    },
  },
};
</script>

<style scoped>
.score-list-table {
  width: 100%;
  padding-left: 20%;
  padding-right: 20%;
}

.score-list-title {
  text-align: center;
}

.score-list-table-value {
  text-align: right;
}

.score-list-table-index  {
  text-align: right;
}
</style>