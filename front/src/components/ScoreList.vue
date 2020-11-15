<template>
  <div class="score-list">
    <h1>Score</h1>
    <table>
      <tr v-for="(score, index) in scores" v-bind:key="score.mobileId">
        <td>{{ index }}.</td>
        <td>{{ score.name }}#{{ score.mobileId }}</td>
        <td>{{ score.value }}</td>
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