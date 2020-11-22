import { createRouter, createWebHistory } from "vue-router"
import ScoreList from "./components/ScoreList"
import UserScore from "./components/UserScore"

export default createRouter({
    history: createWebHistory(),
    routes: [
        {
            path: "/scores/",
            name: "scoreList",
            component: ScoreList,
        },
        {
            path: "/scores/:mobileId",
            name: "userScore",
            component: UserScore
        },
    ],
})