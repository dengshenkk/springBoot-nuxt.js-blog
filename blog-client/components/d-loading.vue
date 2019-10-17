<template>
  <div class="d-loading-wrap" v-if="value">
    <div class="bagua"></div>
  </div>
</template>

<script>
/**
 * create by    dengShen
 * createTime   2019/10/17 11:28:07
 */
export default {
  name: 'd-loading',
  props: {value: ''}
}
</script>

<style lang="scss" scoped>

  .d-loading-wrap {
    position: absolute;
    z-index: 2000;
    width: 100%;
    height: 100%;
    top: 0;
    right: 0;
    bottom: 0;
    left: 0;
    display: flex;
    align-items: center;
    justify-content: center;
    background-color: rgba(0, 0, 0, 0.5);


    $d: 40vmin;
    $line: linear-gradient(90deg, transparent 50%, transparent 0) 0/ 2em .25em repeat-x;

    .bagua {
      display: flex;
      align-items: center;
      width: $d;
      height: $d;
      border-radius: 50%;
      background: $line,
      linear-gradient(black 50%, white 0);


      -webkit-transition: all 1s;
      -moz-transition: all 1s;
      -ms-transition: all 1s;
      -o-transition: all 1s;
      transition: all 1s;
      animation: run 1s linear infinite;
      animation-delay: 1s;

      &:before, &:after {
        flex: 1;
        border: solid $d/6 transparent;
        height: $d/6;
        border-radius: 50%;
        background: $line,
        linear-gradient(black, black) content-box,
        linear-gradient(white, white) border-box;

        content: '';
      }

      &:before {
        animation: a1 2s ease-in-out;
      }

      &:after {
        background: $line,
        linear-gradient(white, white) content-box,
        linear-gradient(black, black) border-box;
        animation: a2 2s ease-in-out;
      }
    }

    @keyframes a1 {
      0% {
        transform: translateX(-100vw)
      }
      40%, 100% {
        transform: translateX(0)
      }
    }

    @keyframes a2 {
      0% {
        transform: translateX(100vw)
      }
      40%, 100% {
        transform: translateX(0)
      }
    }

    @keyframes run {
      0% {
        transform: rotate(0deg)
      }
      10% {
        transform: rotate(36deg)
      }
      20% {
        transform: rotate(72deg);
        box-shadow: 0 0 50px red;
      }
      30% {
        transform: rotate(108deg)
      }
      40% {
        transform: rotate(144deg)
      }
      50% {
        transform: rotate(180deg);
        box-shadow: 0 0 50px green;
      }
      60% {
        transform: rotate(216deg)
      }
      70% {
        transform: rotate(252deg)
      }
      80% {
        transform: rotate(288deg);
        box-shadow: 0 0 50px purple;
      }
      90% {
        transform: rotate(324deg)
      }
      100% {
        transform: rotate(360deg);
        box-shadow: 0 0 50px yellow;
      }
    }
  }
</style>
