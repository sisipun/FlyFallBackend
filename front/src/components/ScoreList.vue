<template>
  <div class="score-list">
    <h1>Score</h1>
    <div v-for="(score, index) in scores" v-bind:key="score.name">
      {{ index + 1 + ". " + score.name + "#" + score.mobileId + " " + score.value }}
    </div>
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