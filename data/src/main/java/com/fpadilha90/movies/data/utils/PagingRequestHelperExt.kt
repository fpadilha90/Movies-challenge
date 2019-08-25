package com.fpadilha90.movies.data.utils

import androidx.lifecycle.MutableLiveData
import com.fpadilha90.movies.common.model.NetworkState
import com.fpadilha90.movies.data.utils.PagingRequestHelper

private fun getErrorMessage(report: com.fpadilha90.movies.data.utils.PagingRequestHelper.StatusReport): String {
    return com.fpadilha90.movies.data.utils.PagingRequestHelper.RequestType.values().mapNotNull {
        report.getErrorFor(it)?.message
    }.first()
}

fun com.fpadilha90.movies.data.utils.PagingRequestHelper.createStatusLiveData(): MutableLiveData<NetworkState> {
    val liveData = MutableLiveData<NetworkState>()
    addListener { report ->
        when {
            report.hasRunning() -> liveData.postValue(NetworkState.LOADING)
            report.hasError() -> liveData.postValue(
                    NetworkState.error(getErrorMessage(report)))
            else -> liveData.postValue(NetworkState.LOADED)
        }
    }
    return liveData
}
