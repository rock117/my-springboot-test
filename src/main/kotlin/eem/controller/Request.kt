package eem.controller

data class Request(val beginDate: String?, val methodType:String?=null,
                   val type:String? = null,
                   val endDate: String?, val currentPage: Int?, val pageSize:Int?)