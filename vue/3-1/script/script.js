const app =new Vue({
    el:'#app',
    data() {
        return {
            text:'hello Vue.js'
        };
    },
    methods: {
        handleClick() {
            this.text='button pushed';
        }
    }
})