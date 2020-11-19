<template>
  <div class="user-score">
    <div class="user-score-header">
      <router-link :to="{ name: 'scoreList' }">
        Back
      </router-link>
      <h1 class="user-score-title">Score of {{ $route.params.mobileId }}</h1>
    </div>
    <UserScoreChart :scores="scores" />
  </div>
</template>

<script>
import api from "../api"
import UserScoreChart from "./UserScoreChart"

export default {
    name: "UserScore",
    components: {
        UserScoreChart,
    },
    data() {
        return {
            scores: [],
        }
    },
    mounted() {
        this.getScores()
    },
    methods: {
        getScores() {
            this.scores = []
            api.get(`/scores/${this.$route.params.mobileId}`).then((response) => {
                this.scores = this.scores.concat(response.data)
            })
        },
    },
}
</script>

<style scoped>
.user-score-title {
  text-align: center;
}
</style>