package com.aya.cosmeticapplication.datasource.retrofit.utils

import android.content.Context
import androidx.annotation.NonNull
import com.aya.cosmeticapplication.BuildConfig
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.Interceptor
import okhttp3.RequestBody
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import okio.Buffer
import java.io.IOException
import javax.inject.Inject

class AuthInterceptor @Inject constructor(
    @ApplicationContext val context: Context,
    private val auth: ApplicationAuth,
) : Interceptor {
    @Throws(Exception::class)
    override fun intercept(@NonNull chain: Interceptor.Chain): Response {
        var request = chain.request()

        val builder = request.newBuilder()
        val sid: String = auth.sid
        if (sid.isNotEmpty()) {
            logD("----debug----" + String.format("Token --> %s", sid))
            builder.addHeader("Authorization", sid)
        } else {
            logD("----debug----Token")
        }
       // builder.addHeader("Accept", "application/json")



        val postBodyString = bodyToString(request.body)

        request = builder.build()
        var response = handleAuthResponse(chain.proceed(request))

        response = processResponse(response)
        val bodyString = response.body!!.string()

        if (BuildConfig.DEBUG) {
            logH(
                (String.format(
                    " >>>><<<<<收到返回 \n%d %s", response.code,
                    ("request url " + response.request.url.toString() + "\n"
                            + "request body " + postBodyString + "\n"
                            + "response body " + bodyString)
                ))
            )
        }
        return processResponse(makeResponse(response, bodyString))
    }

    private fun processResponse(response: Response): Response {
        val statusCode = response.code
        val headerStatusCode = response.header("headerStatus")
//        if (statusCode.toString() == "503") {
//            val message = response.message
//            OpenSystemDownActivity()
//            try {
//                throw ScException(context, statusCode)
//            } catch (e: java.lang.Exception) {
//                logE(e.toString())
//                e.printStackTrace()
//            }
//        }
//        else if(statusCode.toString() == "401"){
//            context.logOut()
//            OpenAuthActivity()
//            try {
//                throw ScException(context, statusCode)
//            } catch (e: java.lang.Exception) {
//                logE(e.toString())
//                e.printStackTrace()
//            }
//        }

//        if (headerStatusCode != null) {
//            if (("607" == headerStatusCode)) {
//                try {
//                    throw ScException(context, headerStatusCode.toInt())
//                } catch (e: java.lang.Exception) {
//                    logE(e.toString())
//                    e.printStackTrace()
//                }
//            }
//            if (("605" == headerStatusCode)) {
//                try {
//                    throw ScException(context, headerStatusCode.toInt())
//                } catch (e: java.lang.Exception) {
//                    logE(e.toString())
//                    e.printStackTrace()
//                }
//            }
//        }

        return response
    }

    private fun bodyToString(request: RequestBody?): String {
        try {
            val buffer = Buffer()
            if (request != null) request.writeTo(buffer) else return ""
            return buffer.readUtf8()
        } catch (e: IOException) {
            return "did not work"
        }
    }

    private fun handleAuthResponse(response: Response): Response {

//        val authEndpoints = arrayOf(
//            "/api/registry/user", "/api/login", "/api/loginByCode", "/api/logout"
//        )

        if (!response.isSuccessful) return response
     //   if (!authEndpoints.contains(response.request.url.encodedPath)) return response

        //  if (response.request.url.encodedPath == "/api/logout") {
        //    performLogout()
//        } else {
//            val responseString = response.body?.string()!!
//            val result = Gson().fromJson<HttpResult<String>>(
//                responseString,
//                object : TypeToken<HttpResult<String>>() {}.type
//            )
//
//            if (!result.status) makeResponse(response, responseString)
//
//            result.data?.let {
//                auth.isLoggedIn = true
//                auth.sid = it
//            }
//
//            usedResponse = makeResponse(response, responseString)
//        }

        return response
    }
//    private fun OpenSystemDownActivity() {
//        val intent = Intent(context, SystemDownActivity::class.java)
//        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or
//                Intent.FLAG_ACTIVITY_CLEAR_TASK
//        context.startActivity(intent)
//    }
//    private fun OpenAuthActivity() {
//        val intent = Intent(context, AuthenticationActivity::class.java)
//        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or
//                Intent.FLAG_ACTIVITY_CLEAR_TASK
//        context.startActivity(intent)
//    }
    private fun makeResponse(response: Response, responseString: String): Response {
        return response.newBuilder()
            .code(200)
            .body(responseString.toResponseBody(response.body!!.contentType()))
            .build()
    }

}