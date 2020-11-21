<template>
  <VEcharts
    class="user-score_chart"
    :option="option"
  ></VEcharts>
</template>

<script>
import { VEcharts } from "vue3-echarts"

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
        tooltip: {
          trigger: "axis",
          axisPointer: {
            animation: false,
          },
        },
        dataZoom: [
          {
            show: true,
            realtime: true,
          },
        ],
        xAxis: {
          type: "category",
          boundaryGap: false,
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
            symbolSize: 8,
            hoverAnimation: false,
          },
        ],
      }
    },
  },
}
</script>

<style lang="scss">
.user-score {
  &_chart {
    height: 500px;
  }
}
</style>