<template>
  <div :class="$q.dark.isActive ? ' text-white' : 'field-container'">
    <div class="label">
      <q-icon v-if="help" class="help" name="help">
        <q-tooltip class="bg-info">{{ help }}</q-tooltip>
      </q-icon>
      <label>{{ label }}</label>
      <strong v-show="required" class="required">(*)</strong>
    </div>

    <div class="field">
      <slot></slot>
    </div>
  </div>
</template>

<script lang="ts">
export default {
  props: {
    label: String,
    required: Boolean,
    help: String,
  },
};
</script>

<style lang="scss" scoped>
.field-container {
  font-family: "Montserrat", sans-serif;

  .label {
    display: flex;
    width: 100%;
    justify-content: flex-start;
    align-items: center;

    .help {
      color: #0c9abe;
      margin-right: 5px;
    }

    label {
      margin-right: 10px;
      font-weight: bold;
      color: #4a5c60;
    }
    .required {
      color: #f12369;
    }
  }

  .field {
    flex: 1;
    width: 100%;
  }
}
</style>
