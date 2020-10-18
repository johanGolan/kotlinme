package com.johannainggolan.kotlinme.Utils

data class WrapperResponse<out T>(val status: ConsumeStatus, val data: T?, val message: String?) {

    companion object {

        fun <T> success(data: T?): WrapperResponse<T> {
            return WrapperResponse(ConsumeStatus.OK, data, null)
        }

        fun <T> error(msg: String, data: T?): WrapperResponse<T> {
            return WrapperResponse(ConsumeStatus.FAILED, data, msg)
        }

        fun <T> loading(data: T?): WrapperResponse<T> {
            return WrapperResponse(ConsumeStatus.ONPROGRESS, data, null)
        }

    }

}