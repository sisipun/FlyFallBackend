<template>
  <div class="score-list">
    <h1 class="score-list_title">Score</h1>
    <table class="score-list_table">
      <tr
        class="score-list_table_row"
        v-for="(score, index) in scores"
        v-bind:key="score.mobileId"
      >
        <td class="score-list_table_index">{{ index + 1 }}.</td>
        <td class="score-list_table_name">
          <router-link :to="{ name: 'userScore', params: { mobileId: score.mobileId } }">
            {{ score.name }}#{{ score.mobileId }}
          </router-link>
        </td>
        <td class="score-list_table_value">
          {{ score.value }}
        </td>
      </tr>
    </table>
    <div class="score-list_pagination">
      <button
        v-show="pageNumber > 0"
        @click="previousPage"
      >Previous</button>
      <button
        v-show="scores.length === pageSize"
        @click="nextPage"
      >
        Next
      </button>
    </div>
  </div>
</template>

<script>
import api from "../api"

export default {
  name: "ScoreList",
  data () {
    return {
      scores: [],
      pageNumber: 0,
      pageSize: 50,
    }
  },
  mounted () {
    this.getScores()
  },
  methods: {
    getScores () {
      this.scores = []
      api
        .get("/scores", {
          params: { page: this.pageNumber, size: this.pageSize },
        })
        .then((response) => (this.scores = this.scores.concat(response.data)))
    },
    previousPage () {
      this.pageNumber--
      this.getScores()
    },
    nextPage () {
      this.pageNumber++
      this.getScores()
    },
  },
}
</script>

<style lang="scss">
.score-list {
  &_table {
    width: 100%;
    padding-left: 20%;
    padding-right: 20%;

    &_value {
      text-align: right;
    }

    &_index {
      text-align: right;
    }
  }

  &_title {
    text-align: center;
  }

  &_pagination {
    text-align: center;
    margin: 1em;
  }
}
</style>