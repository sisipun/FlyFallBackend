<template>
  <div class="user-score">
    <div class="user-score_header">
      <button @click="$router.go(-1)">Back</button>
      <h1 class="user-score_header_title">
        Score of {{ $route.params.mobileId }}
      </h1>
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
  data () {
    return {
      scores: [],
    }
  },
  mounted () {
    this.getScores()
  },
  methods: {
    getScores () {
      this.scores = []
      api.get(`/scores/${this.$route.params.mobileId}`).then((response) => {
        this.scores = this.scores.concat(response.data)
      })
    },
  },
}
</script>

<style lang="scss">
.user-score {
  &_header {
    &_title {
      text-align: center;
    }
  }
}
</style>