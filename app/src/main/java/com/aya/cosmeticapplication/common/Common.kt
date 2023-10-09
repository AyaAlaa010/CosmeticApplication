package com.aya.cosmeticapplication.common

import android.content.*
import android.graphics.Bitmap
import android.graphics.Color
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.aya.cosmeticapplication.R
import com.google.android.material.snackbar.Snackbar

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import java.io.IOException
import java.nio.charset.Charset
import java.util.regex.Pattern


fun showSnackBar(view : View, message : String){
    val snack = Snackbar.make(view,message,Snackbar.LENGTH_LONG)
    snack.show()
}
fun formatNum(value:String):String{

  return  "%.2f".format(value.toDouble())
}
 fun checkNull(value:String,view: TextView){
    if(!value.equals("null")){
        view.setText(formatNum(value) +" TOL")

    }
    else{
        view.setText("0.00 TOL")

    }


}


 fun splitString(str:String,char:String):List<String>{
    var strList=str.split(char)
    return strList
}




fun isValidEmail(str: String): Boolean {
    return Pattern.compile(
        "[a-zA-Z\\d+._%\\-]{1,256}" +
                "@" +
                "[a-zA-Z\\d][a-zA-Z\\d\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z\\d][a-zA-Z\\d\\-]{0,25}" +
                ")+"
    ).matcher(str).matches()
}

fun isValidPassword(password: String): Boolean {
    return true
    //password.length in 8..24
//    return password != password.lowercase(Locale.getDefault()) && password != password.uppercase(Locale.getDefault()
//    ) && password.matches((".*\\d+.*").toRegex()) && password.length >= 8 && password.length <= 24
}
fun copyTextToClipBoard(mView: View, context: Context, value: String) {
    val clipboardManager = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    val clipData = ClipData.newPlainText("text", value)
    clipboardManager.setPrimaryClip(clipData)
    showSnackBar(mView, "Text copied to clipboard")
}


fun Button.enableButton() {
    this.alpha = 1F
    this.isEnabled = true
}

fun Button.disableButton() {
//    this.alpha = 0.5F
//    this.isEnabled = false //hint conflict in the design
    this.alpha = .8F
    this.isEnabled = false

}
fun isValidInput(s: String): Boolean {
    return s.isEmpty().not()
}
fun <T> Flow<T>.handleErrors(context:Context): Flow<T> =
    catch { Toast.makeText(context,(context.getString(R.string.something_went_wrong)),Toast.LENGTH_SHORT).show() }




fun loadJSONFromAsset(context: Context): String? {
    var json: String? = null
    try {
        val file = context.assets.open("countries.json")
        val size = file.available()
        val buffer = ByteArray(size)
        file.read(buffer)
        file.close()
        json = String(buffer, Charset.defaultCharset())//"UTF-8"
    } catch (ex: IOException) {
        ex.printStackTrace()
        return null
    }
    return json
}