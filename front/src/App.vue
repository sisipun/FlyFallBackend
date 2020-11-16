<template>
  <ScoreList :scores="scores" />
</template>

<script>
import ScoreList from "./components/ScoreList.vue";
import api from "./api";

export default {
  name: "App",
  components: {
    ScoreList,
  },
  data() {
    return {
      scores: [],
    };
  },
  mounted() {
    this.getScores()
  },
  methods: {
    getScores() {
      this.scores = []
      api
        .get("/scores", { params: { page: 0, size: 50 } })
        .then(response => (this.scores = this.scores.concat(response.data)));
    },
  },
};
</script>
