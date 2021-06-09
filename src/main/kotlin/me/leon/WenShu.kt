package me.leon


object WenShu {


    @JvmStatic
    fun main(args: Array<String>) {
        //无法获取数据 APP升级加入用户校验,无法获取
//        getList()
        //详情可以用手机端的接口
        getDetail("562110e60b3145099361ac8800c0aa89")
//        getDetail("fbb3658a336d4ebcbec6ac8300a33e87")

    }


    fun getList() {
        for (i in 1..1) {
            getDocList(i)
            Thread.sleep(3000)
        }
    }

    private fun getDocList(page: Int = 1, pageSize: Int = 200) {
        val params = mapOf(
            "pageNum" to page.toString(),
            "pageSize" to pageSize.toString(),
            "sortFields" to "s50:desc",
            "ciphertext" to Cipher.binary(),
            "devid" to "23a9c9828da443abbcfa8ab452201faa",
            "devtype" to 1.toString(),
            "queryCondition" to mutableListOf(
                QueryCondition("s8", "02"),
                QueryCondition("s2", "杭州互联网法院"),
                QueryCondition("s19", "张利民"),
                QueryCondition("s20", "陕西行中律师事务所"),
                QueryCondition("s21", "彩礼"),
                QueryCondition("cprqStart", "2020-10-27"),
                QueryCondition("cprqEnd", "2021-11-27"),
            )
        )


        val q = mapOf(
            "id" to Cipher.stamp,
            "command" to "queryDoc",
            "params" to params
        )


        val result = OkHttpUtils.getInstance()
            .postString(
                "http://wenshuapp.court.gov.cn/appinterface/rest.q4w",
                "request=${q.toJson().b64()}",
                WenShuRsp::class.java, null
            )
        println( result.data)
        result.data?.content?:return
        val decryptTxt = Encrypt.desDecrypt(result.data?.content, result.data?.secretKey)
        //这里是解密后的结果,
        println("这里是解密后的结果  $decryptTxt")

        val r = decryptTxt.fromJson<QueryList>()



        r.queryResult.resultList.also { println(it) }
            .map { it.caseno + it.casename }.forEach(::println)

        //自己根据 结果的docId 进行解析
//        r.queryResult.resultList.also { println(it) }
//                .map { getDetail(it.docId) }

    }


    fun getDetail(docId: String = "318e78a15f0e4d088a8aab9d00c350ec") {
        val params = mapOf(
            "ciphertext" to Cipher.binary(),
            "docId" to docId,
            "devid" to "23a9c9828da443abbcfa8ab452201faa", "devtype" to 1.toString()
        )

        val q = mapOf(
            "id" to Cipher.stamp,
            "command" to "docInfoSearch",
            "cfg" to "com.lawyee.judge.dc.parse.dto.SearchDataDsoDTO@docInfoSearch",
            "params" to params
        )


        val detail = OkHttpUtils.getInstance()
            .postString(
                "http://wenshuapp.court.gov.cn/appinterface/rest.q4w ",
                "request=${q.toJson().b64()}", WenShuRsp::class.java, null
            )
        val detailTxt = Encrypt.desDecrypt(detail.data?.content, detail.data?.secretKey)
        println(detailTxt)
        println(detailTxt.fromJson<DocDetail>())

    }
}