<template>
  <ScoreList :scores="scores" />
  <AddScoreForm @score-added="getScores" />
</template>

<script>
import ScoreList from "./components/ScoreList.vue";
import AddScoreForm from "./components/AddScoreForm.vue";
import api from "./api";

export default {
  name: "App",
  components: {
    ScoreList,
    AddScoreForm,
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
