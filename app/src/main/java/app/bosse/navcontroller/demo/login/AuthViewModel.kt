package app.bosse.navcontroller.demo.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

enum class AuthStatus {
    CONNECTED, EXPIRED, NOT_AUTHORIZED, UNKNOWN
}

class AuthViewModel : ViewModel() {
    val authStatus = MutableLiveData<AuthStatus>()

    init {
        update(AuthStatus.UNKNOWN)
    }

    fun update(status: AuthStatus) {
        authStatus.value = status
    }
}