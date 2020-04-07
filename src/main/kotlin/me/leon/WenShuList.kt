package me.leon

/**
 * @author    Leon
 * @since     2020-03-12
 * @version   1.0.0
 **/
data class WenShuList(
    val `data`: Data,
    val ret: Ret
){
    data class Data(
            val content: String,
            val secretKey: String
    )

    data class Ret(
            val code: Int,
            val msg: String
    )
}

