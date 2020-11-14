<template>
  <form @submit.prevent="onSubmit">
    <input v-model="mobileId" />
    <input v-model="name" />
    <input v-model.number="value" />
    <input type="submit" value="Submit" />
  </form>
</template>


<script>
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

      this.$emit("score-added", score);

      this.mobileId = "";
      this.name = "";
      this.value = 0;
    },
  },
};
</script>