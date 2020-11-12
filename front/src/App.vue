<template>
  <ScoreList :scores="scores"/>
  <AddScoreForm @score-added="addScore"/>
</template>

<script>
import ScoreList from './components/ScoreList.vue'
import AddScoreForm from './components/AddScoreForm.vue'

export default {
  name: 'App',
  components: {
    ScoreList,
    AddScoreForm,
  },
  data() {
    return {
      scores: [],
    }
  },
  methods: {
    addScore(score) {
      console.log(score)
      this.scores.push(score)
    }
  }
}
</script>
