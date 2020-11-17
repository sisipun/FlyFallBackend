<template>
  <form @submit.prevent="onSubmit">
    <input v-model="mobileId" />
    <input v-model="name" />
    <input v-model.number="value" />
    <input type="submit" value="Submit" />
    <div v-if="errors">
      <div v-for="error in errors" :key="error.field">
        {{ error.field }} {{ error.defaultMessage }}
      </div>
    </div>
  </form>
</template>


<script>
import api from "../api";

export default {
  name: "AddScoreForm",
  data() {
    return {
      mobileId: "",
      name: "",
      value: 0,
      errors: [],
    };
  },
  methods: {
    onSubmit() {
      this.errors = [];
      const score = {
        mobileId: this.mobileId,
        name: this.name,
        value: this.value,
      };

      api
        .post("scores", score)
        .then(() => {
          this.$emit("score-added");

          this.mobileId = "";
          this.name = "";
          this.value = 0;
        })
        .catch((error) => {
          const response = error.response;
          this.errors = response.data.errors;
        });
    },
  },
};
</script>