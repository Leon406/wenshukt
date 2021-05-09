import me.leon.GsonUtil
import me.leon.OkHttpUtils
import me.leon.toJson

object Update {
    @JvmStatic
    fun main(args: Array<String>) {
        val post = OkHttpUtils.getInstance().post(
            "http://47.98.112.234:9091/appreleaseversion/updateInfo",
            mutableMapOf<String, String>(
                "clientType" to "android",
                "projectName" to "lawyeryuyao",
                "version" to "1.0.3"
            )
                .toJson(),
            Rsp::class.java
        )

        println(post.data.updateContent[0].replace("\\n","\n"))
    }
}