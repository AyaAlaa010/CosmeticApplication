package com.aya.cosmeticapplication.datasource.retrofit.utils

import java.io.IOException

class   NoConnectivityException : IOException() {
        override val message: String
            get() = "No Internet Connection"
}
