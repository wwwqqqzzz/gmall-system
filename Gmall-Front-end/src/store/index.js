import Vuex from "vuex";
import Vue from "vue";
import router from "@/router";
Vue.use(Vuex)

const store = new Vuex.Store({
    state:{
        currentPathName:''
    },
    mutations:{
        setPath(state){
            state.currentPathName = localStorage.getItem("currentPathName")
        },
        logout(){
            localStorage.removeItem("user")
            localStorage.removeItem("menus")
            router.push("/login")
        //    重置路由

        }
    }
})

export default store