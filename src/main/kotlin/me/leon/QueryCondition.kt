package me.leon

import com.google.gson.annotations.SerializedName

/**
 * @author    Leon
 * @since     2020-03-12
 * @version   1.0.0
 **/
data class QueryCondition(var key: String, var value: String)


data class QueryList(
    val queryParams: QueryParams,
    val queryResult: QueryResult,
    val relWenshu: MutableMap<String, List<*>>
) {
    data class QueryParams(
        val collection: String,
        val facetLimit: Int,
        val groupFields: Any,
        val hbaseTable: String,
        val pageNum: Int,
        val pageSize: Int,
        val queryItemList: List<QueryItem>,
        val returnFields: String,
        val solrServiceType: Int,
        val sortFields: String
    )

    data class QueryItem(
        val id: String,
        val not: Boolean,
        val oper: String,
        val value: String
    )

    data class QueryResult(
        val groupFieldMap: GoupFieldMap,
        val resultCount: Int,
        val resultList: List<Result>
    )

    data class GoupFieldMap(val a: String) {}

    /**
     * 对数字key 做了单独的映射
     *
     * 1,2,7,9,10,26,31,32,43,44
     *
     *   9  10  32  44 请参考网页版
     */
    data class Result(
        @SerializedName("1")
        val casename: String,
        @SerializedName("2")
        val courtname: String,

//        @SerializedName("5")
//        val wenshuid: String,
        @SerializedName("7")
        val caseno: String,
        @SerializedName("26")
        val content: String,
        @SerializedName("31")
        val judgmentdate: String,

        @SerializedName("43")
        val type: String,

        @SerializedName("rowkey")
        val docId: String

    )

}

data class DocDetail(
    @SerializedName("DocInfoVo")
    val docInfoVo: DocInfoVo
) {
    data class DocInfoVo(
        val qwContent: String,
        val relWenshu: List<Any>,
        val viewCount: String
    )
}


fun String.b64() = Base64Utils.encode(this.toByteArray())