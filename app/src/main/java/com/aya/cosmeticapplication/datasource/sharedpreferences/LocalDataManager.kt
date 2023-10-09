package co.trevanta.ticksntravel.datasource.sharedpreferences

//import android.content.Context
//import co.trevanta.ticksntravel.datasource.beans.response.InformationResponseBean
//import co.trevanta.ticksntravel.datasource.constants.ProjectKeys.AUTH_HEADER
//
//import co.trevanta.ticksntravel.datasource.constants.SharedPreferenceKeys
//import co.trevanta.ticksntravel.datasource.constants.UserKeys
//import co.trevanta.ticksntravel.models.InformationResponseModel

//fun Context.setFirstTimeCheck() {
//    this.saveSp(SharedPreferenceKeys.FIRST_OPEN, false)
//}
//fun Context.getFirstTimeCheck(): Boolean {
//    return this.loadSp(SharedPreferenceKeys.FIRST_OPEN) ?: true
//}
//
//fun Context.savePrivateKey(privateKeyValue: String) {
//    this.saveSp(UserKeys.PRIVATE_KEY, privateKeyValue)
//}
//
//fun Context.getPrivateKey():String {
//    return this.loadSp(UserKeys.PRIVATE_KEY) ?: ""
//
//}
//
//
//
//
//fun Context.saveUserAuthToken(token: String) {
//    if (token.isEmpty()) {
//        this.saveSp(UserKeys.AUTH_TOKEN, "")
//    } else {
//        this.saveSp(UserKeys.AUTH_TOKEN, AUTH_HEADER + token)
//    }
//}
//
//
//fun Context.getUserAuthToken(): String {
//    return this.loadSp(UserKeys.AUTH_TOKEN) ?: ""
//}
//
//
//fun Context.getWalletAddress(): String {
//    return this.loadSp(UserKeys.WALLET_ADDRESS) ?: ""
//}
//fun Context.saveWalletAddress(walletAddress:String) {
//    this.saveSp(UserKeys.WALLET_ADDRESS, walletAddress)
//}
//fun Context.getUserID(): String {
//    return this.loadSp(UserKeys.USER_ID) ?: ""
//}
//fun Context.saveUserId(userId:String) {
//    this.saveSp(UserKeys.USER_ID, userId)
//}
//
//
//
//
//
//fun Context.saveUserInformationDataOnly(userLocalData: InformationResponseBean) {
//    this.saveSp(UserKeys.FIRST_NAME, userLocalData.firstName ?: "")
//    this.saveSp(UserKeys.LAST_NAME, userLocalData.lastName ?: "")
//    this.saveSp(UserKeys.USER_EMAIL, userLocalData.email ?: "")
//    this.saveSp(UserKeys.PASSPORT_NUM, userLocalData.passportNumber ?: "")
//    this.saveSp(UserKeys.NATIONALITY, userLocalData.nationality ?: "")
//    this.saveSp(UserKeys.GENDER, userLocalData.gender ?: "")
//    this.saveSp(UserKeys.PHONE_NUMBER, userLocalData.phone ?: "")
//    this.saveSp(UserKeys.ADDRESS_ONE, userLocalData.addressOne ?: "")
//    this.saveSp(UserKeys.ADDRESS_TWO, userLocalData.addressTwo ?: "")
//    this.saveSp(UserKeys.COUNTRY, userLocalData.country ?: "")
//    this.saveSp(UserKeys.CITY, userLocalData.city ?: "")
//    this.saveSp(UserKeys.PINECODE, userLocalData.pinCode ?: "")
//    this.saveSp(UserKeys.IS_MAIN, userLocalData.isMain ?: "")
//    this.saveSp(UserKeys.DATE_OF_BIRTH, userLocalData.birthday ?: "")
//    this.saveSp(UserKeys.PASSPORT_EXPIRE_AT, userLocalData.passportExpireAt ?: "")
//}
//
//
//fun Context.loadUserInformationDataOnly(): InformationResponseModel {
//    return InformationResponseModel(
//        firstName = this.loadSp(UserKeys.FIRST_NAME) ?: "",
//        lastName = this.loadSp(UserKeys.LAST_NAME) ?: "",
//        email = this.loadSp(UserKeys.USER_EMAIL) ?: "",
//        passportNumber = this.loadSp(UserKeys.PASSPORT_NUM) ?: "",
//        nationality = this.loadSp(UserKeys.NATIONALITY) ?: "",
//        gender = this.loadSp(UserKeys.GENDER) ?: "",
//        phone = this.loadSp(UserKeys.PHONE_NUMBER) ?: "",
//        addressOne = this.loadSp(UserKeys.ADDRESS_ONE) ?: "",
//        addressTwo = this.loadSp(UserKeys.ADDRESS_TWO) ?: "",
//        country = this.loadSp(UserKeys.COUNTRY) ?: "",
//        city = this.loadSp(UserKeys.CITY) ?: "",
//        pinCode = this.loadSp(UserKeys.PINECODE) ?: "",
//        isMain = this.loadSp(UserKeys.IS_MAIN) ?: "",
//        birthday = this.loadSp(UserKeys.DATE_OF_BIRTH) ?: "",
//        passportExpireAt = this.loadSp(UserKeys.PASSPORT_EXPIRE_AT) ?: ""
//    )
//
//}


