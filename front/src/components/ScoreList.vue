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
      <router-link
        v-show="pageNumber > 0"
        :to="{ name: 'scoreList', query: { page: pageNumber - 1, size: pageSize  } }"
        tag="button"
      >
        Previous
      </router-link>
      <router-link
        v-show="scores.length === pageSize"
        :to="{ name: 'scoreList', query: { page: pageNumber + 1, size: pageSize  } }"
        tag="button"
      >
        Next
      </router-link>
    </div>
  </div>
</template>

<script>
import api from "../api"

export default {
  name: "ScoreList",
  watch: {
    $route: 'getScores',
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
      api
        .get("/scores", {
          params: { page: this.pageNumber, size: this.pageSize },
        })
        .then((response) => {
          this.scores = this.scores.concat(response.data)
        })
    },
  },
  computed: {
    pageNumber: function () {
      return this.$route.query.page ? Number(this.$route.query.page) : 0
    },
    pageSize: function () {
      return this.$route.query.size ? Number(this.$route.query.size) : 3
    },
  }
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