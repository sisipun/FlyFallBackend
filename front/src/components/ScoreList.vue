<template>
  <div class="score-list">
    <h1>Score</h1>
    <div v-for="(score, index) in scores" v-bind:key="score.name">
      {{ (index + 1) + ". " + score.name + " " + score.value }}
    </div>
  </div>
</template>

<script>
export default {
  name: "ScoreList",
  data() {
    return {
      scores: [
        { name: "Alex", value: 1000 },
        { name: "Max", value: 400 },
        { name: "John", value: 100 },
        { name: "Len", value: 95 },
      ],
    };
  },
};
</script>