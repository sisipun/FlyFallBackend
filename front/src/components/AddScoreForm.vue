<template>
  <form @submit.prevent="onSubmit">
    <input v-model="mobileId" />
    <input v-model="name" />
    <input v-model.number="value" />
    <input type="submit" value="Submit" />
  </form>
</template>


<script>
import api from "./../api";

export default {
  name: "AddScoreForm",
  data() {
    return {
      mobileId: "",
      name: "",
      value: 0,
    };
  },
  methods: {
    onSubmit() {
      const score = {
        mobileId: this.mobileId,
        name: this.name,
        value: this.value,
      };

      api.post("scores", score).then(() => {
        this.$emit("score-added");

        this.mobileId = "";
        this.name = "";
        this.value = 0;
      });
    },
  },
};
</script>