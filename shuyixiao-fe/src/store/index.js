import { createStore} from 'vuex'
import mutations from '../store/mutations'
import storage from '../utils/storage'

const state = {
  userInfo: storage.getItem("userInfo") || "",
}

export default createStore({
  state,
  mutations
})