//fun Context.saveBNBBalance(value:String) {
//    this.saveSp(Keys.WithdrawalInfoKeys.BNB_BALANCE, value)
//}
//
//
//fun Context.saveTOLBalance(value:String) {
//    this.saveSp(Keys.WithdrawalInfoKeys.TOL_BALANCE, value)
//}
//
//fun Context.saveUSDBalance(value:String) {
//    this.saveSp(Keys.WithdrawalInfoKeys.USD_BALANCE, value)
//}
//
//fun Context.getWithdrawalInformation(): WithdrawalInformation {
//    return WithdrawalInformation(
//        bnbBalance = this.loadSp(Keys.WithdrawalInfoKeys.BNB_BALANCE) ?: "",
//        usdBalance = this.loadSp(Keys.WithdrawalInfoKeys.USD_BALANCE) ?: "",
//        tolBalance =this.loadSp(Keys.WithdrawalInfoKeys.TOL_BALANCE) ?: "",
//    )
//}

//fun Context.saveUser(userLocalData: OTPResponseModel) {
//    this.saveSp(UserKeys.USER_ID,  userLocalData.user!!.id?:"")
//    this.saveSp(UserKeys.WALLET_ADDRESS, userLocalData.user!!.walletAddress?:"")
//
//    this.saveSp(UserKeys.FIRST_NAME, userLocalData.user!!.information.firstName ?: "")
//    this.saveSp(UserKeys.LAST_NAME, userLocalData.user!!.information.lastName ?: "")
//    this.saveSp(UserKeys.USER_EMAIL, userLocalData.user!!.information.email ?: "")
//    this.saveSp(UserKeys.PASSPORT_NUM, userLocalData.user!!.information.passportNumber ?: "")
//    this.saveSp(UserKeys.NATIONALITY, userLocalData.user!!.information.nationality ?: "")
//    this.saveSp(UserKeys.GENDER, userLocalData.user!!.information.gender ?: "")
//    this.saveSp(UserKeys.PHONE_NUMBER, userLocalData.user!!.information.phone ?: "")
//    this.saveSp(UserKeys.ADDRESS_ONE, userLocalData.user!!.information.addressOne ?: "")
//    this.saveSp(UserKeys.ADDRESS_TWO, userLocalData.user!!.information.addressTwo ?: "")
//    this.saveSp(UserKeys.COUNTRY, userLocalData.user!!.information.country ?: "")
//    this.saveSp(UserKeys.CITY, userLocalData.user!!.information.city ?: "")
//    this.saveSp(UserKeys.PINECODE, userLocalData.user!!.information.pinCode ?: "")
//    this.saveSp(UserKeys.IS_MAIN, userLocalData.user!!.information.isMain ?: "")
//    this.saveSp(UserKeys.DATE_OF_BIRTH, userLocalData.user!!.information.birthday ?: "")
//    this.saveSp(UserKeys.PASSPORT_EXPIRE_AT, userLocalData.user!!.information.passportExpireAt ?: "")
//
//
//
//
//
//
//
//
//
////    this.saveSp(UserKeys.USER_ADDRESS, userLocalData.user!!.address ?: "")
////    this.saveSp(UserKeys.DATE_OF_BIRTH, userLocalData.user.dob ?: "")
////    this.saveSp(UserKeys.USER_EMAIL, userLocalData.user.email!!)
////    this.saveSp(UserKeys.GENDER, userLocalData.user.gender ?: "")
////    this.saveSp(UserKeys.USER_ID, userLocalData.user.id ?: 0)
////    this.saveSp(UserKeys.FULL_NAME, userLocalData.user.name ?: "")
////    this.saveSp(UserKeys.PHONE_NUMBER, userLocalData.user.phone ?: "")
////    this.saveSp(UserKeys.REFERRAL_CODE, userLocalData.user.referral_code!!)
////    this.saveSp(UserKeys.USER_NAME, userLocalData.user.username!!)
////    this.saveSp(UserKeys.WALLET_ADDRESS, userLocalData.user.wallet_address!!)
//}










