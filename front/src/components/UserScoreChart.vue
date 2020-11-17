<template>
  <VEcharts class="user-score-chart" :option="option"></VEcharts>
</template>

<script>
import { VEcharts } from "vue3-echarts";

export default {
  name: "UserScoreChart",
  components: {
    VEcharts,
  },
  props: {
    scores: {
      type: Array,
      required: true,
    },
  },
  computed: {
    option: function () {
      return {
        xAxis: {
          type: "category",
          data: this.scores.map((score) =>
            new Date(score.creationDate).toDateString()
          ),
        },
        yAxis: {
          type: "value",
        },
        series: [
          {
            data: this.scores.map((score) => score.value),
            type: "line",
          },
        ],
      };
    },
  },
};
</script>

<style scoped>
.user-score-chart {
  height: 500px;
}
</style>