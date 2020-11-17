<template>
  <div class="user-score">
    <h1 class="user-score-title">Hello {{ $route.params.mobileId }}</h1>
    <UserScoreChart :scores="scores" />
  </div>
</template>

<script>
import api from "../api";
import UserScoreChart from "./UserScoreChart";

export default {
  name: "UserScore",
  components: {
    UserScoreChart,
  },
  data() {
    return {
      scores: [],
    };
  },
  mounted() {
    this.getScores();
  },
  methods: {
    getScores() {
      this.scores = [];
      api.get(`/scores/${this.$route.params.mobileId}`).then((response) => {
        this.scores = this.scores.concat(response.data);
      });
    },
  },
};
</script>

<style scoped>
.user-score-title {
  text-align: center;
}
</style>