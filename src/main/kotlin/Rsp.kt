data class Rsp (val  msg:String,val code:Int, val data:UpdateBean){

    data class UpdateBean(val updateContent :MutableList<String>,val updateType:Int)
}